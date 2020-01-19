import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.NewUserPage;

import static data.TestData.loginPageEndPoint;

public class LoginPageTests extends BaseTestSetups {

    @Test(priority = 1, description = "Verify that registered user can log in")
    @Severity(SeverityLevel.BLOCKER)
    public void testRegisteredUserCanLogIn() {
//      String actualAddHotelNameText = newHotelPage.getTypedNameValue();
//      Log.LOG.debug("Comparison of actual result ('" + actualAddHotelNameText + "') " +
//              "and expected ('" + text + "')");
        MainPage mainPage = loginPage.setUserLogin(System.getProperty("test.user.name"))
                .setUserPassword(System.getProperty("test.user.password"))
                .clickOnSubmitInput();
        boolean actualIsMainPageLoaded = mainPage.isMainPageLoaded();
        mainPage.clickOnLogoutLink();
        Assert.assertTrue(actualIsMainPageLoaded, "Main page isn't loaded");
    }

    @Test(priority = 1, description = "Verify that user can go to New User page")
    @Severity(SeverityLevel.BLOCKER)
    public void testUserCanGoToNewUserPage() throws InterruptedException {
//      String actualAddHotelNameText = newHotelPage.getTypedNameValue();
//      Log.LOG.debug("Comparison of actual result ('" + actualAddHotelNameText + "') " +
//              "and expected ('" + text + "')");
        NewUserPage newUserPage = loginPage.clickOnRegisterNewUserLink();
        boolean actualIsNewUserPageLoaded = newUserPage.isNewUserPageLoaded();
        newUserPage.returnToLoginPage();
        Assert.assertTrue(actualIsNewUserPageLoaded, "Main page isn't loaded");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        LoginPage loginPage = new LoginPage(driver);
        if (!loginPage.isLoginPageLoaded()) {
            driver.get(loginPageEndPoint);
        }
//        if (testResult.getStatus() == ITestResult.FAILURE) {
//            Log.LOG.debug("Getting screenshot because of test is failed: ");
//            Screenshots.getScreenShot(driver);
    }

}
