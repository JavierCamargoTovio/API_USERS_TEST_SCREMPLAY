package co.com.test.users.stepdefinitions.user;

import co.com.test.users.model.dto.CreateAndUpdateUserData;
import co.com.test.users.model.dto.CreateUserDTO;
import co.com.test.users.tasks.ConsumeExecutePostUser;
import co.com.test.users.tasks.ValidateInCraeteAndUpdateUser;
import co.com.test.users.tasks.common.CreateUpdateUserServiceData;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.test.users.environment.Endpoints.CREATE_USER;
import static co.com.test.users.stepdefinitions.Actors.JAVIER;
import static co.com.test.users.util.constants.ConstantServices.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateUserStepDefinition {

    CreateUserDTO usuario =  new CreateUserDTO();
    String name = JAVIER.recall(KEY_USER_NAME);

    //@And("carga la información al sistema")
   // public void cargaLaInformaciónAlSistema(DataTable data) {
        //theActorInTheSpotlight().attemptsTo(CreateUpdateUserServiceData.getInformationServiceUserCreateAndUpdate(data.row(0)));
  //  }

    @When("el tester realiza la solicitud para la creación del usuario con nombre {string} y trabajo {string}")
    public void elTesterRealizaLaSolicitudParaLaCreaciónDelUsuarioConNombreYTrabajo(String name, String job) {
        theActorInTheSpotlight().attemptsTo(ConsumeExecutePostUser.withInformationRequested(CREATE_USER, name, job));
    }

    @Then("su solicitud se creará en el sistema con su información y un número de registro único")
    public void suSolicitudSeCrearáEnElSistemaConSuInformaciónYUnNúmeroDeRegistroÚnico() {
        ValidateInCraeteAndUpdateUser.thatUserIdWasGenerated();
        ValidateInCraeteAndUpdateUser.thatUserNameIs(theActorInTheSpotlight().recall(KEY_USER_NAME));
       // ValidateInCraeteAndUpdateUser.thatUserJobIs(CreateAndUpdateUserData.getCreateAndUpdateDataServiceUser().get("job").toString());
        //ValidateInCraeteAndUpdateUser.thatUserDateWasGenerated();
    }
}
