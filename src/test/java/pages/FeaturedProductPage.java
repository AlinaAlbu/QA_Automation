package pages;

import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.interactions.Actions;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.ui.ExpectedConditions;

        import java.util.ArrayList;
        import java.util.List;

public class FeaturedProductPage extends PageBase {

    @FindBy(className = "ico-cart")
    public WebElement cartButton;

    @FindBy(className = "name")
    private List<WebElement> cartProductNames;

    @FindBy(xpath = "//input[@value='Add to cart']")
    private List<WebElement> featuredSectionAddToCartButtons;


    public FeaturedProductPage(WebDriver driver) {

        super(driver);
    }

    public void goToShoppingCart() {
        wait.until(ExpectedConditions.visibilityOf(cartButton));
        new Actions(driver).moveToElement(cartButton).perform();
    }

    public List<String> getShoppingCartItems() {
        goToShoppingCart();

        List<String> titles = new ArrayList<>();

        wait.until(ExpectedConditions.visibilityOfAllElements(cartProductNames));

        for(int i = 0; i < cartProductNames.size(); i++) {
            titles.add(cartProductNames.get(i).getText());
        }

        return titles;
    }

    public ResultPage addFeaturedProductToCartWithIndex(int index) {
        wait.until(ExpectedConditions.visibilityOfAllElements(featuredSectionAddToCartButtons));
        featuredSectionAddToCartButtons.get(index).click();

        return new ResultPage(driver);
    }

}