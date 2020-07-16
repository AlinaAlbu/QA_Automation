package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ConfirmOrderPage extends PageBase {

    @FindBy(xpath = "//input[@class='button-1 confirm-order-next-step-button']")
    private WebElement confirmShippingButton;

    @FindBy(xpath = "//strong[contains(text(),'Your order has been successfully processed!')]")
    private WebElement confirmOrderSuccesMessage;

    public ConfirmOrderPage(WebDriver driver) {
        super(driver);
    }

    public void setConfirmShippingButton() {
        confirmShippingButton.click();
    }

    public void setConfirmOrderSuccesMessage(){
        confirmOrderSuccesMessage.getText();
    }

}
