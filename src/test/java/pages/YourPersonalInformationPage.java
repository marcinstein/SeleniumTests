package pages;

import model.PersonalInformation;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class YourPersonalInformationPage extends BasePage {
    public YourPersonalInformationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "uniform-id_gender1")
    WebElement radioButtonMr;

    @FindBy(id = "uniform-id_gender2")
    WebElement radioButtonMrs;

    @FindBy(id = "customer_firstname")
    WebElement inputFirstName;

    @FindBy(id = "customer_lastname")
    WebElement inputLastName;

    @FindBy(id = "email")
    WebElement inputEmail;

    @FindBy(id = "passwd")
    WebElement inputPassword;

    @FindBy(id = "days")
    WebElement selectDay;

    @FindBy(id = "months")
    WebElement selectMonth;

    @FindBy(id = "years")
    WebElement selectYear;

    @FindBy(id = "newsletter")
    WebElement checkboxNewsletter;

    @FindBy(id = "optin")
    WebElement checkboxSpecialOffers;

    @FindBy(css = ".alert.alert-danger")
    WebElement redAlertBox;

    @FindBy(css = ".info-account")
    WebElement accountCreated;

    public void clickTitleMr() {
        wait.until(ExpectedConditions.visibilityOf(radioButtonMr));
        radioButtonMr.click();
    }

    public void clickTitleMrs() {
        wait.until(ExpectedConditions.visibilityOf(radioButtonMr));
        radioButtonMrs.click();
    }

    public void enterFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        inputLastName.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public void clearEmail() {
        inputEmail.clear();
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickNewsletterCheckbox() {
        checkboxNewsletter.click();
    }

    public void clickSpecialOfferCheckbox() {
        checkboxSpecialOffers.click();
    }

    public void setAllPersonalInformation(PersonalInformation personalInformation) {
        inputFirstName.sendKeys(personalInformation.getFirstName());
        inputLastName.sendKeys(personalInformation.getLastName());
        inputEmail.sendKeys(personalInformation.getEmail());
        inputPassword.sendKeys(personalInformation.getPassword());
        selectDay.sendKeys(personalInformation.getDayOfBirth().getValue());
        selectMonth.sendKeys(personalInformation.getMonthOfBirth().getValue());
        selectYear.sendKeys(personalInformation.getYearOfBirth().getValue());
    }

    public boolean isRedAlertBoxDisplayed() {
        return isElementDisplayed(redAlertBox);
    }

    public boolean isAccountCreatedTextDisplayed() {
        return isElementDisplayed(accountCreated);
    }

    private boolean isElementDisplayed(WebElement box) {
        wait.until(ExpectedConditions.visibilityOf(box));
        boolean isDisplayed = false;
        try {
            isDisplayed = box.isDisplayed();
        } catch (NoSuchElementException e) {
        }
        return isDisplayed;
    }

}
