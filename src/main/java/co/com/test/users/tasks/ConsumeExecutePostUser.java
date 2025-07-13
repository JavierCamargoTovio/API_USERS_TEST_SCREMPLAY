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
    private final String name;
    private final String job;


    public ConsumeExecutePostUser(String endpointResource, String name, String job) {
        this.endpointResource = endpointResource;
        this.name = name;
        this.job = job;
    }


    public static ConsumeExecutePostUser withInformationRequested(String endpointResource,  String name, String job) {
        return instrumented(ConsumeExecutePostUser.class, endpointResource, name, job);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        CreateUserDTO usuario = new CreateUserDTO();
        usuario.setName(name);
        usuario.setJob(job);

        actor.attemptsTo(ExecutePost.with(endpointResource,
                headersApiKey(),
             usuario));

        LOGGER.info("Response Body Is: ");
        lastResponse().getBody().prettyPeek();

        String userId = parseJsonObject(lastResponse().getBody().asString()).get("id").getAsString();
        String name = parseJsonObject(lastResponse().getBody().asString()).get("name").getAsString();
        LOGGER.info("User Id is: {}", userId);
        actor.remember(KEY_USER_ID, userId);
        actor.remember(KEY_USER_NAME, name);

    }


}
