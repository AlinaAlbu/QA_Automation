package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentMethodPage extends PageBase {

    @FindBy(xpath = "//*[@value='Payments.CheckMoneyOrder']")
    private WebElement checkPayment;

    @FindBy(xpath = "//*[@value='Payments.Manual']")
    private WebElement creditCardPayment;

    @FindBy(xpath = "//*[@class='button-1 payment-method-next-step-button']")
    private WebElement continueToPaymentInformation_Button;

    public PaymentMethodPage(WebDriver driver) {
        super(driver);
    }

    public void setCheckPayment() {
        checkPayment.click();
    }

    public void setCreditCardPayment() {
        creditCardPayment.click();
    }

    public void setContinueToPaymentInformation_Button() {
        continueToPaymentInformation_Button.click();
    }
}
