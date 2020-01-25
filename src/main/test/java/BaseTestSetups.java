import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;
import pages.MainPage;

import static data.TestData.loginPageEndPoint;

public class BaseTestSetups {

    protected WebDriver driver;
    protected LoginPage loginPage;

    //@BeforeSuite
    @BeforeClass(alwaysRun = true)
    public void setUpGeneral() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(loginPageEndPoint);
        loginPage = new LoginPage(driver);
    }

    //@AfterSuite
    @AfterClass(alwaysRun = true)
    public void tearDownGeneral(ITestContext iTestContext) {
        driver.manage().deleteAllCookies();
        driver.close();
    }

    protected MainPage goToTheMainPage(){
        LoginPage newloginPage = new LoginPage(driver);
        MainPage mainPage = newloginPage.setUserLogin(System.getProperty("test.user.name"))
                .setUserPassword(System.getProperty("test.user.password"))
                .clickOnSubmitInput();
        if (mainPage.isMainPageLoaded()) {
            return mainPage;
        }
        return null;
    }

}
