package org.bearn.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    private WebDriver driver;

    // Page Elements
    @AndroidFindBy(id = "com.bearn.app.snapshot:id/login_button_signup")
    private MobileElement signUpButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewSwitcher/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
    private MobileElement accessCodeField;

    @AndroidFindBy(id = "com.bearn.app.snapshot:id/sign_up_button")
    private MobileElement continueButtonAccess;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewSwitcher/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText")
    private MobileElement firstNameField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewSwitcher/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText")
    private MobileElement lastNameField;

    @AndroidFindBy(id = "com.bearn.app.snapshot:id/sign_up_edit_email_et")
    private MobileElement emailField;

    @AndroidFindBy(id = "com.bearn.app.snapshot:id/sign_up_edit_email_confirm_et")
    private MobileElement confirmEmailField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewSwitcher/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[5]/android.widget.FrameLayout/android.widget.EditText")
    private MobileElement passwordField;

    @AndroidFindBy(id = "com.bearn.app.snapshot:id/sign_up_edit_password_confirm_et")
    private MobileElement confirmPasswordField;

    @AndroidFindBy(id = "com.bearn.app.snapshot:id/sign_up_t_c_checkbox")
    private MobileElement privacyPolicyCheckbox;

    @AndroidFindBy(id = "com.bearn.app.snapshot:id/sign_up_button")
    private MobileElement signUpButtonRegistration;

    @AndroidFindBy(id = "com.bearn.app.snapshot:id/button3")
    private MobileElement continueGettingStartedButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewSwitcher/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ToggleButton")
    private MobileElement connectGoogleFit;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewSwitcher/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ToggleButton")
    private MobileElement connectFitbit;

    @AndroidFindBy(id = "com.android.chrome:id/terms_accept")
    private MobileElement acceptChromeTerms;

    @AndroidFindBy(id = "ember591")
    private MobileElement accountEmailFitbitField;

    @AndroidFindBy(id = "ember592")
    private MobileElement passwordAccountFitbit;

    @AndroidFindBy(id = "ember632")
    private MobileElement signInToFitbit;


    // Constructor
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Page Methods
    public void clickSignUpButton() {
        signUpButton.click();
    }
    public void enterAccessCode(String code) {
        accessCodeField.sendKeys(code);
    }
    public void clickContinueButtonAccess() {
        continueButtonAccess.click();
    }
    public void enterFirstName(String name){
        firstNameField.sendKeys(name);
    }
    public void enterLastName(String lastname){
        lastNameField.sendKeys(lastname);
    }
    public void enterEmail(String email){
        emailField.sendKeys(email);
    }
    public void enterConfirmEmail(String confirmEmail){
        confirmEmailField.sendKeys(confirmEmail);
    }
    public void enterPassword(String pass){
        passwordField.sendKeys(pass);
    }
    public void confirmPassword(String confirmPass){
        confirmPasswordField.sendKeys(confirmPass);
    }
    public void clickCheckbox(){
        privacyPolicyCheckbox.click();
    }
    public void pressSignUp(){
        signUpButton.click();
    }
}