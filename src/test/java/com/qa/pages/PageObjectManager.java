package com.qa.pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public LoginPage loginPage;
    public WebDriver driver;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }
    public LoginPage loginPage(){
        loginPage = new LoginPage(driver);
        return loginPage;
    }
}
