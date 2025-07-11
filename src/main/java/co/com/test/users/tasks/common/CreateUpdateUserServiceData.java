package co.com.test.users.tasks.common;

import co.com.test.users.tasks.ConsumeExecutePostUser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static co.com.test.users.model.dto.CreateAndUpdateUserData.dataCreateAndUpdateServiceWithTheFollowing;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateUpdateUserServiceData implements Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumeExecutePostUser.class.getSimpleName());

    private  final List<String> data;

    public CreateUpdateUserServiceData(List<String> data) {
        this.data = data;
    }

    public static CreateUpdateUserServiceData getInformationServiceUserCreateAndUpdate(List<String> data){
        return instrumented(CreateUpdateUserServiceData.class, data);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        dataCreateAndUpdateServiceWithTheFollowing(data);

    }
}
