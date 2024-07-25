package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:reports/cucumber.html", "json:reports/cucumber.json"},
        glue = {"stepsDef"},
        features = {"src/test/java/features/WEB.feature"},
        tags = "@WEB"
)

public class webRunner {
}
