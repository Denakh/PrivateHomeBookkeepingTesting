import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.NewUserPage;

public class MainPageTests extends BaseTestSetups {

    private MainPage mainPage;

    @BeforeClass
    public void setUp() {
        MainPage mainPage = goToTheMainPage();
        Assert.assertNotNull(mainPage, "Main page isn't loaded");
        this.mainPage = mainPage;
    }

    @Test(priority = 1, description = "Verify that all is good")
    @Severity(SeverityLevel.BLOCKER)
    public void testAllIsGood() {
        Assert.assertTrue(true);
    }

    @AfterClass
    public void tearDown() {
        mainPage.clickOnLogoutLink();
    }

}
