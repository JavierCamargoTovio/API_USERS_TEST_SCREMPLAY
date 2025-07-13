package co.com.test.users.questions;

import co.com.test.users.model.dto.GetDataUserModel;
import co.com.test.users.model.dto.GetUserData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.hamcrest.Matchers;

import static co.com.test.users.util.constants.ConstantServices.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class TheQueryFieldsAndValuesAre implements Question<Boolean> {


    public static TheQueryFieldsAndValuesAre expected() {
        return new TheQueryFieldsAndValuesAre();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String keyMapFormat = "%s.%s";
        int id = Integer.parseInt(GetDataUserModel.getDataFieldsUserModel(GetUserData.getDataServiceUser(),"id"));

        actor.should(
                seeThatResponse("Validation fields values user service",
                        response -> response
                                .assertThat()
                                .and().body(String.format(keyMapFormat, KEY_USER_DATA, KEY_USER_ID), Matchers.equalTo(id))
                                .and().body(String.format(keyMapFormat, KEY_USER_DATA, KEY_USER_EMAIL), Matchers.equalTo(GetUserData.getDataServiceUser().get("email").toString()))
                                .and().body(String.format(keyMapFormat, KEY_USER_DATA, KEY_USER_FIRST_NAME), Matchers.equalTo(GetUserData.getDataServiceUser().get("first_name").toString()))
                                .and().body(String.format(keyMapFormat, KEY_USER_DATA, KEY_USER_LAST_NAME), Matchers.equalTo(GetUserData.getDataServiceUser().get("last_name").toString()))
                                .and().body(String.format(keyMapFormat, KEY_USER_DATA, KEY_USER_AVATAR), Matchers.equalTo(GetUserData.getDataServiceUser().get("avatar").toString()))

                ));
        return true;


    }
}
