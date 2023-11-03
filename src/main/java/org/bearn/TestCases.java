package org.bearn;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.bearn.pages.DashboardPage;
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
    private DashboardPage dashboardPage;
    private Faker faker;
    private TouchAction touchAction;
    private WebDriverWait wait;

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
        dashboardPage = new DashboardPage(driver);
        faker = new Faker();
        touchAction = new TouchAction(driver);
        wait = new WebDriverWait(driver, 10);
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
    public void signUpTestPositive() throws InterruptedException {
        String email = faker.internet().emailAddress();
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
        signUpPage.pressFitbitConnect();
        WebElement label6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Fitbit Home\"]/android.widget.Image")));
        touchAction.tap(new PointOption().withCoordinates(503, 765)).perform();
        Thread.sleep(5000);
        touchAction.tap(new PointOption().withCoordinates(416, 641)).perform();
        Thread.sleep(5000);
        touchAction.tap(new PointOption().withCoordinates(97, 590)).perform();
        Thread.sleep(5000);
        touchAction.tap(new PointOption().withCoordinates(879, 1496)).perform();
        WebElement label8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/status")));
        signUpPage.pressContinueConnectedDevices();
        WebElement label9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("com.bearn.app.snapshot:id/got_it_text")));
    }
    @Test
    public void dashboardTest() throws InterruptedException {
        signInTestPositive();

        WebElement dashboardBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/dashboard")));
        WebElement goalsBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/goals")));
        WebElement streaksBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/streaks_")));
        WebElement SpendBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/spend")));
        WebElement ChallengesBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/challenges")));

        WebElement dashboardTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")));
        WebElement healthScoreIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/health_score_icon")));
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/menu")));
        WebElement spendInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/spendInfo")));
        WebElement caloriesInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/caloriesInfo")));
        WebElement graphMoney = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/dashboardBottomGraph")));
        dashboardPage.clickActionLeftBtn();
        WebElement graphGoals = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/dashboard_graph_container")));
        dashboardPage.clickActionRightBtn();
        WebElement caloriesInfo1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/caloriesInfo")));
        dashboardPage.clickActionRightBtn();
        WebElement streaksTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")));
    }
    @Test
    public void straksTest() throws InterruptedException{
        signInTestPositive();

        WebElement dashboardBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/dashboard")));
        WebElement goalsBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/goals")));
        WebElement streaksBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/streaks_")));
        WebElement SpendBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/spend")));
        WebElement ChallengesBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/challenges")));

        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/menu")));
        WebElement streaksTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")));
        WebElement healthScoreIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bearn.app.snapshot:id/health_score_icon")));


    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}