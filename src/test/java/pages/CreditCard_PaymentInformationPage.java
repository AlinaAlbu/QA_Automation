package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreditCard_PaymentInformationPage extends PageBase {

    @FindBy(xpath = "//*[@id='CreditCardType']")
    private WebElement creditCArdTypeInput;

    @FindBy(xpath = "//*[@id='CardholderName']")
    private WebElement cardHolderNameInput;

    @FindBy(xpath = "//*[@id='CardNumber']")
    private WebElement cardNoInput;

    @FindBy(xpath = "//*[@id='ExpireMonth']")
    private WebElement expirationMonthInput;

    @FindBy(xpath = "//*[@id='ExpireYear']")
    private WebElement expirationYearInput;

    @FindBy(xpath = "//*[@id='CardCode']")
    private WebElement cardCodeInput;

    @FindBy(xpath = "//*[@class='message-error validation-summary-errors']")
    private List<WebElement> cardInputErrors;

    @FindBy(xpath = "//*[@class='button-1 payment-info-next-step-button']")
    private WebElement continueToConfirmOrderButton;


    public CreditCard_PaymentInformationPage(WebDriver driver) {
        super(driver);
    }



}
