package pages.checkout;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.PageBase;

import java.util.List;

public class ShoppingCartPage extends PageBase {

    @FindBy(xpath = "//*[@class='qty-input']")
    private WebElement shoppingCartQuantity;
    @FindBy(xpath = "//div[@class='product']/div[@class='name']")
    private List<WebElement> cartProductTitles;
    @FindBy(xpath = "//*[@name='updatecart']")
    private WebElement updateShoppingCartButton;
    @FindBy(xpath = "//*[@name='removefromcart']")
    private WebElement removeItemFromCartButton;
    @FindBy(xpath = "//*[@class='no-data']")
    private WebElement emptyCartMessage;

    @FindBy(id = "termsofservice")
    private WebElement agreeTerms_CheckOut;
    @FindBy(id = "checkout")
    private WebElement checkOutButton;
    @FindBy(id="checkout_attribute_input_1")
    private WebElement giftRappingOptionDropDown;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void addQuantityValueToItem_FromShoppingCart(String qty) {

        shoppingCartQuantity.clear();
        shoppingCartQuantity.sendKeys(qty);
        updateShoppingCartButton.click();

        try {
            wait.until(ExpectedConditions.textToBePresentInElement(shoppingCartQuantity, qty));
        } catch (TimeoutException e) {
            shoppingCartQuantity.sendKeys(qty);
            updateShoppingCartButton.click();
        }

    }

    public String itemQuantityUpdateFromShoppingCart_Message() {

        wait.until(ExpectedConditions.visibilityOf(shoppingCartQuantity));
        return shoppingCartQuantity.getAttribute("value");
    }

    public void removeItem_FromShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable(removeItemFromCartButton));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", removeItemFromCartButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", updateShoppingCartButton);
    }

    public String removeItemFromShoppingCart_Message() {
        try {
            wait.until(ExpectedConditions.visibilityOf(emptyCartMessage));
        } catch (TimeoutException e) {
            updateShoppingCartButton.click();

        }

        return emptyCartMessage.getText();
    }

    public void acceptTermsAndConditions(){
        wait.until(ExpectedConditions.visibilityOf(agreeTerms_CheckOut));
        if(!agreeTerms_CheckOut.isSelected())
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", agreeTerms_CheckOut);

    }

    public CheckOutPage clickCheckOutButton(){

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkOutButton);

        return new CheckOutPage(driver);
    }

    public void selectGiftRappingOption(String giftRappingOption){
        Select s = new Select(giftRappingOptionDropDown);
        s.selectByVisibleText(giftRappingOption);

    }

    public CheckOutPage acceptTermAndCheckOut(){
        acceptTermsAndConditions();
        return clickCheckOutButton();
    }

}
