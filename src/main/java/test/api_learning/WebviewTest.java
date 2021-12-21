package test.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.webview.WebViewFlow;

public class WebviewTest extends BaseTest {
    @Description("Test Webview Page")
    @Test(description = "Make sure the menu text and hyperlink displayed correctly")
    public void checkMenuTextAndHyperlinkIsDisplayed() throws InterruptedException {
        // Init driver
        AppiumDriver<MobileElement> appiumDriver = getDriver();

        // Switch to Sign Up tab and register an account
        WebViewFlow webviewFlow = new WebViewFlow(appiumDriver);
        webviewFlow
                .accessWebviewPage()
                .clickNavigationToggle()
                .listAllMenu();
    }

}
