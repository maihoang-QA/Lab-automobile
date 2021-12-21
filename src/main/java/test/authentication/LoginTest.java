package test.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.authentication.LoginCreds;
import test_data.DataObjectBuilder;
import test_flows.authentication.LoginFlow;

public class LoginTest extends BaseTest {

    @TmsLink("Login_001") @TmsLink("Login_002") @TmsLink("Login_003")
    @Description("Test login with data driven...")
    @Test(dataProvider = "invalidLoginCreds", description = "Login Test", priority = 1)
    public void loginWithNullCreds(LoginCreds loginCreds) {
        // Init driver
        AppiumDriver<MobileElement> androidDriver = getDriver();
        LoginFlow loginFlow = new LoginFlow(androidDriver);
        loginFlow
                .navigateToLoginForm()
                .login(loginCreds)
                .verifyLoginWithNullCreds();
    }

    @TmsLink("Login_002")
    @Description("Test login with correct creds...")
    @Test(description = "Login Test", priority = 2)
      public void loginWithMissEmailCreds() {
       String jsonLoc = "/src/main/resources/test-data/authentication/LoginMissEmailCreds.json";
       LoginCreds loginCreds = DataObjectBuilder.buildDataObject(jsonLoc, LoginCreds[].class)[0];

        //Init driver
       AppiumDriver<MobileElement> androidDriver = getDriver();
       LoginFlow loginFlow = new LoginFlow(androidDriver);
       loginFlow
                .navigateToLoginForm()
                .login(loginCreds)
                .verifyLoginWithMissEmailCreds();
   }

    @TmsLink("Login_003")
    @Description("Test login with correct creds...")
    @Test(description = "Login Test", priority = 3)
    public void loginWithMissPassCreds() {
        String jsonLoc = "/src/main/resources/test-data/authentication/LoginMissPassCreds.json";
        LoginCreds loginCreds = DataObjectBuilder.buildDataObject(jsonLoc, LoginCreds[].class)[0];

        //Init driver
        AppiumDriver<MobileElement> androidDriver = getDriver();
        LoginFlow loginFlow = new LoginFlow(androidDriver);
        loginFlow
                .navigateToLoginForm()
                .login(loginCreds)
                .verifyLoginWithMissPassCreds();
    }

    @TmsLink("Login_004")
    @Description("Test login with correct creds...")
    @Test(description = "Login Test", priority = 4)
    public void loginWithValidLoginCreds() {
        String jsonLoc = "/src/main/resources/test-data/authentication/ValidLoginCreds.json";
        LoginCreds loginCreds = DataObjectBuilder.buildDataObject(jsonLoc, LoginCreds[].class)[0];

        //Init driver
        AppiumDriver<MobileElement> androidDriver = getDriver();
        LoginFlow loginFlow = new LoginFlow(androidDriver);
        loginFlow
                .navigateToLoginForm()
                .login(loginCreds)
                .verifyLoginSuccess();
    }

    @DataProvider
    public LoginCreds[] invalidLoginCreds() {
        String jsonLoc = "/src/main/resources/test-data/authentication/LoginNullCreds.json";
        return DataObjectBuilder.buildDataObject(jsonLoc, LoginCreds[].class);
    }




}
