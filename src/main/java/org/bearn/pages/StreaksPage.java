package org.bearn.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StreaksPage {
    private WebDriver driver;

    // Page Elements
    @AndroidFindBy(id = "com.bearn.app.snapshot:id/actionPreviousPage")
    private MobileElement actionLeftBtn;

    @AndroidFindBy(id = "com.bearn.app.snapshot:id/actionNextPage")
    private MobileElement actionRightBtn;

    @AndroidFindBy(id = "com.bearn.app.snapshot:id/health_score_icon")
    private MobileElement healthSurveyBtn;

    // Constructor
    public StreaksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Page Methods

    public void clickActionLeftBtn() {
        actionLeftBtn.click();
    }
    public void clickActionRightBtn() {
        actionRightBtn.click();
    }
    public void clickHealthSurveyButton(){
        healthSurveyBtn.click();
    }

}
