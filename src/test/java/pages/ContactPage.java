//numele claselor incep cu litere mari, ale variabilelor cu litere mici

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.List;

public class ContactPage extends PageBase{

    public ContactPage(WebDriver driver) {

        super(driver);
        wait.until(ExpectedConditions.urlContains("contactus"));

    }

    @FindBy(xpath = "//input[@id='FullName']")
    private WebElement inputName;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement inputEmail;

    @FindBy(id = "Enquiry")
    private WebElement inputEnquiry;

    @FindBy(xpath = "//input[@class='button-1 contact-us-button']")
    private WebElement submitButton;

    @FindBy(xpath = "//span[contains(@id, '-error')] ")
    private List<WebElement> errorMessages;

    @FindBy(xpath = "//div[@class='result']")
    private WebElement result;

    @FindBy(xpath = "//span[@id='FullName-error']")
    private WebElement nameError;

    @FindBy(xpath = "//span[@id='Email-error']")
    private WebElement emailError;

    @FindBy(xpath = "//span[@id='Enquiry-error']")
    private WebElement enquiryError;

    @FindBy(xpath = "//input[@value='Zmantana DeCasa']")
    private WebElement fullNameInput;

    @FindBy(xpath = "//input[@value='zmantana@gmail.com']")
    private WebElement emailInput;

    public void fillInName(String name) {
        inputName.clear();
        inputName.sendKeys(name);
    }

    public void fillInEmail(String email) {
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }

    public void fillInEnquiry(String enquiry) {
        inputEnquiry.clear();
        inputEnquiry.sendKeys(enquiry);
    }

    public void submitForm(String name, String email, String enquiry) {
        fillInName(name);
        fillInEmail(email);
        fillInEnquiry(enquiry);
        clickSubmitButton();
    }

    private void clickSubmitButton() {
        submitButton.click();
    }

    public String getResult() {

        return result.getText();
    }

    public String fullNameInput() {

        return fullNameInput.getAttribute("value");
    }

    public String emailInput() {
        return emailInput.getAttribute("value");
    }

    public String getNameError() {
        return nameError.getText();
    }

    public String getEmailError() {
        return emailError.getText();
    }

    public String getEnquiryError() {
        return enquiryError.getText();
    }

    public List<String> getErrorMessages() {
        List<String> messages = new ArrayList<String>();
        for (WebElement e : errorMessages) {
            messages.add(e.getText());
        }
        return messages;
    }
}



//    public String fullNameInput() {
//        return inputName.getText();
//    }
//
//    public String emailInput() {
//        return inputEmail.getText();
//    }
