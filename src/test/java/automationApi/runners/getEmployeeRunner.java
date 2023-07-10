package automationApi.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"automationApi.stepdefinitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class getEmployeeRunner {

}
