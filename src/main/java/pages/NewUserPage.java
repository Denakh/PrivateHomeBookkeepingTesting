package pages;

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

    @FindBy(css = "input[type='email']")
    protected WebElement emailInput;

    @FindBy(css = "input[type='phone']")
    protected WebElement phoneInput;

    @FindBy(css = "input[type='submit']")
    protected WebElement submitInput;

    public NewUserPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}