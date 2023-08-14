package utils.listener.report;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;

public class ReportHelper {
    public static void generateCucumberReport(){
        File reportOutputDirectory = new File("target");
        ArrayList<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/jsonReports/cucumber-reports.json");
        String projectname = "UI-Report";
        Configuration configuration = new Configuration(reportOutputDirectory, projectname);
        configuration.addClassifications("Platform","Windows10");
        configuration.addClassifications("Browser","Chrome");
        configuration.addClassifications("Environment","UAT");
        configuration.addClassifications("Test Team","APPLICATION_UAT");
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }

}
