package cucumberoptions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import runner.CustomRunner;
import utils.listener.Initialize;
import utils.listener.Processor;
import utils.listener.TearDown;

@Slf4j
@RunWith(CustomRunner.class)
@CucumberOptions(
        monochrome = true,
        features = "src/test/java/features",
        glue = {"cucumberoptions","stepdefinitions"},
        plugin = {"json:target/jsonReports/cucumber-reports.json"}
)
public class TestRunner {

    private static String executionDateTime;
    private static final String DATEFORMAT = "dd-MM-yyyy_hh-mm-ss";

    @Initialize
    public static void initialize(){
        log.info("------ Initialize: START ------");
        executionDateTime = Processor.getDateAsString(DATEFORMAT);
        log.info("------ Intialize: END ------");
    }

    @TearDown
    public static void teardown(){
        log.warn("------ Teardown: START ------");
        Processor.initializeTeardown(executionDateTime);
        log.info("Teardown: END ------");
    }
}
