package org.bearn;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.bearn.pages.SignInPage;
import org.bearn.pages.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import java.net.MalformedURLException;
import java.net.URL;

public class TestCases {
    private AndroidDriver<AndroidElement> driver;
    private SignInPage signInPage;
    private SignUpPage signUpPage;
    private Faker faker;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "Pixel");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appPackage", "com.bearn.app.snapshot");
        desiredCapabilities.setCapability("appActivity", "com.bearn.sdk.common.MainActivity");

        URL appiumServerURL = new URL("http://localhost:4723/wd/hub/");
        driver = new AndroidDriver<>(appiumServerURL, desiredCapabilities);
        signInPage = new SignInPage(driver);
        signUpPage = new SignUpPage(driver);
        faker = new Faker();
    }
    @Test(priority = 0)
    public void signInTestPositive() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/login_button_signin")));
        signInPage.enterUsername("abdurj7777@gmail.com");
        signInPage.enterPassword("123");
        signInPage.clickLoginButton();
        Thread.sleep(10000);
    }
    @Test(priority = 1)
    public void signInTestNegative() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/login_button_signin")));
        signInPage.enterUsername("abdurj7777@gmail.com");
        signInPage.enterPassword("123");
        signInPage.clickLoginButton();
        Thread.sleep(10000);
    }
    @Test
    public void signUpTestPositive(){
        String email = faker.internet().emailAddress();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/login_button_signin")));
        signUpPage.clickSignUpButton();
        WebElement label = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/label")));
        signUpPage.enterAccessCode("579a1a");
        signUpPage.clickContinueButtonAccess();
        WebElement label1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/sign_up_edit_email_et")));
        signUpPage.enterFirstName(faker.name().firstName());
        signUpPage.enterLastName(faker.name().lastName());
        signUpPage.enterEmail(email);
        signUpPage.enterConfirmEmail(email);
        signUpPage.enterPassword("Samsungj1@");
        signUpPage.confirmPassword("Samsungj1@");
        driver.navigate().back();
        signUpPage.clickCheckbox();
        signUpPage.pressSignUp();
        WebElement label2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/textView5")));
        signUpPage.pressContinueGettingStarted();
        WebElement label3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/textView11")));

    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}