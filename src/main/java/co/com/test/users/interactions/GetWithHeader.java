package co.com.test.users.interactions;

import co.com.test.users.tasks.ExecuteGetHeader;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
public class GetWithHeader implements Interaction {
    private final String endpointResource;
    private final String token;
    private final String authorization;


    public GetWithHeader(String endpointResource, String token, String authorization) {
        this.endpointResource = endpointResource;
        this.token = token;
        this.authorization = authorization;
    }

    public static ExecuteGetHeader service(String resource, String authorization, String token ) {
        return new ExecuteGetHeader(resource, authorization, token);
    }

    @Step("{0} executes a GET on the resource #resource with header")
    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        SerenityRest.useRelaxedHTTPSValidation();
        actor.attemptsTo(Get.resource(endpointResource)
                .with(request -> request
                        .contentType(ContentType.JSON)
                        .headers("Authorization", authorization, "UToken",token  )
                        .log()
                        .all()
                )
        );
        lastResponse().peek();
    }


}
