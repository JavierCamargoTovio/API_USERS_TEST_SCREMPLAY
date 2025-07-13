package co.com.test.users.questions;

import co.com.test.users.model.dto.CreateUserDTO;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static co.com.test.users.util.common.JsonUtils.parseJsonObject;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

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
