package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import pages.FeaturedProductPage;
import pages.HomePage;
import pages.ShoppingCartPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ShoppingCartTest extends TestBase {


    private HomePage homePage;
    private FeaturedProductPage featuredProductPage;
    private ShoppingCartPage shoppingCartPage;

    @BeforeEach
    void setUp() {

        driver.get("https://demo.nopcommerce.com/");

        homePage = new HomePage(driver);
        featuredProductPage = new FeaturedProductPage(driver);

        homePage.addToCartProductWithIndex(2);

        new Actions(driver).moveToElement(featuredProductPage.cartButton).perform();

        featuredProductPage.cartButton.click();
    }

    @Test
    public void canUpdateItemQuantityFromShoppingCart() {

        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.addQuantityValueToItem_FromShoppingCart("4");

        assertThat(shoppingCartPage.itemQuantityUpdateFromShoppingCart_Message(), is("4"));
    }

    @Test
    public void canRemoveItemQuantityFromShoppingCart() {

        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.removeItem_FromShoppingCart();

        assertThat(shoppingCartPage.removeItemFromShoppingCart_Message(), is("Your Shopping Cart is empty!"));
    }
}
