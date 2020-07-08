package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ConfirmOrderPage extends PageBase {

    @FindBy(xpath = "//input[@class='button-1 confirm-order-next-step-button']")
    private WebElement confirmShippingButton;

    public ConfirmOrderPage(WebDriver driver) {
        super(driver);
    }

    public void setConfirmShippingButton() {
        confirmShippingButton.click();
    }

}
