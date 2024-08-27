package co.com.test.users.stepdefinitions.user;

import co.com.test.users.questions.common.Schema;
import co.com.test.users.questions.common.StatusCodeResponse;
import co.com.test.users.tasks.common.GetUser_Task;
import co.com.test.users.util.exceptions.AssertionsServices;
import co.com.test.users.util.enums.HttpStatusCodes;
import co.com.test.users.util.environment.Endpoints;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;

import static co.com.test.users.model.parameters.GetParameterModel.parametroId;
import static co.com.test.users.util.enums.NameSchema.GET_USER_ID;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SearchUserById_StepDefinition {

    @When("intenta realizar la consulta utilizando el parametro {int}")
    public void intentaRealizarLaConsultaUtilizandoElParametro(Integer id) {
        theActorInTheSpotlight().attemptsTo(GetUser_Task.with(Endpoints.GET_USER_BY_ID, parametroId(id.toString())));
    }

    @Then("se debera obtener la repuesta exitosa")
    public void seDeberaObtenerLaRepuestaExitosa() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(StatusCodeResponse.httpResponseStatusCodeIs(HttpStatusCodes.OK.getHttpStatusCode())).orComplainWith(AssertionsServices.class, AssertionsServices.THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED));
        theActorInTheSpotlight().should(seeThat(Schema.theJsonSchemaExpectIs(GET_USER_ID.getNameSchema())).orComplainWith(AssertionsServices.class, AssertionsServices.THE_SCHEMA_SERVICE_IS_NOT_EXPECTED));

    }

}
