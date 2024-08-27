package co.com.test.users.questions;

import co.com.test.users.model.dto.UserData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.hamcrest.Matchers;

import static co.com.test.users.util.constants.ConstantServices.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ValidateUserService implements Question<Boolean> {


    public static ValidateUserService expected() {
        return new ValidateUserService();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String keyMapFormat = "%s.%s";
        int id = Integer.parseInt(UserData.getDataServiceUser().get("id").toString());
        actor.should(
                seeThatResponse("Validation fields values user service",
                        response -> response
                                .assertThat()
                                .and().body(String.format(keyMapFormat, KEY_USER_DATA, KEY_USER_ID), Matchers.equalTo(id))
                                .and().body(String.format(keyMapFormat, KEY_USER_DATA, KEY_USER_EMAIL), Matchers.equalTo(UserData.getDataServiceUser().get("email").toString()))
                                .and().body(String.format(keyMapFormat, KEY_USER_DATA, KEY_USER_FIRST_NAME), Matchers.equalTo(UserData.getDataServiceUser().get("first_name").toString()))
                                .and().body(String.format(keyMapFormat, KEY_USER_DATA, KEY_USER_LAST_NAME), Matchers.equalTo(UserData.getDataServiceUser().get("last_name").toString()))
                                .and().body(String.format(keyMapFormat, KEY_USER_DATA, KEY_USER_AVATAR), Matchers.equalTo(UserData.getDataServiceUser().get("avatar").toString()))

                ));
        return true;


    }
}
