package utils.listener.report;

import com.qa.ui.base.TestBase;
import exceptions.GenericException;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.math.BigInteger;
import java.util.Random;

@Slf4j
public class Report {

    public Report() {

    }

    public static void log(Scenario scenario, String description) {
        scenario.log(description);
    }
    public static void log(Scenario scenario, String description, String attachement) {
        scenario.log(description + ":\n" + attachement);
    }

    public static void fail(Scenario scenario, String failureReason, String exceptionCaughtMessage) {
        try {
            try {
                Assertions.assertThat(false).isEqualTo(true);
            } catch (AssertionError var5) {
                String message = "Failure Reason: " + failureReason + "\n" + exceptionCaughtMessage;
                scenario.log(failureReason);
                throw new GenericException(message);
            }
        } catch (Throwable var6) {
            throw var6;
        }

    }

    public static void validate(Scenario scenario, String description, String failureReason, String expected, String actual){
        try{
            Assertions.assertThat(actual).isEqualTo(expected);
            scenario.log(description + "\nexpected [" + expected + "] and found [" + actual + "]");
        } catch (AssertionError var7){
            String failureMessage = description + "\nFailure Reason: " + failureReason + "\nexpected [" + expected + "] but found [" + actual + "]";
            scenario.log(failureMessage);
            throw new AssertionError(failureMessage + "\n" + var7.getMessage());
        }
    }
    public static void validate(Scenario scenario, String description, String failureReason, int expected, int actual){
        try{
            Assertions.assertThat(actual).isEqualTo(expected);
            scenario.log(description + "\nexpected [" + expected + "] and found [" + actual + "]");
        } catch (AssertionError var7){
            String failureMessage = description + "\nFailure Reason: " + failureReason + "\nexpected [" + expected + "] but found [" + actual + "]";
            scenario.log(failureMessage);
            throw new AssertionError(failureMessage + "\n" + var7.getMessage());
        }
    }
    public static void screenshot(Scenario scenario){
        byte[] screenshot = (byte[]) ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", attchmentFileName(10));
    }
    private static String attchmentFileName(int lengthRequired){
        int radix = 36;
        Random random = new Random();
        BigInteger bi = new BigInteger(100, random);
        return bi.toString(radix).substring(0, lengthRequired);
    }
}
