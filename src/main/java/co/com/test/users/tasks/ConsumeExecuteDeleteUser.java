package co.com.test.users.tasks;

import co.com.test.users.interactions.ExecuteDelete;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.test.users.model.headers.GetHeaderModel.headersDefault;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ConsumeExecuteDeleteUser implements Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumeExecuteDeleteUser.class.getSimpleName());


    private final int parameterId;
    private final String endPoint;

    public ConsumeExecuteDeleteUser(String endPoint, int parameterId) {
        this.parameterId = parameterId;
        this.endPoint = endPoint;
    }

    public static ConsumeExecuteDeleteUser service(String endPoint, int parameterId){
        return Tasks.instrumented(ConsumeExecuteDeleteUser.class, endPoint, parameterId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteDelete.with(endPoint, parameterId,
                headersDefault()
        ));
        LOGGER.info("Response Body Is: ");
        lastResponse().getBody().prettyPeek();
    }
}
