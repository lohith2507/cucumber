package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"utility","stepDeff"},
        tags = "@flipkart"
)

public class TestRunner extends AbstractTestNGCucumberTests {

}

