package stepDeff;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    public static String scenarioName;
    @Before
    public void beforeScenario(Scenario scenario) {
        // Access the scenario name
         scenarioName = scenario.getName();
        System.out.println("Executing setup for scenario: " + scenarioName);
    }

    public  String getcurrentscenrioname()
    {
        return scenarioName;
    }
}
