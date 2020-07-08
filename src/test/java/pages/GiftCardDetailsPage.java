package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GiftCardDetailsPage extends PageBase {

    @FindBy(id = "giftcard_43_RecipientName")
    private WebElement recipientName;

    @FindBy(id = "giftcard_43_RecipientEmail")
    private WebElement recipientEmail;

    @FindBy(xpath = "//input[@class='sender-name']")
    private WebElement senderName;

    @FindBy(xpath = "//input[@class='sender-email']")
    private WebElement senderEmail;

    @FindBy(xpath = "//textarea[@class='message']")
    private WebElement message;

    @FindBy(xpath = "//input[@class='qty-input']")
    private WebElement quantityBox;

    @FindBy(id = "add-to-cart-button-43")
    private WebElement addToCartButton;

    public GiftCardDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void addGiftCardWithAdditionalDetailsToCart(){
        wait.until(ExpectedConditions.visibilityOf(recipientName));
        recipientName.sendKeys("blabla");
        recipientEmail.sendKeys("blabla@gmail.com");
        senderName.sendKeys("bla2");
        senderEmail.sendKeys("bla2@gmail.com");
        message.sendKeys("more bla");
        quantityBox.clear();
        quantityBox.sendKeys("2");
        addToCartButton.click();
    }

}
