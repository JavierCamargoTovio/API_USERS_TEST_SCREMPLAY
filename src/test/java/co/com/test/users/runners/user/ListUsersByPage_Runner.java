package co.com.test.users.runners.user;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/test/list_users_by_page.feature"},
        glue = "co.com.test.users.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class ListUsersByPage_Runner {
}
