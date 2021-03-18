package tests;

import com.github.javafaker.Faker;
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

    Faker faker = new Faker();

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
        createAccountPage.enterEmail(faker.internet().emailAddress());
        createAccountPage.clickCreateAccountButton();
        PersonalInformation personalInformation = new PersonalInformation();
        personalInformation.setDayOfBirth(DayOfBirth.FIFTEEN);
        personalInformation.setFirstName(faker.name().firstName());
        personalInformation.setLastName(faker.name().lastName());
        personalInformation.setEmail(faker.internet().emailAddress());
        personalInformation.setPassword(faker.internet().password());
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
        createAccountPage.enterEmail(faker.internet().emailAddress());
        createAccountPage.clickCreateAccountButton();
        yourPersonalInformationPage.clickTitleMrs();
        yourPersonalInformationPage.clearEmail();
        yourPersonalInformationPage.enterFirstName(faker.name().firstName());
        yourPersonalInformationPage.enterLastName(faker.name().lastName());
        yourPersonalInformationPage.clearEmail();
        yourPersonalInformationPage.enterPassword(faker.internet().password());
        yourPersonalInformationPage.clickSpecialOfferCheckbox();
        yourPersonalInformationPage.clickNewsletterCheckbox();
        yourAddressPage.clickRegisterButton();
        assertThat(yourPersonalInformationPage.isRedAlertBoxDisplayed()).isTrue();
    }

    @Test
    public void shouldCreateAccount() {
        topMenuPage.clickSignInLink();
        createAccountPage.enterEmail(faker.internet().emailAddress());
        createAccountPage.clickCreateAccountButton();
        PersonalInformation personalInformation = new PersonalInformation();
        personalInformation.setDayOfBirth(DayOfBirth.FIFTEEN);
        personalInformation.setFirstName(faker.name().firstName());
        personalInformation.setLastName(faker.name().lastName());
        personalInformation.setEmail(faker.internet().emailAddress());
        personalInformation.setPassword(faker.internet().password());
        personalInformation.setDayOfBirth(DayOfBirth.FIFTEEN);
        personalInformation.setMonthOfBirth(MonthOfBirth.AUGUST);
        personalInformation.setYearOfBirth(YearOfBirth.YEAR1981);
        yourPersonalInformationPage.clickTitleMr();
        yourPersonalInformationPage.clearEmail();
        yourPersonalInformationPage.setAllPersonalInformation(personalInformation);
        Address address = new Address();
        address.setCompany(faker.company().name());
        address.setAddress(faker.address().streetAddress());
        address.setCity(faker.address().city());
        address.setAddressState(AddressState.TEXAS);
        address.setPostalCode(faker.number().digits(5));
        address.setAddressCountry(AddressCountry.UNITED_STATES);
        address.setAdditionalInfo(faker.lorem().sentence());
        address.setHomePhone(faker.phoneNumber().cellPhone());
        address.setMobilePhone(faker.phoneNumber().cellPhone());
        address.setMyAddress(faker.address().streetName());
        yourAddressPage.setAllAddressData(address, faker.name().firstName(), faker.name().lastName());
        yourAddressPage.clickRegisterButton();
        assertThat(yourPersonalInformationPage.isAccountCreatedTextDisplayed()).isTrue();
    }
}

