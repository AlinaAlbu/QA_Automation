package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.*;
import pages.checkout.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CheckOut_AsGuestTest extends TestBase{

    private HomePage homePage;
    private ShoppingCartPage shoppingCartPage;
    private CheckOutPage checkOutPage;

    @BeforeEach
    void setUp() {
        driver.get("https://demo.nopcommerce.com/");

        homePage = new HomePage(driver);
        homePage.addToCartProductWithIndex(2);

        shoppingCartPage = homePage.getHeaderSection().goToCartPage();

        checkOutPage = shoppingCartPage.acceptTermAndCheckOut();

    }

    @Test

    public void canCheckOut_AFeaturedProduct_AsGuest(){

        checkOutPage.clickCheckOutAsGuestButton();
        BillingAddressPage billingAddress = new BillingAddressPage(driver);
        billingAddress.shipToTheSameAddress(false);

        billingAddress.fillInBillingAddress("a", "b","a@gmail.com", "bla bla SRL",
               "United States","Alabama", "a", "2", "1", "123456", "123", "123");


        ShippingAddressPage shippingAddress = new ShippingAddressPage(driver);
        shippingAddress.selectNewAddress("New Address");

        shippingAddress.fillInNewShippingAddress("q", "q","q@gmail.com", "q",
               "United States", "Alabama", "q", "w", "w", "123456", "2", "2");

        ShippingMethodPage shippingMethod = new ShippingMethodPage(driver);
        shippingMethod.selectTwoDayAirShippingOption();

        PaymentMethodPage paymentMethod = new PaymentMethodPage(driver);
        paymentMethod.selectCreditCardPayment();

        CreditCard_PaymentInformationPage creditCardInfo = new CreditCard_PaymentInformationPage(driver);
        creditCardInfo.cardDetails("123", "14111 1111 1111 1111",
                "1", "2021", "948");

        ConfirmOrderPage confirmOrder = new ConfirmOrderPage(driver);
        confirmOrder.clickConfirmOrder();

        assertThat(confirmOrder.getConfirmOrderSuccesMessage(),
                is ("Your order has been successfully processed!"));

    }

/*
    @Test

    public void cannotCheckOut_AFeaturedProduct_WithOutFillingTheBillingAddress_AsGuest(){

//        billingAddressPage.billingAddress_CheckOutAsGuest("", "","", "",
//                "","", "", "", "", "", "", "");


    }

    @Test

    public void CannotCheckOut_AFeaturedProduct_WithWrongCreditCardNumber_AsGuest(){



    }
*/

}
