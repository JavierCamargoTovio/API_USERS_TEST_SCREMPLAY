package co.com.test.users.tasks;

import co.com.test.users.interactions.ExecutePut;
import co.com.test.users.model.dto.GetDataUserModel;
import co.com.test.users.model.dto.UserModel;
import com.jayway.jsonpath.DocumentContext;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;
import static co.com.test.users.model.dto.CreateAndUpdateUserData.getCreateAndUpdateDataServiceUser;
import static co.com.test.users.util.common.JsonUtils.parseDocumentContextFromString;
import static co.com.test.users.util.constants.ConstantServices.RESPONSE_BODY;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeExecutePutUser implements Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumeExecutePutUser.class.getSimpleName());

    private final String endpointResource;
    private final Map<String, String> parameters;
    private final Map<String, String> headers;

    public ConsumeExecutePutUser(String endpointResource, Map<String, String> parameters, Map<String, String> headers) {
        this.endpointResource = endpointResource;
        this.parameters = parameters;
        this.headers = headers;
    }
    public static ConsumeExecutePutUser withInformationRequestedUpdateUser(String endpointResource, Map<String, String> parameters, Map<String, String> headers) {
        return instrumented(ConsumeExecutePutUser.class, endpointResource, parameters, headers);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecutePut.with(endpointResource,parameters,
                headers,
                new UserModel.UserBuilder()
                        .isWithName(GetDataUserModel.getDataFieldsUserModel(getCreateAndUpdateDataServiceUser(),"name"))
                        .isWithJob(GetDataUserModel.getDataFieldsUserModel(getCreateAndUpdateDataServiceUser(),"job"))
                        .build()

        ));
        LOGGER.info("Response Body Is: ");
        lastResponse().getBody().prettyPeek();

        String response = lastResponse().getBody().asPrettyString();
        DocumentContext documentContextResponse = parseDocumentContextFromString(response);
        Actor.named("Javier").remember(RESPONSE_BODY, documentContextResponse);
    }



}
