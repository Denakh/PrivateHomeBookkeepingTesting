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

    @Test(priority = 2, description = "Verify that all necessary page elements are present")
    @Severity(SeverityLevel.CRITICAL)
    public void testNecessaryPageElementsArePresent() {
        Assert.assertTrue(mainPage.areNecessaryElementsPresent());
    }

    @AfterClass
    public void tearDown() {
        mainPage.clickOnLogoutLink();
    }

}
