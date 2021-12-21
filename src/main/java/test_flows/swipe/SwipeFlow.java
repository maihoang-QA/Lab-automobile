package test_flows.swipe;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import models.components.global.BottomNavComponent;
import models.pages.SwipePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SwipeFlow {
    private AppiumDriver<MobileElement> appiumDriver;

    private SwipePage swipePage;
    private static final By textSwipe = MobileBy.xpath("//*[@text='You found me!!!']");


    public SwipeFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public SwipeFlow initSwipePage() {
        swipePage = new SwipePage(appiumDriver);
        return this;
    }


    public SwipeFlow navigateToSwipePage() {
        if (swipePage == null) {
            initSwipePage();
        }
        // Bottom Nav Comp
        BottomNavComponent bottomNavComponent = swipePage.bottomNavComp();
        bottomNavComponent.clickOnSwipeLabel();
        return this;}

    public SwipeFlow swipe() throws InterruptedException {
        swipePage.swipe();
        return this;
    }

    public SwipeFlow verifyTextDisplayedSuccessfully(){
        Assert.assertTrue(appiumDriver.findElement(textSwipe).isDisplayed());
        return this;

    }

    public SwipeFlow swipeUntil(){
        swipePage.swipeUntil();
        return this;
    }
}
