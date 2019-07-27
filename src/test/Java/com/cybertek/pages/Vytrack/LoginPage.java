package com.cybertek.pages.Vytrack;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    //we are
    private WebDriver driver = Driver.getDriver();

    @FindBy (id = "prependedInput")
    public WebElement userNameELement;


    @FindBy (name = "_password")
    public WebElement passwordELement;


    @FindBy (id = "_submit")
    public WebElement loginButtonELement;


    @FindBy (id = "remember_me")
    public WebElement rememberMeELement;


    @FindBy (partialLinkText = "Forgot your password?")
    public WebElement forgotPasswordElement;

    @FindBy(tagName = "h2")
    public WebElement titleElement;

    @FindBy (css = "[class='alert alert-error'] >div")
    public WebElement errorMessageElement;




    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        userNameELement.sendKeys(username);
        passwordELement.sendKeys(password);
        loginButtonELement.click();


        public String getErrorMessage({
                return
        }
    }

}
