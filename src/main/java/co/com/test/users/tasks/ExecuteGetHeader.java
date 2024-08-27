package co.com.test.users.tasks;

import co.com.test.users.interactions.GetWithHeader;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ExecuteGetHeader implements Task {
    private final String endpointResource;
    private  final String token;
    private final String authorization;

    public ExecuteGetHeader(String endpointResource, String token, String authorization) {
        this.endpointResource = endpointResource;
        this.token = token;
        this.authorization = authorization;
    }

    public static ExecuteGetHeader service(String endpointResource, String authorization, String token) {
        return instrumented(ExecuteGetHeader.class, endpointResource, authorization,token);
    }

    @Override
    @Step("{0} consume service /user/")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(GetWithHeader.service(endpointResource, authorization,token));
    }
}
