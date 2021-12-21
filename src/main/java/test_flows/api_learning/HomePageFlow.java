package test_flows.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComponent;
import models.pages.HomePage;
import models.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import test_flows.authentication.LoginFlow;

public class HomePageFlow {
    private AppiumDriver<MobileElement> appiumDriver;
    private HomePage homePage;

    public HomePageFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
    private final static By demoTextSel = MobileBy.xpath("//*[@text='Demo app for the appium-boilerplate']");
    private final static By supportTextSel = MobileBy.xpath("//*[@text='Support']");


    public HomePageFlow initHomePage() {
        homePage = new HomePage(appiumDriver);
         return this;
    }

    public HomePageFlow navigateToHomePage() {
        if (homePage == null) {
            initHomePage();
        }
        // Bottom Nav Comp
        BottomNavComponent bottomNavComponent = homePage.bottomNavComp();
        bottomNavComponent.clickOnHomeLabel();
        return this;
    }

    public void isVerifyDeMoTextSuccess() {
        // Verification
        MobileElement demoText = appiumDriver.findElement(demoTextSel);
        MobileElement supportText = appiumDriver.findElement(supportTextSel);
        Assert.assertTrue(demoText.isDisplayed());
        Assert.assertTrue(supportText.isDisplayed());

    }







}
