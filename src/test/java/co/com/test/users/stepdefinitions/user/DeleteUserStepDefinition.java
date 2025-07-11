package co.com.test.users.stepdefinitions.user;

import co.com.test.users.questions.common.StatusCodeResponse;
import co.com.test.users.tasks.ConsumeExecuteDeleteUser;
import co.com.test.users.util.enums.HttpStatusCodes;
import co.com.test.users.util.exceptions.AssertionsServices;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.test.users.environment.Endpoints.DELETE_USER;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteUserStepDefinition {

    @When("el tester realiza la solicitud para la eliminación del usuario con parametro {string}")
    public void elTesterRealizaLaSolicitudParaLaEliminaciónDelUsuarioConParametro(String idUsuario) {
        theActorInTheSpotlight().attemptsTo(
                ConsumeExecuteDeleteUser.service(
                        DELETE_USER, Integer.parseInt(idUsuario)
                ));
    }

    @Then("el tester verifica que se elimino el usuario en el sistema")
    public void elTesterVerificaQueSeEliminoElUsuarioEnElSistema() {
        theActorInTheSpotlight().should(
                seeThat(StatusCodeResponse.httpResponseStatusCodeIs(HttpStatusCodes.DELETE.getHttpStatusCode()))
                        .orComplainWith(AssertionsServices.class, AssertionsServices.THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED));
    }
}
