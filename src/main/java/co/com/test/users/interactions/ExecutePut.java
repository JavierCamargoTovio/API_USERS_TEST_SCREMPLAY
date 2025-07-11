package co.com.test.users.interactions;

import co.com.test.users.model.dto.UserModel;
import co.com.test.users.util.exceptions.AssertionsServices;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.apache.http.HttpStatus;

import java.util.Map;

import static co.com.test.users.util.exceptions.AssertionsServices.EXCEPTION_ERROR_CONSUMPTION_SERVICE;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ExecutePut implements Interaction {

    private final String resource;
    private final Map<String, String> parametersId;
    private final UserModel body;
    private final Map<String, String> headers;

    public ExecutePut(String resource, Map<String, String> parametersId, Map<String, String> headers, UserModel body) {
        this.resource = resource;
        this.parametersId = parametersId;
        this.body = body;
        this.headers = headers;
    }
    public static ExecutePut with(String resource, Map<String, String> parametersId, Map<String, String> headers, UserModel body) {
        return Tasks.instrumented(ExecutePut.class, resource, parametersId, headers, body);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        SerenityRest.useRelaxedHTTPSValidation();

        actor.attemptsTo(
                Put.to(resource)
                .with(request -> request
                        .queryParams(parametersId)
                        .headers(headers)
                        .body(body)
                        .log()
                        .all()
                )
        );
        if(SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK){
            throw new AssertionsServices(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
        }
        lastResponse().peek();
    }

}
