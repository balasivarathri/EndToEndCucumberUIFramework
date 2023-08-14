package cucumberoptions;

import com.qa.ui.base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import testcontextsetup.TestContextSetup;

@Slf4j
public class Hooks {

    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Before(order = 0)
    public void beforeScenario(Scenario scenario){
        TestBase.scenario = scenario;
        log.info("------ Scenario: START ------");
        log.info("Scenario Name: " + scenario.getName());
    }

    @After(order = 0)
    public void afterScenario(Scenario scenario){
        log.info("Scenarios Result: " + scenario.getStatus());
        log.info("------ Scenario: END ------");
    }

}
