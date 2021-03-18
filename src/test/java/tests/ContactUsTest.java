package tests;

import com.github.javafaker.Faker;
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

    Faker faker = new Faker();

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
        contactUsFormPage.enterEmail(faker.internet().emailAddress());
        contactUsFormPage.clickSendButton();
        assertThat(contactUsFormPage.isRedAlertBoxDisplayed()).isTrue();
    }

    @Test
    @Order(3)
    public void shouldSendContactUsFormWithValidData() {
        topMenuPage.clickOnContactUsLink();
        Message message = new Message();
        message.setSubject(MessageSubject.WEBMASTER);
        message.setEmail(faker.internet().emailAddress());
        message.setOrderReference(faker.number().digits(3));
        message.setMessage(faker.lorem().sentence());
        contactUsFormPage.sendContactUsForm(message);
        assertThat(contactUsFormPage.isGreenAlertBoxDisplayed()).isTrue();
    }
}
