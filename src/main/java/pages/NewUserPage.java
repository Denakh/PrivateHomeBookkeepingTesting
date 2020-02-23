package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewUserPage {

    protected WebDriver driver;

    @FindBy(css = "input[name='login']")
    protected WebElement loginInput;

    @FindBy(css = "input[name='password']")
    protected WebElement passwordInput;

    @FindBy(css = "input[name='email']")
    protected WebElement emailInput;

    @FindBy(css = "input[name='phone']")
    protected WebElement phoneInput;

    @FindBy(css = "input[type='submit']")
    protected WebElement submitInput;

    public NewUserPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @Step("Verify New User page is loaded")
    public boolean isNewUserPageLoaded() {
        return loginInput.isDisplayed() &&
                passwordInput.isDisplayed() &&
                emailInput.isDisplayed() &&
                phoneInput.isDisplayed() &&
                submitInput.isDisplayed();
    }

    @Step("Verify New User page is loaded")
    public LoginPage returnToLoginPage() {
        // driver.get(loginPageEndPoint);
        driver.get("https://private-home-bookkeeping-pv.herokuapp.com/login");
        return new LoginPage(driver);
    }

}