
package pages.checkout;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PageBase;

import java.util.List;

public class CheckOutPage extends PageBase {

    @FindBy(xpath = "//input[@class='button-1 checkout-as-guest-button']")
    private WebElement checkOutAsGuestButton;

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckOutAsGuestButton(){
        wait.until(ExpectedConditions.visibilityOf(checkOutAsGuestButton));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkOutAsGuestButton);

    }

}
