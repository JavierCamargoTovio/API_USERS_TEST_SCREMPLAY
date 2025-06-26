package co.com.test.users.interactions;

import co.com.test.users.util.enums.HttpStatusCodes;
import co.com.test.users.util.exceptions.GenericRuntimeException;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static co.com.test.users.util.exceptions.AssertionsServices.EXCEPTION_ERROR_CONSUMPTION_SERVICE;

public class ExecuteGetPathParameter implements Interaction {

    private final String resource;
    private final String parameter;

    public ExecuteGetPathParameter(String resource, String parameter) {
        this.resource = resource;
        this.parameter = parameter;
    }

    public static ExecuteGetPathParameter service(String resource, String parameter) {
        return new ExecuteGetPathParameter(resource,parameter );
    }


    @Step("{0} executes a GET on the resource #resource with parameters #parameters")
    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        SerenityRest.useRelaxedHTTPSValidation();
        actor.attemptsTo(Get.resource(resource +"{nombreParametro}")
                .with(request -> request
                        .pathParam("nombreParametro", parameter)
                )
        );
        if (SerenityRest.lastResponse().statusCode() != HttpStatusCodes.OK.getHttpStatusCode()) {
            throw new GenericRuntimeException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
        }
    }
}
