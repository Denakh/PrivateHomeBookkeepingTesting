package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    protected WebDriver driver;

    @FindBy(xpath = "//div[contains(text(),'Your login is')]")
    protected WebElement mainPageHead;

    @FindBy(css = "input[name='email']")
    protected WebElement newEmailInput;

    @FindBy(css = "input[name='phone']")
    protected WebElement newPhoneInput;

    @FindBy(css = "input[type='submit'][value='Update']")
    protected WebElement submitUpdateInput;

    @FindBy(css = "a[href='/logout']")
    protected WebElement logoutLink;

    public MainPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

}
