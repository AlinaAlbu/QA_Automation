package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class ShippingMethodPage extends PageBase {

    @FindBy(xpath = "//*[@id='shippingoption_0']")
    private WebElement shippingByLandOption;

    @FindBy(xpath = "//*[@id='shippingoption_1']")
    private WebElement oneDayAirShippingOption;

    @FindBy(xpath = "//*[@id='shippingoption_2']")
    private WebElement twoDayAirShippingOption;

    @FindBy(xpath = "//*[@class='button-1 shipping-method-next-step-button']")
    private WebElement continueToPaymentMethodeButton;

    public ShippingMethodPage(WebDriver driver) {
        super(driver);
    }

    public void selectShippingByLandOption() { shippingByLandOption.click(); }

    public void selectOneDayAirShippingOption() { oneDayAirShippingOption.click(); }

    public void selectTwoDayAirShippingOption() {
        twoDayAirShippingOption.click();
    }

    public void clickContinueToPaymentMethodeButton() {
        continueToPaymentMethodeButton.click();
    }

}
