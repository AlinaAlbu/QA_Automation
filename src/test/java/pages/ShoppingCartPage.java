package pages;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        return shoppingCartQuantity.getText();
    }

    public void removeItem_FromShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable(removeItemFromCartButton));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", removeItemFromCartButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", updateShoppingCartButton);

        removeItemFromCartButton.click();
        updateShoppingCartButton.click();

    }

    public String removeItemFromShoppingCart_Message() {
        try {
            wait.until(ExpectedConditions.visibilityOf(emptyCartMessage));
        } catch (TimeoutException e) {
            updateShoppingCartButton.click();

        }

        return emptyCartMessage.getText();
    }

}
