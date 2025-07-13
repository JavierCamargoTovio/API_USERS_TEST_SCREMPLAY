package co.com.test.users.stepdefinitions.user;

import co.com.test.users.model.dto.CreateUserDTO;
import co.com.test.users.questions.ValidateUserCreate;
import co.com.test.users.questions.common.StatusCodeResponse;
import co.com.test.users.tasks.ConsumeExecutePostUser;
import co.com.test.users.tasks.ValidateInCraeteAndUpdateUser;
import co.com.test.users.util.enums.HttpStatusCodes;
import co.com.test.users.util.exceptions.AssertionsServices;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.test.users.environment.Endpoints.CREATE_USER;
import static co.com.test.users.interactions.WaitFor.LOGGER;
import static co.com.test.users.stepdefinitions.Actors.JAVIER;
import static co.com.test.users.util.constants.ConstantServices.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CreateUserStepDefinition {

    @When("el tester realiza la solicitud para la creación del usuario con nombre {string} y trabajo {string}")
    public void elTesterRealizaLaSolicitudParaLaCreaciónDelUsuarioConNombreYTrabajo(String name, String job) {
        CreateUserDTO usuario = new CreateUserDTO();
        usuario.setName(name);
        usuario.setJob(job);
        JAVIER.remember("usuario", usuario);
        theActorInTheSpotlight().attemptsTo(ConsumeExecutePostUser.withInformationRequested(CREATE_USER, usuario));
    }

    @Then("su solicitud se creará en el sistema con su información y un número de registro único")
    public void suSolicitudSeCrearáEnElSistemaConSuInformaciónYUnNúmeroDeRegistroÚnico() {
        CreateUserDTO expectedUser = JAVIER.recall("usuario");
        CreateUserDTO datosObtenidos = JAVIER.asksFor(ValidateUserCreate.verificarUsuarioCreado());
        ValidateInCraeteAndUpdateUser.thatUserIdWasGenerated();
        theActorInTheSpotlight().should(String.valueOf(datosObtenidos.getName().equals(expectedUser.getName())));
        theActorInTheSpotlight().should(String.valueOf(datosObtenidos.getJob().equals(expectedUser.getJob())));
        ValidateInCraeteAndUpdateUser.thatUserDateWasGenerated();
        LOGGER.info("🔗 El id del usuario creado es: {}", theActorInTheSpotlight().recall(KEY_USER_ID).toString());
    }

    @Then("la respuesta del sistema es exitosa")
    public void laRespuestaDelSistemaEsExitosa() {
        theActorInTheSpotlight().should(
                seeThat(StatusCodeResponse.httpResponseStatusCodeIs(HttpStatusCodes.CREATED.getHttpStatusCode()))
                        .orComplainWith(AssertionsServices.class, AssertionsServices.THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED));

    }
}
