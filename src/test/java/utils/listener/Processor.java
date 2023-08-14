package utils.listener;

import lombok.extern.slf4j.Slf4j;
import tools.CoreDateTime;
import utils.listener.report.ReportHelper;

@Slf4j
public class Processor {

    private static final String startDateTime = CoreDateTime.getTimeStamp("dd-MM-yyyy_hh-mm-ss");
    public static String requestId="";
    public Processor(){

    }

    public static String getDateAsString(String format){
        return CoreDateTime.getTimeStamp(format);
    }

    public static void initializeTeardown(String executionDateTime) {
        log.info("Unique Run id generated: " + requestId);
        log.info("Initializing Teardown");
        log.info("Generating local execution report");
        generateReport();
        log.info("Cucumber execution report genereated scuccessfully");
        log.info("Handing off teardown to controller with values: ");
        log.info("Ignoring teardown as no features have been executed");
    }

    public static void generateReport(){
        ReportHelper.generateCucumberReport();
    }
}
