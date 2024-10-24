package co.com.test.users.tasks.common;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static co.com.test.users.model.dto.GetUserData.consultServiceWithTheFollowingData;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUserServiceData implements Task {

    private final List<String> data;

    public GetUserServiceData(List<String> data) {
        this.data = data;
    }

    public static GetUserServiceData getInformationServiceUser(List<String> data) {
        return instrumented(GetUserServiceData.class, data);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        consultServiceWithTheFollowingData(data);
    }
}
