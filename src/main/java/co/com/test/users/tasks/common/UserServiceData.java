package co.com.test.users.tasks.common;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static co.com.test.users.model.dto.UserData.consultServiceWithTheFollowingData;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UserServiceData implements Task {

    private  final List<String> data;

    public UserServiceData(List<String> data) {
        this.data = data;
    }

    public static UserServiceData getInformationServiceUser(List<String> data){
        return instrumented(UserServiceData.class, data);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
            consultServiceWithTheFollowingData(data);
    }
}
