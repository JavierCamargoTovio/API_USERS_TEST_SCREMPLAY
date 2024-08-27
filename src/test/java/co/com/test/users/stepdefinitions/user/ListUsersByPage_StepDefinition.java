package co.com.test.users.stepdefinitions.user;

import co.com.test.users.questions.common.Schema;
import co.com.test.users.tasks.common.GetUser_Task;
import co.com.test.users.util.exceptions.AssertionsServices;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.test.users.util.enums.NameSchema.GET_USERS_LIST;
import static co.com.test.users.util.environment.Endpoints.GET_ALL_USERS;
import static co.com.test.users.model.parameters.GetParameterModel.parametroPage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ListUsersByPage_StepDefinition {


    @When("realizo la solicitud por el metodo GET para obtener la pagina {string} de usuarios")
    public void realizoLaSolicitudPorElMetodoGETParaObtenerLaDeUsuarios(String pagina) {
        theActorInTheSpotlight().attemptsTo(GetUser_Task.with(GET_ALL_USERS, parametroPage(pagina)));

    }

    @Then("se debera obtener la repuesta exitosa de la lista de usuario")
    public void seDeberaObtenerLaRepuestaExitosaDeLaListaDeUsuario() {
         theActorInTheSpotlight().should(seeThat(Schema.theJsonSchemaExpectIs(GET_USERS_LIST.getNameSchema())).orComplainWith(AssertionsServices.class, AssertionsServices.THE_SCHEMA_SERVICE_IS_NOT_EXPECTED));
    }


}
