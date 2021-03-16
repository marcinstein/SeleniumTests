package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class WomenPage extends BasePage {
    public WomenPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='right-block']/*[@class='content_price']/*[@class='price product-price']")
    List<WebElement> productWomenPrices;


    public List<String> getProductPricesString() {
        return productWomenPrices.stream()
                .map(el -> el.getText().replace("$", "").trim())
                .collect(Collectors.toList());
    }

    public List<Double> getProductPricesDouble() {
        return productWomenPrices.stream()
                .map(el -> el.getText().replace("$", " "))
                .map(String::trim)
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }
}
