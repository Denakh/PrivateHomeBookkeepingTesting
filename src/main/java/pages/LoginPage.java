package pages;

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
}
