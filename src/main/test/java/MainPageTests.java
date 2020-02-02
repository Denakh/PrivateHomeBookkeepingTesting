import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;

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
    public void testPageNecessaryElementsArePresent() {
        Assert.assertTrue(mainPage.areNecessaryElementsPresent());
    }

    @AfterClass
    public void tearDown() {
        mainPage.clickOnLogoutLink();
    }

}
