package org.bearn;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.bearn.pages.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SignInPageTest {
    private AndroidDriver<AndroidElement> driver;
    private SignInPage signInPage;

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
    }
    @Test(priority = 0)
    public void loginTestPositive() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/login_button_signin")));
        signInPage.enterUsername("abdurj7777@gmail.com");
        signInPage.enterPassword("123");
        signInPage.clickLoginButton();
        Thread.sleep(10000);
    }
    @Test(priority = 1)
    public void loginTestNegative() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/login_button_signin")));
        signInPage.enterUsername("abdurj7777@gmail.com");
        signInPage.enterPassword("123");
        signInPage.clickLoginButton();
        Thread.sleep(10000);
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}