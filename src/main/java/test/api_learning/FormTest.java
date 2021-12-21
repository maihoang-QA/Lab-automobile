package test.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.form.FormFlow;

public class FormTest extends BaseTest {
    @TmsLink("Form page")
    @Description("Verify text input is displayed on You have typed")
    @Test(description = "Form Test", priority = 1)
    public void textInputIsDisplayedSuccessfully() {
        // Init driver
        AppiumDriver<MobileElement> androidDriver = getDriver();
        FormFlow formFlow = new FormFlow(androidDriver);
        formFlow.navigateToFormPage()
                .inputText()
                .verifyResultTextInput();
    }

    @TmsLink("Form page")
    @Description("Verify text ON is displayed when switch ON")
    @Test(description = "Form Test", priority = 3)
    public void textOnIsDisplayedSuccessfully() {
        // Init driver
        AppiumDriver<MobileElement> androidDriver = getDriver();
        FormFlow formFlow = new FormFlow(androidDriver);
        formFlow.navigateToFormPage()
                .clickSwitchBtn()
                .verifyTextOnDisplayed();
    }

    @TmsLink("Form page")
    @Description("Verify text OFF is displayed when switch OFF")
    @Test(description = "Form Test", priority = 2)
    public void textOffIsDisplayedSuccessfully() {
        // Init driver
        AppiumDriver<MobileElement> androidDriver = getDriver();
        FormFlow formFlow = new FormFlow(androidDriver);
        formFlow.navigateToFormPage()
                .clickSwitchBtn()
                .verifyTextOffDisplayed();
    }

    @TmsLink("Form page")
    @Description("Click value dropdown ")
    @Test(description = "Form Test", priority = 4)
    public void clickValueDropdownSuccessfully() {
        // Init driver
        AppiumDriver<MobileElement> androidDriver = getDriver();
        FormFlow formFlow = new FormFlow(androidDriver);
        formFlow.navigateToFormPage()
                .clickDropdownBtn()
                .clickValueDropdownTxt()
                .verifyValueDropdownIsDisplayed();

    }

    @TmsLink("Form page")
    @Description("Click Active Button ")
    @Test(description = "Form Test", priority = 5)
    public void clickActiveBtn() {
        // Init driver
        AppiumDriver<MobileElement> androidDriver = getDriver();
        FormFlow formFlow = new FormFlow(androidDriver);
        formFlow.navigateToFormPage()
                .clickActiveBtn()
                .verifyActiveTextIsDisplayed();

    }

}
