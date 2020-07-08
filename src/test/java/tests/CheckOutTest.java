package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import pages.CheckOutPage;
import pages.FeaturedProductPage;
import pages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;

public class CheckOutTest extends TestBase{

    private HomePage homePage;
    private FeaturedProductPage featuredProductPage;
    private CheckOutPage checkOutPage;

    @BeforeEach
    void setUp() {

        driver.get("https://demo.nopcommerce.com/");

        homePage = new HomePage(driver);
        featuredProductPage = new FeaturedProductPage(driver);

        homePage.addToCartProductWithIndex(2);

        new Actions(driver).moveToElement(featuredProductPage.cartButton).perform();

        featuredProductPage.cartButton.click();
    }

/*    @Test
    public void canCheckOut(){

    assertThat();


    }*/

}
