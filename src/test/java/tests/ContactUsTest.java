package tests;

import enums.MessageSubject;
import model.Message;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactUsFormPage;
import pages.TopMenuPage;
import utils.PageTitleUtils;

import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContactUsTest extends BaseTest {

    private TopMenuPage topMenuPage;
    private ContactUsFormPage contactUsFormPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);
        topMenuPage = new TopMenuPage(driver);
        contactUsFormPage = new ContactUsFormPage(driver);
    }

    @Test
    @Order(1)
    public void shouldNotAllowToSendEmptyContactUsForm() {
        topMenuPage.clickOnContactUsLink();
        contactUsFormPage.clickSendButton();
        assertThat(contactUsFormPage.isRedAlertBoxDisplayed()).isTrue();
    }

    @Test
    @Order(2)
    public void shouldNotAllowToSendContactUsFormWithEmailOnly() {
        topMenuPage.clickOnContactUsLink();
        contactUsFormPage.enterEmail("mm123@mm.abc");
        contactUsFormPage.clickSendButton();
        assertThat(contactUsFormPage.isRedAlertBoxDisplayed()).isTrue();
    }

    @Test
    @Order(3)
    public void shouldSendContactUsFormWithValidData() {
        topMenuPage.clickOnContactUsLink();
        Message message = new Message();
        message.setSubject(MessageSubject.WEBMASTER);
        message.setEmail("mm234@mm.asd");
        message.setOrderReference("123");
        message.setMessage("Text Message Text");
        contactUsFormPage.sendContactUsForm(message);
        assertThat(contactUsFormPage.isGreenAlertBoxDisplayed()).isTrue();
    }
}
