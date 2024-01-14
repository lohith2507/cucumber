package runner;

import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"utility","stepDeff"},
        plugin = {"pretty","html:target/cucumber-html-report","json:cucumber.json"}
)

public class TestRunner {

}

