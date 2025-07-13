package co.com.test.users.tasks;

import co.com.test.users.interactions.ExecutePost;
import co.com.test.users.model.dto.CreateUserDTO;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static co.com.test.users.model.headers.GetHeaderModel.headersApiKey;
import static co.com.test.users.util.common.JsonUtils.parseJsonObject;
import static co.com.test.users.util.constants.ConstantServices.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeExecutePostUser implements Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumeExecutePostUser.class.getSimpleName());

    private final String endpointResource;
    private final CreateUserDTO usuario;

    public ConsumeExecutePostUser(String endpointResource, CreateUserDTO usuario) {
        this.endpointResource = endpointResource;
        this.usuario = usuario;
    }

    public static ConsumeExecutePostUser withInformationRequested(String endpointResource, CreateUserDTO usuario) {
        return instrumented(ConsumeExecutePostUser.class, endpointResource, usuario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(ExecutePost.with(endpointResource,
                headersApiKey(),
                usuario));

        LOGGER.info("Response Body Is: {}", lastResponse().getBody().asString());
        lastResponse().getBody().prettyPeek();

        String userId = parseJsonObject(lastResponse().getBody().asString()).get("id").getAsString();
    
        LOGGER.info("User Id is: {}", userId);
        actor.remember(KEY_USER_ID, userId);
       

    }

}
