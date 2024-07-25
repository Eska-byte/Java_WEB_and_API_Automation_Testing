package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:reports/cucumber-API-report.html", "json:reports/cucumberAPI.json"},
        glue = {"APIstepDef"},
        features = {"src/test/java/APIfeature/API.feature"},
        tags = "@API"
)

public class apiRunner {
}
