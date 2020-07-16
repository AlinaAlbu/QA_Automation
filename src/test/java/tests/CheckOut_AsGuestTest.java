package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import pages.*;

import static org.hamcrest.MatcherAssert.assertThat;

public class CheckOut_AsGuestTest extends TestBase{

    private HomePage homePage;
    private FeaturedProductPage featuredProductPage;
    private ShoppingCartPage shoppingCartPage;
    private CheckOutPage checkOutPage;
    private CheckOut_AsGuest checkOutAsGuest;
    private BillingAddressPage billingAddressPage;
    private ShippingAddressPage shippingAddressPage;
    private ShippingMethodPage shippingMethodPage;
    private Check_PaymentInformationPage checkPaymentInformationPage;

    @BeforeEach
    void setUp() {

        driver.get("https://demo.nopcommerce.com/");

        homePage = new HomePage(driver);
        featuredProductPage = new FeaturedProductPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        checkOutPage = new CheckOutPage(driver);
        checkOutAsGuest = new CheckOut_AsGuest(driver);

        billingAddressPage = new BillingAddressPage(driver);
        shippingAddressPage = new ShippingAddressPage(driver);
        shippingMethodPage = new ShippingMethodPage(driver);
        checkPaymentInformationPage = new Check_PaymentInformationPage(driver);

        homePage.addToCartProductWithIndex(2);

        new Actions(driver).moveToElement(featuredProductPage.cartButton).perform();

        featuredProductPage.cartButton.click();

    }
    @Test

    public void canCheckOut_AFeaturedProduct_AsGuest(){

        billingAddressPage.billingAddress_CheckOutAsGuest("a", "b","a@gmail.com", "bla bla SRL",
               "1","1", "a", "2", "123456", "123456", "123", "123");
        shippingAddressPage.newShippingAddress("q", "q","q@gmail.com", "q",
               "1", "1", "q", "w", "w", "123456", "2", "2");


    }

    @Test

    public void cannotCheckOut_AFeaturedProduct_WithOutFillingTheBillingAddress_AsGuest(){

        billingAddressPage.billingAddress_CheckOutAsGuest("", "","", "",
                "","", "", "", "", "", "", "");
    }

    @Test

    public void CannotCheckOut_AFeaturedProduct_WithWrongCreditCardNumber_AsGuest(){



    }

}
