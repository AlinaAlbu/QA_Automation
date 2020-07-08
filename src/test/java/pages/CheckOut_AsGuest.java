package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckOut_AsGuest extends PageBase{

    @FindBy(xpath = "//*[@class='button-1 checkout-as-guest-button']")
    private WebElement checkOutAsGuestButton;

    public CheckOut_AsGuest(WebDriver driver) {
        super(driver);
    }

    public void setCheckOutAsGuestButton(){
        checkOutAsGuestButton.click();
    }

}
