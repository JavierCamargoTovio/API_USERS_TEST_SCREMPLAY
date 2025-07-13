package co.com.test.users.interactions;

import co.com.test.users.model.dto.CreateUserDTO;
import co.com.test.users.util.exceptions.AssertionsServices;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpStatus;

import java.util.Map;

import static co.com.test.users.util.exceptions.AssertionsServices.EXCEPTION_ERROR_CONSUMPTION_SERVICE;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ExecutePost implements Interaction {

    private final Object object;
    private final String resource;
    private final Map<String, String> headers;

    public ExecutePost(Object object, String resource, Map<String, String> headers) {
        this.object = object;
        this.resource = resource;
        this.headers = headers;
    }

    public ExecutePost(String resource, Map<String, String> headers, Object object) {
        this.resource = resource;
        this.object = object;
        this.headers = headers;
    }

    public static ExecutePost with(String resource, Map<String, String> headers, CreateUserDTO usuario) {
        return Tasks.instrumented(ExecutePost.class, resource, headers,usuario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        SerenityRest.useRelaxedHTTPSValidation();
        actor.attemptsTo(Post.to(resource)
                .with(request -> request
                        .headers(headers)
                        .body(object)
                        .relaxedHTTPSValidation()
                        .log()
                        .all()
                )
        );
        if(SerenityRest.lastResponse().statusCode() != HttpStatus.SC_CREATED){
            throw new AssertionsServices(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
        }
        lastResponse().peek();
    }


}
