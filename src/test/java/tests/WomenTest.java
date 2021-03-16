package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TopMenuPage;
import pages.WomenPage;
import utils.PageTitleUtils;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class WomenTest extends BaseTest {
    private TopMenuPage topMenuPage;
    private WomenPage womenPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);
        topMenuPage = new TopMenuPage(driver);
        womenPage = new WomenPage(driver);
    }

    @Test
    public void shouldVerifyThereAreNoBlankPrices() {
        topMenuPage.clickOnWomenLink();
        List<String> productPrices = womenPage.getProductPricesString();
        List<String> productsWithEmptyPrice = productPrices.stream()
                .filter(String::isEmpty)
                .collect(Collectors.toList());
        assertThat(productsWithEmptyPrice).isEmpty();
    }

    @Test
    public void shouldVerifyAllPricesGreaterThanZero() {
        topMenuPage.clickOnWomenLink();
        List<Double> productPrices = womenPage.getProductPricesDouble();
        List<Double> productsWithNegativePrice = productPrices.stream()
                .filter(el -> el < 0)
                .collect(Collectors.toList());
        assertThat(productsWithNegativePrice).isEmpty();
    }
}
