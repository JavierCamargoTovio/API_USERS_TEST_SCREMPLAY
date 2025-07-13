package co.com.test.users.questions;

import co.com.test.users.model.dto.CreateUserDTO;
import co.com.test.users.model.dto.UserModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.test.users.questions.common.GetValueFromResponseBodyQuestion.theAttributeValue;
import static co.com.test.users.util.common.JsonUtils.parseJsonObject;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ValidateUserCreate  implements Question<CreateUserDTO> {


    public static ValidateUserCreate verificarUsuarioCreado(){
        return new ValidateUserCreate();
    }

    @Override
    public CreateUserDTO answeredBy(Actor actor) {

        String name = parseJsonObject(lastResponse().getBody().asString()).get("name").getAsString();
        String job = parseJsonObject(lastResponse().getBody().asString()).get("job").getAsString();
        return new CreateUserDTO(name,job);
    }
}
