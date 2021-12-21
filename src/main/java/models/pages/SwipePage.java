package models.pages;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SwipePage extends Page {
    private final AppiumDriver<MobileElement> appiumDriver;


    public SwipePage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
    }


    public SwipePage swipe() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30L);
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElementByXPath("//*[@text='Swipe horizontal']")));

        //Get Mobile Window size
        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screeHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        //Caculator touch point
        int xStartPoint = 50 * screenWidth /100;
        //ko kéo ngang nên là x: start = end
        int xEndPoint = xStartPoint;
        int yStartPoint = 90 * screeHeight /100;
        int yEndPoint = 10 * screeHeight /100;

        //Convert to PointOptions - Coordinates
        PointOption startPoint = new PointOption().withCoordinates(xStartPoint,yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        //Perform touch action
        TouchAction touchAction = new TouchAction(appiumDriver);

        //Swipe up (từ dưới lên trên)
        touchAction
                .press(startPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(endPoint)
                .release()
                .perform();
        touchAction
                .press(startPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(endPoint)
                .release()
                .perform();

        return this;

    }

    public SwipePage swipeUntil(){
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30L);
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElementByXPath("//*[@text='Swipe horizontal']")));


        //Get Mobile Window size
        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screeHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        //Caculator touch point
        int xStartPoint = 50 * screenWidth /100;
        //ko kéo ngang nên là x: start = end
        int xEndPoint = 10 * screenWidth /100;
        int yStartPoint = 50 * screeHeight /100;
        int yEndPoint = yStartPoint;
        //kéo ngang thì y k thay đổi nên start = end


        //Convert to PointOptions - Coordinates
        PointOption startPoint = new PointOption().withCoordinates(xStartPoint,yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        //Perform touch action
        TouchAction touchAction = new TouchAction(appiumDriver);
        int SWIPE_MAX_TIME = 6;
        int swipeTime = 0;

        while (swipeTime < SWIPE_MAX_TIME){
            List<MobileElement> matchedCards = appiumDriver.findElementsByXPath("//*[@text='COMPATIBLE']");
            if (!matchedCards.isEmpty()) break;

            touchAction.press(startPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                    .moveTo(endPoint)
                    .release()
                    .perform();

            swipeTime++;

        }
        return this;

    }


}
