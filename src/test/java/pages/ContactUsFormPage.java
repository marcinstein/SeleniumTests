package pages;

import model.Message;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.ElementDisplayedUtils;

public class ContactUsFormPage extends BasePage {

    public ContactUsFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "submitMessage")
    WebElement sendButton;

    @FindBy(className = "alert-danger")
    WebElement redAlertBox;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "id_contact")
    WebElement subjectSelect;

    @FindBy(id = "id_order")
    WebElement orderReferenceInput;

    @FindBy(id = "message")
    WebElement messageTextArea;

    @FindBy(className = "alert-success")
    WebElement greenAlertBox;


    public void clickSendButton() {
        sendButton.click();
    }


    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public boolean isRedAlertBoxDisplayed() {
        return ElementDisplayedUtils.isElementDisplayed(redAlertBox, wait);
    }

    public boolean isGreenAlertBoxDisplayed() {
        return ElementDisplayedUtils.isElementDisplayed(greenAlertBox, wait);
    }

    public void sendContactUsForm(Message message) {
        Select subject = new Select(subjectSelect);
        subject.selectByVisibleText(message.getSubject().getValue());
        emailInput.sendKeys(message.getEmail());
        orderReferenceInput.sendKeys(message.getOrderReference());
        messageTextArea.sendKeys(message.getMessage());
        sendButton.click();
    }
}
