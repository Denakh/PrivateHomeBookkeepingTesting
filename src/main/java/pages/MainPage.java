package pages;

import io.qameta.allure.Step;
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

    @FindBy(xpath = "//p[text()='Your operations']")
    protected WebElement yourOperationsHead;

    @FindBy(xpath = "//h2[contains(text(),'Alerts')]")
    protected WebElement alertsHead;

    @FindBy(xpath = "//h2[contains(text(),'Notifications')]")
    protected WebElement notificationsHead;

    @FindBy(xpath = "//p[contains(text(),'Only for users with admin roles')]")
    protected WebElement onlyForAdminHead;

    @FindBy(xpath = "//a[@href='/income_fixation' and text()='Income fixation']")
    protected WebElement incomeFixationLink;

    @FindBy(xpath = "//a[@href='/expense_fixation' and text()='Expense fixation (not current)']")
    protected WebElement expenseFixationLink;

    @FindBy(xpath = "//a[@href='/debt_fixation' and text()='Debt fixation (in or out)']")
    protected WebElement debtFixationLink;

    @FindBy(xpath = "//a[@href='/deferrals_fixation' and text()='Deferrals (expenses) fixation']")
    protected WebElement deferralsFixationLink;

    @FindBy(xpath = "//a[@href='/communal_pays_fixation' and text()='Communal pays fixation']")
    protected WebElement communalPaysFixationLink;

    @FindBy(xpath = "//a[@href='/data_getting' and text()='Main data getting']")
    protected WebElement dataGettingLink;

    @FindBy(xpath = "//a[@href='/current_expenses_rate' and text()='Current expenses rate']")
    protected WebElement currentExpensesRateLink;

    @FindBy(xpath = "//a[@href='/foreign_currencies' and text()='Foreign currencies operations']")
    protected WebElement foreignCurrenciesFixationLink;

    @FindBy(xpath = "//a[@href='/allocation_of_profits' and text()='Allocation of profits']")
    protected WebElement allocationOfProfitsLink;

    public MainPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @Step("I click on logout link")
    public void clickOnLogoutLink() {
        logoutLink.click();
    }

    @Step("Verify that main page is loaded")
    public boolean isMainPageLoaded() {
        return mainPageHead.isDisplayed() && logoutLink.isDisplayed();
    }

    @Step("Verify that main page has all expected elements")
    public boolean areNecessaryElementsPresent() {
        return newEmailInput.isDisplayed() &&
                newPhoneInput.isDisplayed() &&
                submitUpdateInput.isDisplayed() &&
                yourOperationsHead.isDisplayed() &&
                alertsHead.isDisplayed() &&
                notificationsHead.isDisplayed() &&
                onlyForAdminHead.isDisplayed() &&
                incomeFixationLink.isDisplayed() &&
                expenseFixationLink.isDisplayed() &&
                debtFixationLink.isDisplayed() &&
                deferralsFixationLink.isDisplayed() &&
                communalPaysFixationLink.isDisplayed() &&
                dataGettingLink.isDisplayed() &&
                currentExpensesRateLink.isDisplayed() &&
                foreignCurrenciesFixationLink.isDisplayed() &&
                allocationOfProfitsLink.isDisplayed();
    }

}
