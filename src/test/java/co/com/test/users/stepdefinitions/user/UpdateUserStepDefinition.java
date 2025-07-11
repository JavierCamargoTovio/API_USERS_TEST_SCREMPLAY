package co.com.test.users.stepdefinitions.user;

import co.com.test.users.model.dto.CreateAndUpdateUserData;
import co.com.test.users.model.headers.GetHeaderModel;
import co.com.test.users.model.parameters.GetParameterModel;
import co.com.test.users.questions.common.StatusCodeResponse;
import co.com.test.users.tasks.ConsumeExecutePutUser;
import co.com.test.users.tasks.ValidateInCraeteAndUpdateUser;
import co.com.test.users.util.enums.HttpStatusCodes;
import co.com.test.users.util.exceptions.AssertionsServices;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static co.com.test.users.environment.Endpoints.UPDATE_USER;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UpdateUserStepDefinition {

    @When("el tester realiza la solicitud para la actualizacion del usuario con parametro {string}")
    public void elTesterRealizaLaSolicitudParaLaActualizacionDelUsuarioConParametro(String idUser) {
        theActorInTheSpotlight().attemptsTo(
                ConsumeExecutePutUser.withInformationRequestedUpdateUser(
                        UPDATE_USER, GetParameterModel.parametroId(idUser), GetHeaderModel.headersDefault()));

    }

    @Then("su solicitud se actualizará en el sistema con su información")
    public void suSolicitudSeActualizaráEnElSistemaConSuInformación() {

        theActorInTheSpotlight().should(
                seeThat(
                        StatusCodeResponse.httpResponseStatusCodeIs(HttpStatusCodes.OK.getHttpStatusCode()))
                        .orComplainWith(AssertionsServices.class, AssertionsServices.THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED));

        ValidateInCraeteAndUpdateUser.thatUserNameIs(
                CreateAndUpdateUserData.getCreateAndUpdateDataServiceUser().get("name").toString());

        ValidateInCraeteAndUpdateUser.thatUserJobIs(
                CreateAndUpdateUserData.getCreateAndUpdateDataServiceUser().get("job").toString());

        ValidateInCraeteAndUpdateUser.thatUserDateWasUpdate();
    }
}
