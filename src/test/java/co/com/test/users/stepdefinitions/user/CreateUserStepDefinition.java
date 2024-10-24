package co.com.test.users.stepdefinitions.user;

import co.com.test.users.model.dto.CreateAndUpdateUserData;
import co.com.test.users.tasks.ConsumeExecutePostUser;
import co.com.test.users.tasks.ValidateInCraeteAndUpdateUser;
import co.com.test.users.tasks.common.CreateUpdateUserServiceData;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.test.users.environment.Endpoints.CREATE_USER;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateUserStepDefinition {
    @And("carga la información al sistema")
    public void cargaLaInformaciónAlSistema(DataTable data) {
        theActorInTheSpotlight().attemptsTo(CreateUpdateUserServiceData.getInformationServiceUserCreateAndUpdate(data.row(0)));
    }

    @When("el tester realiza la solicitud para la creación del usuario")
    public void elTesterRealizaLaSolicitudParaLaCreaciónDelUsuario() {
        theActorInTheSpotlight().attemptsTo(ConsumeExecutePostUser.withInformationRequested(CREATE_USER));
    }

    @Then("su solicitud se creará en el sistema con su información y un número de registro único")
    public void suSolicitudSeCrearáEnElSistemaConSuInformaciónYUnNúmeroDeRegistroÚnico() {
        ValidateInCraeteAndUpdateUser.thatUserIdWasGenerated();
        ValidateInCraeteAndUpdateUser.thatUserNameIs(CreateAndUpdateUserData.getCreateAndUpdateDataServiceUser().get("name").toString());
        ValidateInCraeteAndUpdateUser.thatUserJobIs(CreateAndUpdateUserData.getCreateAndUpdateDataServiceUser().get("job").toString());
        ValidateInCraeteAndUpdateUser.thatUserDateWasGenerated();
    }
}
