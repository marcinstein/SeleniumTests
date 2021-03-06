package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementDisplayedUtils;

public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "product-count")
    WebElement productCountText;

    @FindBy(css = ".right-block .product-name")
    WebElement resultProductName;

    @FindBy(css = ".right-block .product-price")
    WebElement resultPrice;

    public boolean isProductCountTextDisplayed() {
        return ElementDisplayedUtils.isElementDisplayed(productCountText, wait);
    }

    public String getProductCountText() {
        isProductCountTextDisplayed();
        return productCountText.getText().trim();
    }

    public String getProductName() {
        isProductCountTextDisplayed();
        return resultProductName.getText().trim();
    }

    public String getProductPrice() {
        isProductCountTextDisplayed();
        return resultPrice.getText().trim();
    }
}