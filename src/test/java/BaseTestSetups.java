import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import pages.MainPage;

import static data.TestData.LOGIN_PAGE_END_POINT;

public class BaseTestSetups {

    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setUpGeneral() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(LOGIN_PAGE_END_POINT);
        loginPage = new LoginPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDownGeneral(ITestContext iTestContext) {
        driver.manage().deleteAllCookies();
        driver.close();
    }

    protected MainPage goToTheMainPage(){
        LoginPage newloginPage = new LoginPage(driver);
        MainPage mainPage = newloginPage.setUserLogin(System.getenv("USER_NAME"))
                .setUserPassword(System.getenv("USER_PASSWORD"))
                .clickOnSubmitInput();
        if (mainPage.isMainPageLoaded()) {
            return mainPage;
        }
        return null;
    }

}
