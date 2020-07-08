package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GiftCardPage extends PageBase {

    @FindBy(xpath = "//h2[@class='product-title']")
    private List<WebElement> giftCardNames;

    @FindBy(xpath = "//input[@value='Add to cart']")
    private List<WebElement> addToCartGiftCardButtons;



    public GiftCardPage(WebDriver driver) {
        super(driver);
    }

    public GiftCardDetailsPage addGiftCardToCart(int index){

        addToCartGiftCardButtons.get(index).click();

        return new GiftCardDetailsPage(driver);
    }



}


