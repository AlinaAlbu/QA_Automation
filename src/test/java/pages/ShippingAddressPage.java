package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShippingAddressPage extends PageBase {

    @FindBy(xpath = "//*[@type='checkbox']")
    private WebElement shipToTheSameAddress_Button;

    @FindBy(xpath = "//*[@name='billing_address_id']")
    private List<WebElement> billingAddressInput;

    @FindBy(xpath = "//*[@id='BillingNewAddress_FirstName']")
    private WebElement billingFirstNameInput;
    @FindBy(xpath = "//*[@id='BillingNewAddress_LastName']")
    private WebElement billingLastNameInput;
    @FindBy(xpath = "//*[@id='BillingNewAddress_Email']")
    private WebElement billingEmailInput;
    @FindBy(xpath = "//*[@id='BillingNewAddress_Company']")
    private WebElement billingCompanyInput;
    @FindBy(xpath = "//*[@id='BillingNewAddress_CountryId']")
    private WebElement billingCountryDropDown;
    @FindBy(xpath = "//*[@id='BillingNewAddress_StateProvinceId']")
    private WebElement billingStateDropDown;
    @FindBy(xpath = "//*[@id='BillingNewAddress_City']")
    private WebElement billingCityInput;
    @FindBy(xpath = "//*[@id='BillingNewAddress_Address1']")
    private WebElement billingAddress_1_Input;
    @FindBy(xpath = "//*[@id='BillingNewAddress_Address2']")
    private WebElement billingAddress_2_Input;
    @FindBy(xpath = "//*[@id='BillingNewAddress_ZipPostalCode']")
    private WebElement billingZipInput;
    @FindBy(xpath = "//*[@id='BillingNewAddress_PhoneNumber']")
    private WebElement billingPhoneNoInput;
    @FindBy(xpath = "//*[@id='BillingNewAddress_FaxNumber']")
    private WebElement billingFaxNoInput;
    @FindBy(xpath = "//div[@id='shipping-buttons-container']//input[@class='button-1 new-address-next-step-button']")
    private WebElement continueToShippingMethodButton;

    public ShippingAddressPage(WebDriver driver) {
        super(driver);
    }

    public void setShipToTheSameAddress_Button(int index) {
        if (shipToTheSameAddress_Button.isSelected())
            continueToShippingMethodButton.click();
        else {
            billingAddressInput.get(index).click();
        }
    }



    // sa nu duplic codul, cum refolosesc codul din BillingAddressPage

    public void newShippingAddress(String firstName, String lastName,
                                   String email, String company, String country, String state,
                                   String city, String address_1, String address_2, String zip,
                                   String phone, String fax) {
        fillIn_BillingFirstName(firstName);
        fillIn_BillingLastName(lastName);
        fillIn_BillingEmail(email);
        fillIn_BillingCompany(company);
        fillIn_BillingCountry(country);
        fillIn_BillingState(state);
        fillIn_BillingCity(city);
        fillIn_BillingAddress1(address_1);
        fillIn_BillingAddrees2(address_2);
        fillIn_BillingZip(zip);
        fillIn_BillingPhoneNo(phone);
        fillIn_BillingFaxNo(fax);

        continueToShippingMethodButton.click();
    }

    public void fillIn_BillingFirstName(String firstName) {
        billingFirstNameInput.sendKeys(firstName);
    }

    public void fillIn_BillingLastName(String lastName) {
        billingLastNameInput.sendKeys();
    }

    public void fillIn_BillingEmail(String email) {
        billingEmailInput.sendKeys();
    }

    public void fillIn_BillingCompany(String company) {
        billingCompanyInput.sendKeys(company);
    }

    public void fillIn_BillingCountry(String country) {
        Select s = new Select(billingCountryDropDown);
        s.selectByVisibleText(country);
    }

    public void fillIn_BillingState(String state) {
        wait.until(ExpectedConditions.visibilityOfAllElements(billingStateDropDown));
        Select s = new Select(billingStateDropDown);
        s.selectByVisibleText(state);
    }

    public void fillIn_BillingCity(String city) {
        billingCityInput.sendKeys(city);
    }

    public void fillIn_BillingAddress1(String address_1) {
        billingAddress_1_Input.sendKeys(address_1);
    }

    public void fillIn_BillingAddrees2(String address_2) {
        billingAddress_2_Input.sendKeys(address_2);
    }

    public void fillIn_BillingZip(String zip) {
        billingZipInput.sendKeys(zip);
    }

    public void fillIn_BillingPhoneNo(String phone) {
        billingPhoneNoInput.sendKeys(phone);
    }

    public void fillIn_BillingFaxNo(String fax) {
        billingFaxNoInput.sendKeys(fax);
    }

}


