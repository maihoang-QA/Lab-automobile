package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import models.components.authentication.SignUpFormComponent;
import org.openqa.selenium.By;

public class FormPage extends Page {
    private final AppiumDriver<MobileElement> appiumDriver;
    private static final By inputTextSel = MobileBy.AccessibilityId("text-input");
    private static final By switchBtnSel = MobileBy.AccessibilityId("switch");
    private static final By dropdownBtnSel = MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Dropdown\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
    private static final By valueDropTxtSel = MobileBy.xpath("//*[@text='Appium is awesome']");
    private static final By activeBtnSel = MobileBy.AccessibilityId("button-Active");
    String textInput = "Creat new text";


    public FormPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
    }

    public FormPage inputText(){
        appiumDriver.findElement(inputTextSel).sendKeys(textInput);
        return this;
    }

    @Step("Click on Switch Button")
    public FormPage clickOnSwitchBtn(){
        appiumDriver.findElement(switchBtnSel).click();
        return this;
    }

    @Step("Click on Dropdown Button")
    public FormPage clickOnDropdownBtn(){
        appiumDriver.findElement(dropdownBtnSel).click();
        return this;
    }

    @Step("Click on Value Dropdown ")
    public FormPage clickValueDropdownTxt(){
        appiumDriver.findElement(valueDropTxtSel).click();
        return this;
    }

    @Step("Click on Active Button ")
    public FormPage clickActiveBtn(){
        appiumDriver.findElement(activeBtnSel).click();
        return this;
    }





}
