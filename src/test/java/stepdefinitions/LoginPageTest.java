package stepdefinitions;

import com.qa.pages.LoginPage;
import com.qa.pages.TestUser;
import com.qa.ui.base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import testcontextsetup.TestContextSetup;
import utils.listener.report.Report;

@Slf4j
public class LoginPageTest extends TestBase {

    TestContextSetup testContextSetup;
    LoginPage loginPage;

    public LoginPageTest(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Given("^User can be able to caputre username and passwrod to login to Application UserName(.+), Password(.+)$")
    public void user_can_be_able_to_caputre_username_and_passwrod_to_login_to_application_user_name_password(String UserName, String Password) {
        loginPage = testContextSetup.pageObjectManager.loginPage();
        loginPage.loginTestUser(UserName,Password);
        Report.log(scenario,"User should be logged in to the application");
        Report.screenshot(scenario);
    }
    @When("^User should be login into Swag Labs Home page$")
    public void user_should_be_login_into_swagLabs_home_page() {

    }
    @And("^User can be able to see validate the titile of the page$")
    public void user_can_be_able_to_see_validate_the_titile_of_the_page() {

    }
    @Then("^User should be able to logout from the Swag Labs page$")
    public void user_should_be_able_to_logout_from_the_swagLabs_page() {

    }
}
