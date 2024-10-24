package co.com.test.users.tasks;

import co.com.test.users.interactions.ExecutePost;
import co.com.test.users.model.dto.CreateAndUpdateUserData;
import co.com.test.users.model.dto.GetDataUserModel;
import co.com.test.users.model.dto.UserModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.test.users.model.dto.CreateAndUpdateUserData.getCreateAndUpdateDataServiceUser;
import static co.com.test.users.model.headers.GetHeaderModel.headersDefault;
import static co.com.test.users.util.common.JsonUtils.parseJsonObject;
import static co.com.test.users.util.constants.ConstantServices.KEY_USER_ID;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeExecutePostUser implements Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumeExecutePostUser.class.getSimpleName());

    private final String endpointResource;


    public ConsumeExecutePostUser(String endpointResource) {
        this.endpointResource = endpointResource;
    }
    public static ConsumeExecutePostUser withInformationRequested(String endpointResource) {
        return instrumented(ConsumeExecutePostUser.class, endpointResource);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecutePost.with(endpointResource,
                headersDefault(),
                new UserModel.UserBuilder()
                        .isWithName(GetDataUserModel.getDataFieldsUserModel(getCreateAndUpdateDataServiceUser(), "name"))
                        .isWithJob(GetDataUserModel.getDataFieldsUserModel(getCreateAndUpdateDataServiceUser(), "job"))
                        .build()

        ));
        LOGGER.info("Response Body Is: ");
        lastResponse().getBody().prettyPeek();

        String userId = parseJsonObject(lastResponse().getBody().asString()).get("id").getAsString();
        LOGGER.info("User Id is: {}", userId);
        Actor.named("Javier").remember(KEY_USER_ID, userId);
    }


}
