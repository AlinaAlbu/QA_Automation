package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Check_PaymentInformationPage extends PageBase {

    @FindBy(xpath = "//*[@class='button-1 payment-info-next-step-button']")
    private WebElement continueToConfirmOrder_Button;

    public Check_PaymentInformationPage(WebDriver driver) {
        super(driver);
    }

    public void setContinueToConfirmOrder_Button() {
        continueToConfirmOrder_Button.click();
    }
}
