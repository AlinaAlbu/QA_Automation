package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.PageBase;

import java.util.List;

public class CreditCard_PaymentInformationPage extends PageBase {

    @FindBy(xpath = "//*[@id='CreditCardType']")
    private WebElement creditCArdTypeInput;

    @FindBy(xpath = "//*[@id='CardholderName']")
    private WebElement cardHolderNameInput;

    @FindBy(xpath = "//*[@id='CardNumber']")
    private WebElement cardNoInput;

    @FindBy(xpath = "//*[@id='ExpireMonth']")
    private WebElement expirationMonthDropDown;

    @FindBy(xpath = "//*[@id='ExpireYear']")
    private WebElement expirationYearDropDown;

    @FindBy(xpath = "//*[@id='CardCode']")
    private WebElement cardCodeInput;

    @FindBy(xpath = "//*[@class='message-error validation-summary-errors']")
    private List<WebElement> cardInputErrors;

    @FindBy(xpath = "//*[@class='button-1 payment-info-next-step-button']")
    private WebElement continueToConfirmOrderButton;

    public CreditCard_PaymentInformationPage(WebDriver driver) {
        super(driver);
    }

    public void cardDetails(String cardHolderName, String cardNo, String expireMonth, String expireYear, String cardCode){
        fillIn_CardHolderName(cardHolderName);
        fillIn_CardNo(cardNo);
        fillIn_ExpireMonth(expireMonth);
        fillIn_ExpireYear(expireYear);
        fillIn_CardCode(cardCode);
    }

    public void fillIn_CardHolderName(String cardHolderName){ cardHolderNameInput.sendKeys(cardHolderName); }

    public void fillIn_CardNo(String cardNo){ cardNoInput.sendKeys(cardNo); }

    public void fillIn_ExpireMonth(String expireMonth){
        wait.until(ExpectedConditions.visibilityOfAllElements(expirationMonthDropDown));
        Select s = new Select(expirationMonthDropDown);
        s.selectByVisibleText(expireMonth);

    }

    public void fillIn_ExpireYear(String expireYear) {
        wait.until(ExpectedConditions.visibilityOfAllElements(expirationYearDropDown));
        Select s = new Select(expirationYearDropDown);
        s.selectByVisibleText(expireYear);
    }

    public void fillIn_CardCode(String cardCode){cardCodeInput.sendKeys(cardCode);}

}
