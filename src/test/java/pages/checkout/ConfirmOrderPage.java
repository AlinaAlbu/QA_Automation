package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PageBase;


public class ConfirmOrderPage extends PageBase {

    @FindBy(xpath = "//input[@class='button-1 confirm-order-next-step-button']")
    private WebElement confirmShippingButton;

    @FindBy(xpath = "//strong[contains(text(),'Your order has been successfully processed!')]")
    private WebElement confirmOrderSuccesMessage;

    public ConfirmOrderPage(WebDriver driver) {
        super(driver);
    }

    public void clickConfirmOrder() {
        confirmShippingButton.click();
    }

    public String getConfirmOrderSuccesMessage(){
        wait.until(ExpectedConditions.visibilityOf(confirmOrderSuccesMessage));
        return confirmOrderSuccesMessage.getText();

    }

}
