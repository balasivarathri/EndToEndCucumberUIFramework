package com.qa.ui.base;


import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static Scenario scenario;

    public WebDriver webDriverManager() throws IOException {
        prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/java/com/qa/ui/config/global.properties");
        prop.load(fileInputStream);
        if (driver == null) {
            String browserName = prop.getProperty("browser");
            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().clearDriverCache().setup();
                WebDriverManager.chromedriver().clearResolutionCache().setup();
                driver = WebDriverManager.chromedriver().create();
            } else if (browserName.equalsIgnoreCase("chromium")) {
                driver = WebDriverManager.chromiumdriver().create();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = WebDriverManager.firefoxdriver().create();
            } else if (browserName.equalsIgnoreCase("safari")) {
                driver = WebDriverManager.safaridriver().create();
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver = WebDriverManager.edgedriver().create();
            }
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
        return driver;
    }
}
