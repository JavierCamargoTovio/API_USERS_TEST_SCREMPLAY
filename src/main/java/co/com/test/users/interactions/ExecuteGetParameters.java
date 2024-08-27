package co.com.test.users.interactions;

import co.com.test.users.util.exceptions.GenericRuntimeException;
import co.com.test.users.util.enums.HttpStatusCodes;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import java.util.Map;

import static co.com.test.users.util.exceptions.AssertionsServices.EXCEPTION_ERROR_CONSUMPTION_SERVICE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ExecuteGetParameters implements Interaction {
    private final String resource;
    private final Map<String, String> headers;
    private final Map<String, String> parameters;
    public ExecuteGetParameters(String resource, Map<String, String> parameters, Map<String, String> headers) {
        this.resource = resource;
        this.parameters = parameters;
        this.headers = headers;
    }


    public static ExecuteGetParameters withParameter(String resource, Map<String, String> parameters, Map<String, String> headers) {
        return instrumented(ExecuteGetParameters.class, resource, parameters, headers);
    }

    @Step("{0} executes a GET on the resource #resource with parameters #parameters")
    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        SerenityRest.useRelaxedHTTPSValidation();
        actor.attemptsTo(Get.resource(resource)
                .with(request -> request
                        .headers(headers)
                        .queryParams(parameters)
                        .log()
                        .all()
                )
        );
        if (SerenityRest.lastResponse().statusCode() != HttpStatusCodes.OK.getHttpStatusCode()) {
            throw new GenericRuntimeException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
        }
    }
    public static GetServiceBuilder service(String resource) {
        return new GetServiceBuilder(resource);
    }

    public static class GetServiceBuilder {
        private final String resource;

        public GetServiceBuilder(String resource) {
            this.resource = resource;
        }

        public Performable withParameter(Map<String, String> parameters) {
            return instrumented(ExecuteGetParameters.class, resource, parameters);
        }

        public Performable withParameterHeader( Map<String, String> parameters, Map<String, String> headers) {
            return instrumented(ExecuteGetParameters.class, resource, parameters, headers);
        }
    }

}
