package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.example.pages.LoginPage;
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

public class LoginPageTest {
    private AndroidDriver<AndroidElement> driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "Pixel");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appPackage", "com.bearn.app.snapshot");
        desiredCapabilities.setCapability("appActivity", "com.bearn.sdk.common.MainActivity");

        URL appiumServerURL = new URL("http://localhost:4723/wd/hub/");
        driver = new AndroidDriver<>(appiumServerURL, desiredCapabilities);
        loginPage = new LoginPage(driver);
    }
    @Test
    public void loginTestPositive() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/login_button_signin")));
        loginPage.enterUsername("abdurj7777@gmail.com");
        loginPage.enterPassword("123");
        loginPage.clickLoginButton();
        Thread.sleep(10000);
    }
    @Test
    public void loginTestNegative() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/login_button_signin")));
        loginPage.enterUsername("abdurj7777@gmail.com");
        loginPage.enterPassword("123");
        loginPage.clickLoginButton();
        Thread.sleep(10000);
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}