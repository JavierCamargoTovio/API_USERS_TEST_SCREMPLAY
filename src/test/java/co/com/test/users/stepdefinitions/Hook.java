package co.com.test.users.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.test.users.environment.Endpoints.BASE_URL;
import static co.com.test.users.stepdefinitions.Actors.JAVIER;
import static co.com.test.users.util.constants.ConstantServices.SCENARIO;
import static co.com.test.users.util.constants.ConstantServices.THE_REST_API_BASE_URL;


public class Hook {
    private static final Logger LOG = LoggerFactory.getLogger(Hook.class.getSimpleName());
    public static EnvironmentVariables environmentVariables;

    @Before
    public void initialConfiguration(Scenario scenario)  {
        OnStage.setTheStage(new OnlineCast());
        JAVIER.remember(THE_REST_API_BASE_URL, BASE_URL);
        JAVIER.remember(SCENARIO, scenario.getName());
        JAVIER.describedAs("un usuario que puede crear, consultar, actualizar y eliminar");

        LOG.info("*****************************************************************************************");
        LOG.info("	Scenario: " + scenario.getName());
        LOG.info("	Tags: " + scenario.getSourceTagNames());
        LOG.info("*****************************************************************************************");
    }

    @After
    public void afterScenario(Scenario scenario) {
        LOG.info("*****************************************************************************************");
        LOG.info(("	Scenario: " + scenario.getName() + ": " + scenario.getStatus()));
        LOG.info("*****************************************************************************************");
    }
}
