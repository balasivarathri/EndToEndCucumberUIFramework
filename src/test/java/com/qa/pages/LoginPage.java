package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private final By userName_input = By.xpath("//input[@id='user-name']");
    private final By password_input = By.xpath("//input[@id='password']");
    private final By login_button = By.xpath("//input[@id='login-button']");

    public void enterUserName(String username){
        driver.findElement(userName_input).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(password_input).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(login_button).click();
    }
//    public void loginTestUser(TestUser testUser){
//        enterUserName(testUser.getUsername());
//        enterPassword(testUser.getPassword());
//        clickLogin();
//    }
    public void loginTestUser(String username, String password){
        enterUserName(username);
        enterPassword(password);
        clickLogin();
    }
}
