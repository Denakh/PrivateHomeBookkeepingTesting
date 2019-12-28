import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BasePHBTestSetups {

    protected WebDriver driver;
    protected LoginPage loginPage;


    @BeforeClass(alwaysRun = true)
    public void setUpGeneral() throws Exception {
//      Log.LOG.debug("Test general set up");
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://private-home-bookkeeping-pv.herokuapp.com/login");
//      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDownGeneral(ITestContext iTestContext) throws Exception {
//      Log.LOG.debug("Test tear down general");
//        for (ITestResult testResult : iTestContext.getSkippedTests().getAllResults()) {
//            if (testResult.getStatus() == ITestResult.SKIP) {
//                Log.LOG.debug("Getting screenshot because of test is skipped: ");
//                Screenshots.getScreenShot(driver);
//                break;
//            }
//        }
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
