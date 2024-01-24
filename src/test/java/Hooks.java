import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        // Access the scenario name
        String scenarioName = scenario.getName();
        System.out.println("Executing setup for scenario: " + scenarioName);

        // Your setup implementation
    }
}
