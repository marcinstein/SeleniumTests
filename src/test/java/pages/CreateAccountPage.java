package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    private boolean isAlertBoxDisplayed(WebElement box) {
        wait.until(ExpectedConditions.visibilityOf(box));
        boolean isDisplayed = false;
        try {
            isDisplayed = box.isDisplayed();
        } catch (NoSuchElementException e) {
        }
        return isDisplayed;
    }

    public boolean isRedAlertBoxDisplayed() {
        return isAlertBoxDisplayed(invalidEmailRedAlert);
    }

}