package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.checkout.ShoppingCartPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ShoppingCartTest extends TestBase {

    private HomePage homePage;
    private ShoppingCartPage shoppingCartPage;

    @BeforeEach
    void setUp() {
        driver.get("https://demo.nopcommerce.com/");

        homePage = new HomePage(driver);
        homePage.addToCartProductWithIndex(2);

        shoppingCartPage = homePage.getHeaderSection().goToCartPage();
        shoppingCartPage.clickCheckOutButton();
    }

    @Test
    public void canUpdateItemQuantityFromShoppingCart() {
        shoppingCartPage.addQuantityValueToItem_FromShoppingCart("4");

        assertThat(shoppingCartPage.itemQuantityUpdateFromShoppingCart_Message(), is("4"));
    }

    @Test
    public void canRemoveItemQuantityFromShoppingCart() {
        shoppingCartPage.removeItem_FromShoppingCart();

        assertThat(shoppingCartPage.removeItemFromShoppingCart_Message(), is("Your Shopping Cart is empty!"));
    }
}
