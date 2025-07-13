package co.com.test.users.tasks.common;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import java.util.List;

import static co.com.test.users.model.dto.CreateAndUpdateUserData.dataCreateAndUpdateServiceWithTheFollowing;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateUpdateUserServiceData implements Task {

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
