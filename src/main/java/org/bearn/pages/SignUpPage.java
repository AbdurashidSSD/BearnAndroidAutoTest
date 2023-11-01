package org.bearn.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    private WebDriver driver;

    // Page Elements
    @AndroidFindBy(id = "")
    private MobileElement emailField;

    @AndroidFindBy(xpath = "")
    private MobileElement passwordField;

    @AndroidFindBy(id = "")
    private MobileElement signInButton;

    // Constructor
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Page Methods
    public void enterUsername(String username) {
        emailField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        signInButton.click();
    }
}