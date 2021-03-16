package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SearchResultPage;
import pages.TopMenuPage;
import utils.PageTitleUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultTest extends BaseTest {
    private TopMenuPage topMenuPage;
    private SearchResultPage searchResultPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);
        topMenuPage = new TopMenuPage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    @Test
    public void shouldReturnBlouseSearchResultCount() {
        topMenuPage.inputSearchText("Blouse");
        topMenuPage.clickSearchButton();
        assertThat(searchResultPage.getProductCountText()).isEqualTo("Showing 1 - 1 of 1 item");
    }

    @Test
    public void shouldReturnBlouseSearchResultName() {
        topMenuPage.inputSearchText("Blouse");
        topMenuPage.clickSearchButton();
        assertThat(searchResultPage.getProductName()).isEqualTo("Blouse");
    }

    @Test
    public void verifyBlouseSearchResultPriceIsAvailable() {
        topMenuPage.inputSearchText("Blouse");
        topMenuPage.clickSearchButton();
        assertThat(searchResultPage.getProductPrice()).isEqualTo("$27.00");
    }
}
