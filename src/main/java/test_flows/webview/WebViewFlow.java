package test_flows.webview;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import models.components.global.BottomNavComponent;
import models.pages.WebViewPage;
import org.testng.asserts.SoftAssert;

public class WebViewFlow {
    private AppiumDriver<MobileElement> appiumDriver;
    private WebViewPage webviewPage;
    private SoftAssert softAssert;

    public WebViewFlow(AppiumDriver<MobileElement> appiumDriver) {
        softAssert = new SoftAssert();
        this.appiumDriver = appiumDriver;
    }

    @Step("Webview Page initialization")
    public WebViewFlow initWebviewPage() {
        webviewPage = new WebViewPage(appiumDriver);
        return this;
    }

    @Step("Access to Webview page")
    public WebViewFlow accessWebviewPage() {
        if (webviewPage == null) {
            initWebviewPage();
        }
        // Click Login feature
        BottomNavComponent bottomNavComponent = webviewPage.bottomNavigation();
        bottomNavComponent.clickOnWebviewLabel();
        return this;
    }

    @Step("Click Navigation Toggle")
    public WebViewFlow clickNavigationToggle() throws InterruptedException {
        if (webviewPage == null) {
            throw new RuntimeException("Please use method accessWebviewPage first");
        }
        webviewPage.clickNavigationToggleButton();
        return this;
    }

    @Step("List all Menu items")
    public WebViewFlow listAllMenu() {
        if (webviewPage == null) {
            throw new RuntimeException("Please use method accessWebviewPage first");
        }
        webviewPage.listAllMenuItemsList();
        return this;
    }
}
