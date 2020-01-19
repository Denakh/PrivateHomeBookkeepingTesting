package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    protected WebDriver driver;

    @FindBy(css = "input[name='j_login']")
    protected WebElement loginInput;

    @FindBy(css = "input[name='j_password']")
    protected WebElement passwordInput;

    @FindBy(css = "input[type='submit']")
    protected WebElement submitInput;

    @FindBy(xpath = "//a[text()='Register new user']")
    protected WebElement registerNewUserLink;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @Step("I set test user login")
    public LoginPage setUserLogin(String userLogin) {
//        Log.LOG.debug("Clicking on hotel menu");
        loginInput.sendKeys(userLogin);
        return this;
    }

    @Step("I set test user password")
    public LoginPage setUserPassword(String userPassword) {
//        Log.LOG.debug("Clicking on hotel menu");
        passwordInput.sendKeys(userPassword);
        return this;
    }

    @Step("I click on the submit input")
    public MainPage clickOnSubmitInput() {
//        Log.LOG.debug("Clicking on hotel menu");
        submitInput.click();
        return new MainPage(driver);
    }

    @Step("I click on the Register New User link")
    public NewUserPage clickOnRegisterNewUserLink() {
//        Log.LOG.debug("Clicking on hotel menu");
        registerNewUserLink.click();
        return new NewUserPage(driver);
    }

    @Step("Verify login page is loaded")
    public boolean isLoginPageLoaded() {
        return loginInput.isDisplayed() &&
                passwordInput.isDisplayed() &&
                submitInput.isDisplayed() &&
                registerNewUserLink.isDisplayed();
    }

}
