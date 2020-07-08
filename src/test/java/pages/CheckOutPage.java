package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends PageBase{

    @FindBy(id = "termsofservice")
    private WebElement agreeTerms_CheckOut;

    @FindBy(xpath = "//*[@class='checkout-buttons']")
    private WebElement checkOutButton;

    @FindBy(xpath = "//*[@class='button-1 checkout-as-guest-button']")
    private WebElement checkOutAsGuestButton;

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public void acceptTermsAndConditions_CheckOutPage(){

        if(!agreeTerms_CheckOut.isSelected())
            agreeTerms_CheckOut.click();
    }

    public void setCheckOutButton(){
        checkOutButton.click();
    }

    public void setCheckOutAsGuestButton(){
        checkOutAsGuestButton.click();
    }

}
