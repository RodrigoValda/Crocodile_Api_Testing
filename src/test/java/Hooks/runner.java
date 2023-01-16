package Hooks;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "src/test/resources/login.feature",
        glue = {"StepDefinitions"},
        tags = "@Acceptance"
)

public class runner extends AbstractTestNGCucumberTests {
}
