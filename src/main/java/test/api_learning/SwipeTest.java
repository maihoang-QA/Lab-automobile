package test.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.form.FormFlow;
import test_flows.swipe.SwipeFlow;

public class SwipeTest extends BaseTest {
    @TmsLink("Swipe page")
    @Description("Swipe screen")
    @Test(description = "Swipe Test",priority = 1)
    public void swipeSuccessfully() throws InterruptedException {
        // Init driver
        AndroidDriver<MobileElement> androidDriver = (AndroidDriver<MobileElement>) getDriver();
        SwipeFlow swipeFlow = new SwipeFlow(androidDriver);
        swipeFlow.navigateToSwipePage()
                .swipe()
                .verifyTextDisplayedSuccessfully();

    }

    @TmsLink("Swipe page")
    @Description("Swipe screen")
    @Test(description = "Swipe Untils")
    public void swipeUntil()  {
        // Init driver
        AndroidDriver<MobileElement> androidDriver = (AndroidDriver<MobileElement>) getDriver();
        SwipeFlow swipeFlow = new SwipeFlow(androidDriver);
        swipeFlow.navigateToSwipePage()
                .swipeUntil();
    }

}
