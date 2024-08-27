package co.com.test.users.stepdefinitions.user;

import co.com.test.users.questions.ValidateUserService;
import co.com.test.users.stepdefinitions.Hook;
import co.com.test.users.tasks.common.UserServiceData;
import co.com.test.users.util.exceptions.AssertionsServices;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CommonUser_StepDefinition {
    public static final Actor JAVIER = Actor.named("Javier");

    @Given("desea consultar la API de user")
    public void deseaConsultarLaAPIDeUser() {
        theActorCalled(JAVIER.toString()).whoCan(CallAnApi.at(Hook.getEnvironmentBase()));
    }

    @When("define los datos para verificar la consulta del servicio")
    public void defineLosDatosParaVerificarLaConsultaDelServicio(DataTable data) {
        theActorInTheSpotlight().attemptsTo(UserServiceData.getInformationServiceUser(data.row(0)));
    }

    @Then("valido los campos del servicio")
    public void validoLosCamposDelServicio() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateUserService.expected()).orComplainWith(AssertionsServices.class, AssertionsServices.THE_VALUES_SERVICE_IS_NOT_EXPECTED));

    }
}
