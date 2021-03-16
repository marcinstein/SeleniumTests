package tests;

import enums.*;
import model.Address;
import model.PersonalInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import utils.PageTitleUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateAccountTest extends BaseTest {
    private TopMenuPage topMenuPage;
    private CreateAccountPage createAccountPage;
    private YourPersonalInformationPage yourPersonalInformationPage;
    private YourAddressPage yourAddressPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);
        topMenuPage = new TopMenuPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        yourPersonalInformationPage = new YourPersonalInformationPage(driver);
        yourAddressPage = new YourAddressPage(driver);
    }

    @Test
    public void shouldNotAllowToEnterInvalidEmailAlertBox() {
        topMenuPage.clickSignInLink();
        createAccountPage.enterEmail("bad_bad");
        createAccountPage.clickCreateAccountButton();
        assertThat(createAccountPage.isRedAlertBoxDisplayed()).isTrue();
    }

    @Test
    public void shouldNotCreateNewAccountAddressMissing() {
        topMenuPage.clickSignInLink();
        createAccountPage.enterEmail("msms32@msms.ms");
        createAccountPage.clickCreateAccountButton();
        PersonalInformation personalInformation = new PersonalInformation();
        personalInformation.setDayOfBirth(DayOfBirth.FIFTEEN);
        personalInformation.setFirstName("Marcin");
        personalInformation.setLastName("Testowy");
        personalInformation.setEmail("msms@ms.ms");
        personalInformation.setPassword("pwdpwd");
        personalInformation.setDayOfBirth(DayOfBirth.FIFTEEN);
        personalInformation.setMonthOfBirth(MonthOfBirth.AUGUST);
        personalInformation.setYearOfBirth(YearOfBirth.YEAR1981);
        yourPersonalInformationPage.clickTitleMr();
        yourPersonalInformationPage.clearEmail();
        yourPersonalInformationPage.setAllPersonalInformation(personalInformation);
        yourAddressPage.clickRegisterButton();
        assertThat(yourPersonalInformationPage.isRedAlertBoxDisplayed()).isTrue();
    }

    @Test
    public void shouldNotCreateNewAccountPersonalEmailMissing() {
        topMenuPage.clickSignInLink();
        createAccountPage.enterEmail("msms56@msms.ms");
        createAccountPage.clickCreateAccountButton();
        yourPersonalInformationPage.clickTitleMrs();
        yourPersonalInformationPage.clearEmail();
        yourPersonalInformationPage.enterFirstName("Marcin");
        yourPersonalInformationPage.enterLastName("Testus");
        yourPersonalInformationPage.clearEmail();
        yourPersonalInformationPage.enterPassword("abcdabcd");
        yourPersonalInformationPage.clickSpecialOfferCheckbox();
        yourPersonalInformationPage.clickNewsletterCheckbox();
        yourAddressPage.clickRegisterButton();
        assertThat(yourPersonalInformationPage.isRedAlertBoxDisplayed()).isTrue();
    }

    @Test
    public void shouldCreateAccount() {
        topMenuPage.clickSignInLink();
        createAccountPage.enterEmail("msms77@msms.ms");
        createAccountPage.clickCreateAccountButton();
        PersonalInformation personalInformation = new PersonalInformation();
        personalInformation.setDayOfBirth(DayOfBirth.FIFTEEN);
        personalInformation.setFirstName("Marcin");
        personalInformation.setLastName("Testowy");
        personalInformation.setEmail("msms77@ms.ms");
        personalInformation.setPassword("pwdpwd");
        personalInformation.setDayOfBirth(DayOfBirth.FIFTEEN);
        personalInformation.setMonthOfBirth(MonthOfBirth.AUGUST);
        personalInformation.setYearOfBirth(YearOfBirth.YEAR1981);
        yourPersonalInformationPage.clickTitleMr();
        yourPersonalInformationPage.clearEmail();
        yourPersonalInformationPage.setAllPersonalInformation(personalInformation);
        Address address = new Address();
        address.setCompany("Super Company");
        address.setAddress("OverTheRainbow 1.2");
        address.setCity("DarkMoon");
        address.setAddressState(AddressState.TEXAS);
        address.setPostalCode("98765");
        address.setAddressCountry(AddressCountry.UNITED_STATES);
        address.setAdditionalInfo("Something");
        address.setHomePhone("987654321");
        address.setMobilePhone("123456789");
        address.setMyAddress("Behind the Moon");
        yourAddressPage.setAllAddressData(address, "Marcin", "Testing");
        yourAddressPage.clickRegisterButton();
        assertThat(yourPersonalInformationPage.isAccountCreatedTextDisplayed()).isTrue();
    }
}

