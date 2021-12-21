package test_flows.form;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComponent;
import models.pages.FormPage;
import models.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import test_flows.authentication.LoginFlow;

public class FormFlow {
    private AppiumDriver<MobileElement> appiumDriver;
    private FormPage formPage;

    public FormFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
    private static final By resultTextSel = MobileBy.AccessibilityId("input-text-result");
    private static final By textSel = MobileBy.AccessibilityId("switch-text");
    private static final By valueDropSel = MobileBy.xpath("//*[@text='Appium is awesome']");
    private static final By activeTextSel  = MobileBy.id("android:id/message");


    public FormFlow initFormPage() {
        formPage = new FormPage(appiumDriver);
        return this;
    }


    public FormFlow navigateToFormPage() {
        if (formPage == null) {
            initFormPage();
        }
        // Bottom Nav Comp
        BottomNavComponent bottomNavComponent = formPage.bottomNavComp();
        bottomNavComponent.clickOnFormLabel();
        return this;}

    public FormFlow inputText() {
        if (formPage == null)
            throw new RuntimeException("Please use method navigateToFormLabel first");

        // Fill login Form
        formPage.inputText();
        return this;
    }
    public FormFlow verifyResultTextInput(){
        MobileElement resultText  = appiumDriver.findElement(resultTextSel);
        String textDisplayed = resultText.getText();
        if (textDisplayed.equals("Creat new text")){
            System.out.println("Hiển thị đúng text inpiput");
        }
        return this;
    }
    public FormFlow clickSwitchBtn(){
        formPage.clickOnSwitchBtn();
        return this;
    }

    public FormFlow verifyTextOnDisplayed(){
        String textOn = appiumDriver.findElement(textSel).getText();
        if (textOn.equals("Click to turn the switch ON")){
            System.out.println("Text ON is displayed successfully!");
        }
        return this;

    }

    public FormFlow verifyTextOffDisplayed(){
        String textOn = appiumDriver.findElement(textSel).getText();
        if (textOn.equals("Click to turn the switch OFF")){
            System.out.println("Text OFF is displayed successfully!");
        }
        return this;

    }

    public FormFlow clickDropdownBtn(){
        formPage.clickOnDropdownBtn();
        return this;
    }

    public FormFlow clickValueDropdownTxt(){
        formPage.clickValueDropdownTxt();
        return this;
    }

    public FormFlow verifyValueDropdownIsDisplayed(){
        Assert.assertTrue(appiumDriver.findElement(valueDropSel).isDisplayed());
        return this;
    }

    public FormFlow clickActiveBtn(){
        formPage.clickActiveBtn();
        return this;
    }

    public FormFlow verifyActiveTextIsDisplayed(){
        Assert.assertTrue(appiumDriver.findElement(activeTextSel).isDisplayed());
        return this;
    }






}
