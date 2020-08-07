package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.PageBase;

import java.util.ArrayList;
import java.util.List;

public class BillingAddressPage extends PageBase {

    @FindBy(id = "ShipToSameAddress")
    private WebElement shipToTheSameAddressButton;

    @FindBy(id = "BillingNewAddress_FirstName")
    private WebElement firstNameInput;
    @FindBy(id = "BillingNewAddress_LastName")
    private WebElement lastNameInput;
    @FindBy(id = "BillingNewAddress_Email")
    private WebElement emailInput;
    @FindBy(id = "BillingNewAddress_Company")
    private WebElement companyInput;
    @FindBy(xpath = "//*[@data-trigger='country-select']")
    private WebElement countryDropDown;
    @FindBy(id="states-loading-progress")
    private WebElement statesLoadingAnimation;
    @FindBy(xpath = "//*[@id='BillingNewAddress_StateProvinceId']")
    private WebElement stateDropDown;
    @FindBy(xpath = "//*[@data-val-required='City is required']")
    private WebElement cityInput;
    @FindBy(xpath = "//*[@data-val-required='Street address is required']")
    private WebElement address_1Input;
    @FindBy(xpath = "//*[@id='BillingNewAddress_Address2']")
    private WebElement address_2Input;
    @FindBy(xpath = "//*[@data-val-required='Zip / postal code is required']")
    private WebElement zipInput;
    @FindBy(xpath = "//*[@data-val-required='Phone is required']")
    private WebElement phoneNoInput;
    @FindBy(xpath = "//*[@id='BillingNewAddress_FaxNumber']")
    private WebElement faxNoInput;

    @FindBy(xpath = "//*[@id='billing-buttons-container']")
    private WebElement continueToShippingButton;

    @FindBy(xpath = "//span[@class='field-validation-error']")
    private List<WebElement> billingErrorMessages;

    public BillingAddressPage(WebDriver driver) {
        super(driver);

    }

    public void fillInBillingAddress(String firstName, String lastName,
                                     String email, String company, String country, String state,
                                     String city, String address_1, String address_2, String zip,
                                     String phone, String fax) {
        fillIn_FirstName(firstName);
        fillIn_LastName(lastName);
        fillIn_Email(email);
        fillIn_Company(company);
        fillIn_Country(country);
        fillIn_State(state);
        fillIn_City(city);
        fillIn_Address1(address_1);
        fillIn_Address2(address_2);
        fillIn_Zip(zip);
        fillIn_PhoneNo(phone);
        fillIn_FaxNo(fax);

        continueToShippingButton.click();
    }

    public void shipToTheSameAddress(boolean sameAddress ){
        wait.until(ExpectedConditions.visibilityOf(shipToTheSameAddressButton));
        if (sameAddress == true && !shipToTheSameAddressButton.isSelected() )
            shipToTheSameAddressButton.click();
            else
            if (sameAddress == false && shipToTheSameAddressButton.isSelected() )
                shipToTheSameAddressButton.click();

    }

    public void fillIn_FirstName(String firstName) {

        wait.until(ExpectedConditions.visibilityOf(firstNameInput));

        firstNameInput.sendKeys(firstName);
    }

    public void fillIn_LastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void fillIn_Email(String email) {
        emailInput.sendKeys(email);
    }

    public void fillIn_Company(String company) {
        companyInput.sendKeys(company);
    }

    public void fillIn_Country(String country) {
        Select s = new Select(countryDropDown);
        s.selectByVisibleText(country);
        wait.until(ExpectedConditions.visibilityOf(statesLoadingAnimation));
        wait.until(ExpectedConditions.invisibilityOf(statesLoadingAnimation));
    }

    public void fillIn_State(String state) {
        wait.until(ExpectedConditions.visibilityOfAllElements(stateDropDown));
        Select s = new Select(stateDropDown);
        s.selectByVisibleText(state);
    }

    public void fillIn_City(String city) { cityInput.sendKeys(city); }

    public void fillIn_Address1(String address_1) { address_1Input.sendKeys(address_1); }

    public void fillIn_Address2(String address_2) {
        address_2Input.sendKeys(address_2);
    }

    public void fillIn_Zip(String zip) {
        zipInput.sendKeys(zip);
    }

    public void fillIn_PhoneNo(String phone) {
        phoneNoInput.sendKeys(phone);
    }

    public void fillIn_FaxNo(String fax) {
        faxNoInput.sendKeys(fax);
    }


    public List<String> returnBillingErrorMessages() {

        List<String> errorMessages = new ArrayList<String>();

        for (WebElement e : billingErrorMessages) {
            errorMessages.add(e.getText());
        }
        return errorMessages;
    }

}
