package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComponent;
import models.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import test_data.authentication.LoginCreds;

public class LoginFlow {

    private AppiumDriver<MobileElement> appiumDriver;
    private LoginPage loginPage;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
    private final static By inValidEmailSel = MobileBy.xpath("//*[@text='Please enter a valid email address']");
    private final static By inValidPassSel = MobileBy.xpath("//*[@text='Please enter at least 8 characters']");

    public LoginFlow initLoginPage() {
        loginPage = new LoginPage(appiumDriver);
        return this;
    }

    public LoginFlow navigateToLoginForm() {
        if (loginPage == null) {
            initLoginPage();
        }
        // Bottom Nav Comp
        BottomNavComponent bottomNavComponent = loginPage.bottomNavComp();
        bottomNavComponent.clickOnLoginLabel();
        return this;
    }

    public LoginFlow login(LoginCreds loginCreds) {
        if (loginPage == null)
            throw new RuntimeException("Please use method navigateToLoginForm first");

        // Fill login Form
        loginPage
                .inputUsername(loginCreds.getUsername())
                .inputPassword(loginCreds.getPassword())
                .clickOnLoginBtn();
        return this;
    }

    public void verifyLoginSuccess() {
        // Verification
        String actualLoginMsg = loginPage.loginDialogComp().msgTitle();
        boolean isTitleCorrect = actualLoginMsg.equals("Success");

        String customErrMsg = "[ERR] Login msg title incorrect!";
        Assert.assertTrue(isTitleCorrect, customErrMsg);
    }


    public void verifyLoginWithNullCreds() {
        // Verification
        Assert.assertTrue(appiumDriver.findElement(inValidEmailSel).isDisplayed()) ;
        Assert.assertTrue(appiumDriver.findElement(inValidPassSel).isDisplayed()) ;
        }

    public void verifyLoginWithMissEmailCreds() {
        // Verification
        Assert.assertTrue(appiumDriver.findElement(inValidEmailSel).isDisplayed()) ;
    }

    public void verifyLoginWithMissPassCreds() {
        // Verification
        Assert.assertTrue(appiumDriver.findElement(inValidPassSel).isDisplayed()) ;
    }










}
