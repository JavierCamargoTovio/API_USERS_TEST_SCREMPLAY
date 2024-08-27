package co.com.test.users.tasks.common;

import co.com.test.users.interactions.ExecuteGetParameters;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import java.util.Map;

import static co.com.test.users.model.headers.GetHeaderModel.headersDefault;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUser_Task implements Task {
    private final String endpointResource;
    private final Map<String, String> parameters;


    public GetUser_Task(String endpointResource, Map<String, String> parameters) {
        this.endpointResource = endpointResource;
        this.parameters = parameters;

    }

    public static GetUser_Task with(String endpointResource, Map<String, String> parameters) {
        return instrumented(GetUser_Task.class, endpointResource, parameters);
    }

    @Step("{0} consume service with the GET")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ExecuteGetParameters
                        .service(endpointResource)
                        .withParameterHeader(parameters, headersDefault())
        );
        lastResponse().getBody().prettyPeek();
    }
}
