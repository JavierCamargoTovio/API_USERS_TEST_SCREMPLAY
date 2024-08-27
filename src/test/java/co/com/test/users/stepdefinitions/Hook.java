package co.com.test.users.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;

public class Hook {

    public static EnvironmentVariables environmentVariables;

    private static String environmentBase;

    public static String getEnvironmentBase() {
        return environmentBase;
    }

    @Before
    public void initialConfiguration()  {
        OnStage.setTheStage(new OnlineCast());
        environmentBase = environmentVariables.optionalProperty("environments.qa.base.url").orElse("environments.dev.base.url");

    }

}
