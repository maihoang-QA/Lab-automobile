package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import models.components.global.BottomNavComponent;
import models.components.webview.WebviewPageComponent;

public class WebViewPage extends Page {
    private final AppiumDriver<MobileElement> appiumDriver;
    private WebviewPageComponent webviewPageComponent;

    public WebViewPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        webviewPageComponent = new WebviewPageComponent(appiumDriver);

    }


    @Step("Click Navigation Toggle Button")
    public WebViewPage clickNavigationToggleButton() throws InterruptedException {
        webviewPageComponent.clickNavigationToggleBtn();
        return this;
    }

    @Step("List all menu items list")
    public WebViewPage listAllMenuItemsList() {
        webviewPageComponent.listAllMenuItems();
        return this;
    }

    public BottomNavComponent bottomNavigation() {
        return new BottomNavComponent(appiumDriver);
    }

}
