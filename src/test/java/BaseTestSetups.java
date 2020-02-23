import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import pages.MainPage;

public class BaseTestSetups {

    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setUpGeneral() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//      driver.get(loginPageEndPoint);
        driver.get("https://private-home-bookkeeping-pv.herokuapp.com/login");
        loginPage = new LoginPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDownGeneral(ITestContext iTestContext) {
        driver.manage().deleteAllCookies();
        driver.close();
    }

    protected MainPage goToTheMainPage(){
        LoginPage newloginPage = new LoginPage(driver);
//      MainPage mainPage = newloginPage.setUserLogin(System.getProperty("test.user.name"))
//              .setUserPassword(System.getProperty("test.user.password"))
//              .clickOnSubmitInput();
        MainPage mainPage = newloginPage.setUserLogin("test_user")
                .setUserPassword("test_user")
                .clickOnSubmitInput();
        if (mainPage.isMainPageLoaded()) {
            return mainPage;
        }
        return null;
    }

}
