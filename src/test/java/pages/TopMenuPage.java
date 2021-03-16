package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuPage extends BasePage {

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;

    @FindBy(linkText = "Women")
    WebElement womenLink;

    @FindBy(id = "search_query_top")
    WebElement searchInput;

    @FindBy(className = "button-search")
    WebElement searchButton;

    @FindBy(linkText = "Sign in")
    WebElement signInLink;

    public void clickOnContactUsLink() {
        contactUsLink.click();
    }

    public void clickOnWomenLink() {
        womenLink.click();
    }

    public void inputSearchText(String text) {
        searchInput.sendKeys(text);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickSignInLink() {
        signInLink.click();
    }
}
