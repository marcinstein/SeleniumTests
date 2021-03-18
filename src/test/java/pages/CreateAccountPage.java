package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ElementDisplayedUtils;

public class CreateAccountPage extends BasePage {
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email_create")
    WebElement inputEmailField;

    @FindBy(id = "SubmitCreate")
    WebElement createAccountButton;

    @FindBy(id = "create_account_error")
    WebElement invalidEmailRedAlert;

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(inputEmailField));
        inputEmailField.sendKeys(email);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public boolean isRedAlertBoxDisplayed() {
        return ElementDisplayedUtils.isElementDisplayed(invalidEmailRedAlert, wait);
    }

}