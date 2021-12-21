package test.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.api_learning.HomePageFlow;
import test_flows.authentication.LoginFlow;

public class HomeTest extends BaseTest {
    @TmsLink("Home page")
    @Description("Verify text is displayed on home page")
    @Test(description = "Home Test")
    public void textIsDisplayedSuccessfully() throws InterruptedException {
        // Init driver
        AppiumDriver<MobileElement> androidDriver = getDriver();
        HomePageFlow homePageFlow = new HomePageFlow(androidDriver);
        homePageFlow.navigateToHomePage();
        Thread.sleep(2000);
        homePageFlow.isVerifyDeMoTextSuccess();

    }



}
