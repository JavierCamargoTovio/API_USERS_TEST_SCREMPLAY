package co.com.test.users.interactions;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ExecuteGet implements Interaction {
    private String resource;

    public ExecuteGet(String resource) {
        this.resource = resource;
    }
    public static ExecuteGet service(String resource) {
        return instrumented(ExecuteGet.class, resource);
    }

    @Step("{0} executes a GET on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        SerenityRest.useRelaxedHTTPSValidation();
        actor.attemptsTo(Get.resource(resource)
                .with(request -> request
                        .contentType(ContentType.JSON)
                        .log()
                        .all()
                )
        );
        lastResponse().peek();
    }
}
