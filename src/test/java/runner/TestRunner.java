package runner;

import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"src/test/java/stepDeff","src/test/java/utility"},
        plugin = {"pretty","html:target/cucumber-html-report","json:cucumber.json"} https://github.com/lohith2507/cucumber.githttps://github.com/lohith2507/cucumber.git
)

public class TestRunner {

}

