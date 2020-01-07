import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MainPage;

import java.io.IOException;

public class LoginPageTests extends BasePHBTestSetups {

    @Test(priority = 1, description = "Verify that registered user can log in")
    @Severity(SeverityLevel.BLOCKER)
    public void testRegisteredUserCanLogIn() {
//      String actualAddHotelNameText = newHotelPage.getTypedNameValue();
//      Log.LOG.debug("Comparison of actual result ('" + actualAddHotelNameText + "') " +
//              "and expected ('" + text + "')");

        loginPage.setUserLogin(System.getProperty("test.user.name"))
                .setUserPassword(System.getProperty("test.user.password"))
                .clickOnSubmitInput();

        boolean actualIsMainPageLoaded = new MainPage(driver).isMainPageLoaded();

        Assert.assertTrue(actualIsMainPageLoaded, "Main page isn't loaded");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        MainPage mainPage = new MainPage(driver);
        if (mainPage.isMainPageLoaded()) {
            mainPage.clickOnLogoutLink();
        }
//        if (testResult.getStatus() == ITestResult.FAILURE) {
//            Log.LOG.debug("Getting screenshot because of test is failed: ");
//            Screenshots.getScreenShot(driver);
    }


}
