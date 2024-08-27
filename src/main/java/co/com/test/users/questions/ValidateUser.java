package co.com.test.users.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.hamcrest.Matchers;

import static co.com.test.users.util.constants.ConstantServices.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ValidateUser implements Question<Boolean> {

    private final int id;
    private final String email;
    private final String first_name;
    private final String last_name;
    private final String avatar;

    private ValidateUser(int id, String email, String firstName, String lastName, String avatar) {
        this.id = id;
        this.email = email;
        this.first_name = firstName;
        this.last_name = lastName;
        this.avatar = avatar;
    }

    public static ValidateUser expected(int id, String email, String first_name, String last_name, String avatar) {
        return new ValidateUser(id, email, first_name, last_name, avatar);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String keyMapFormat = "%s.%s";

        actor.should(
                seeThatResponse("Validation fields values user service",
                        response -> response
                                .assertThat()
                                .and().body(String.format(keyMapFormat, KEY_USER_DATA, KEY_USER_ID), Matchers.equalTo(id))
                                .and().body(String.format(keyMapFormat, KEY_USER_DATA, KEY_USER_EMAIL), Matchers.equalTo(email))
                                .and().body(String.format(keyMapFormat, KEY_USER_DATA, KEY_USER_FIRST_NAME), Matchers.equalTo(first_name))
                                .and().body(String.format(keyMapFormat, KEY_USER_DATA, KEY_USER_LAST_NAME), Matchers.equalTo(last_name))
                                .and().body(String.format(keyMapFormat, KEY_USER_DATA, KEY_USER_AVATAR), Matchers.equalTo(avatar))
                ));
        return true;


    }
}
