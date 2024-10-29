package co.com.test.users.interactions;

import co.com.test.users.util.enums.HttpStatusCodes;
import co.com.test.users.util.exceptions.GenericRuntimeException;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import java.util.Map;

import static co.com.test.users.util.exceptions.AssertionsServices.EXCEPTION_ERROR_CONSUMPTION_SERVICE;

public class ExecuteDelete implements Interaction {
    private final String resource;
    private final Map<String, String> headers;
    private final int parameterId;

    public ExecuteDelete(String resource, int parameterId, Map<String, String> headers) {
        this.resource = resource;
        this.headers = headers;
        this.parameterId = parameterId;
    }

    public static ExecuteDelete with(String resource, int parameterId, Map<String, String> headers) {
        return Tasks.instrumented(ExecuteDelete.class, resource, parameterId, headers);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        SerenityRest.useRelaxedHTTPSValidation();
        actor.attemptsTo(Delete.from(resource + parameterId)
                .with(request -> request
                        .headers(headers)
                        .log()
                        .all()
                )
        );
        if (SerenityRest.lastResponse().statusCode() != HttpStatusCodes.DELETE.getHttpStatusCode()) {
            throw new GenericRuntimeException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
        }
    }
}
