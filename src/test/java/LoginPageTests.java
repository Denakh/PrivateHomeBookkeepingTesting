import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.NewUserPage;

import static data.TestData.LOGIN_PAGE_END_POINT;

public class LoginPageTests extends BaseTestSetups {

    @Test(priority = 1, description = "Verify that registered user can log in")
    @Severity(SeverityLevel.BLOCKER)
    public void testRegisteredUserCanLogIn() {
        MainPage mainPage = goToTheMainPage();
        Assert.assertNotNull(mainPage, "Main page isn't loaded");
        mainPage.clickOnLogoutLink();
    }

    @Test(priority = 1, description = "Verify that user can go to New User page")
    @Severity(SeverityLevel.BLOCKER)
    public void testUserCanGoToNewUserPage() {
        NewUserPage newUserPage = loginPage.clickOnRegisterNewUserLink();
        boolean actualIsNewUserPageLoaded = newUserPage.isNewUserPageLoaded();
        newUserPage.returnToLoginPage();
        Assert.assertTrue(actualIsNewUserPageLoaded, "Main page isn't loaded");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        LoginPage loginPage = new LoginPage(driver);
        if (!loginPage.isLoginPageLoaded()) {
            driver.get(LOGIN_PAGE_END_POINT);
        }
    }

}
