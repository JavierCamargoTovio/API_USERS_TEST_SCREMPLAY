package co.com.test.users.stepdefinitions.user;

import co.com.test.users.questions.TheQueryFieldsAndValuesAre;
import co.com.test.users.tasks.common.GetUserServiceData;
import co.com.test.users.util.exceptions.AssertionsServices;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static co.com.test.users.stepdefinitions.Actors.JAVIER;
import static co.com.test.users.util.constants.ConstantServices.THE_REST_API_BASE_URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CommonUser_StepDefinition {

    @Given("que el tester desea crear/consultar/actualizar/eliminar usuario(s) en la API de users")
    public void preparingAPI()  {
        OnStage.theActorCalled(JAVIER.toString());
        theActorInTheSpotlight()
                .whoCan(CallAnApi.at(JAVIER.recall(THE_REST_API_BASE_URL)));
    }

    @When("define los datos para verificar la consulta del servicio")
    public void defineLosDatosParaVerificarLaConsultaDelServicio(DataTable data) {
       theActorInTheSpotlight().attemptsTo(GetUserServiceData.getInformationServiceUser(data.row(0)));
    }

    @Then("valido los campos del servicio")
    public void validoLosCamposDelServicio() {
        theActorInTheSpotlight().should(
                seeThat(TheQueryFieldsAndValuesAre.expected())
                        .orComplainWith(AssertionsServices.class, AssertionsServices.THE_VALUES_SERVICE_IS_NOT_EXPECTED));

    }

}
