package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase{

    @FindBy(id = "termsofservice")
    private WebElement agreeTerms_CheckOut;

    @FindBy(xpath = "//*[@class='checkout-buttons']")
    private WebElement checkOutButton;

    @FindBy(id="checkout_attribute_input_1")
    private WebElement giftRappingOptionDropDown;

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

    public void setGiftRappingOption(String giftRappingOption){
        Select s = new Select(giftRappingOptionDropDown);
        s.selectByVisibleText(giftRappingOption);

    }

}
