package pages;

import model.Address;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourAddressPage extends BasePage {
    public YourAddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstname")
    WebElement inputFirstName;

    @FindBy(id = "lastname")
    WebElement inputLastName;

    @FindBy(id = "company")
    WebElement inputCompany;

    @FindBy(id = "address1")
    WebElement inputAddress;

    @FindBy(id = "city")
    WebElement inputCity;

    @FindBy(id = "id_state")
    WebElement inputState;

    @FindBy(id = "postcode")
    WebElement inputPostCode;

    @FindBy(id = "id_country")
    WebElement inputCountry;

    @FindBy(id = "other")
    WebElement inputOther;

    @FindBy(id = "phone")
    WebElement inputPhone;

    @FindBy(id = "phone_mobile")
    WebElement inputMobile;

    @FindBy(id = "alias")
    WebElement inputAlias;

    @FindBy(id = "submitAccount")
    WebElement submitAccountButton;

    public void clickRegisterButton() {
        submitAccountButton.click();
    }

    public void setAllAddressData(Address address, String firstName, String lastName){
        inputFirstName.clear();
        inputFirstName.sendKeys(firstName);
        inputLastName.clear();
        inputLastName.sendKeys(lastName);
        inputCompany.sendKeys(address.getCompany());
        inputAddress.sendKeys(address.getAddress());
        inputCity.sendKeys(address.getCity());
        inputState.sendKeys(address.getAddressState().getValue());
        inputPostCode.sendKeys(address.getPostalCode());
        inputCountry.sendKeys(address.getAddressCountry().getValue());
        inputOther.sendKeys(address.getAdditionalInfo());
        inputPhone.sendKeys(address.getHomePhone());
        inputMobile.sendKeys(address.getMobilePhone());
        clearMyAddress();
        inputAlias.sendKeys(address.getMyAddress());
    }

    public void clearMyAddress(){
        inputAlias.clear();
    }

}
