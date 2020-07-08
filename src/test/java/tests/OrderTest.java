package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.GiftCardDetailsPage;
import pages.HomePage;
import pages.ResultPage;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OrderTest extends TestBase {

    private HomePage homePage;

    @BeforeEach
    void setUp() {
        driver.get("https://demo.nopcommerce.com/");
        homePage = new HomePage(driver);

    }

    @Test
    public void canAddAFeaturedProductToCart() {

        homePage.addToCartProductWithIndex(2);

        String productName = homePage.getProductTitlesAddedToTheCart().get(2);
        List<String> productsInCart = homePage.getHeaderSection().getProductTitlesFromCart();

        assertThat(productsInCart, contains(productName));

    }

    @Test
    public void canAddTheSameFeaturedProductToCartMultipleTimes() {

        homePage.addToCartProductWithIndex(2);
        homePage.addToCartProductWithIndex(2);

        String productName = homePage.getProductTitlesAddedToTheCart().get(2);
        List<String> productTitlesInCart = homePage.getHeaderSection().getProductTitlesFromCart();
        List<Integer> productQuantitiesInCart = homePage.getHeaderSection().getProductQuantitiesFromCart();

        assertThat(productTitlesInCart, contains(productName));
        assertThat(productQuantitiesInCart, contains(2));

    }

    @Test
    public void canAddMultipleProductsToCart_fromTheResultsPage() {

        ResultPage resultPage = homePage.getHeaderSection().searchFor("book");

        resultPage.addToCartProductWithIndex(1);
        resultPage.addToCartProductWithIndex(2);

        List<String> productTitles = resultPage.getProductTitles();
        List<String> productsInCart = resultPage.getHeaderSection().getProductTitlesFromCart();

        assertThat(productsInCart, containsInAnyOrder(productTitles.get(1), productTitles.get(2)));

    }

    @Test
    public void canAddMultipleProductsToCart_fromTheMainMenu() {

        List<String> addedProductTitles = new ArrayList<>();

        ResultPage resultsPage = homePage.getHeaderSection().selectMenuItem("Books");
        resultsPage.addToCartProductWithIndex(0);
        addedProductTitles.add(resultsPage.getProductTitles().get(0));

        ResultPage updatedResultsPage = resultsPage.getHeaderSection().selectMenuItem("Apparel", "Accessories");
        updatedResultsPage.addToCartProductWithIndex(1);
        addedProductTitles.add(updatedResultsPage.getProductTitles().get(1));

        List<String> productTitlesFromCart = updatedResultsPage.getHeaderSection().getProductTitlesFromCart();

        assertThat(productTitlesFromCart, containsInAnyOrder(addedProductTitles.get(0), addedProductTitles.get(1)));

    }

    @Test
    public void canAddProductToTheCartWithAdditionalDetails() {

        List<String> addedProductTitles = new ArrayList<>();

        ResultPage resultsPage = homePage.getHeaderSection().selectMenuItem("Gift Cards");
        resultsPage.addToCartProductWithIndexWithoutConfirmationBar(0);

        resultsPage.addGiftCardWithAdditionalDetailsToCart();

        List<String> productTitlesFromCart = resultsPage.getHeaderSection().getProductTitlesFromCart();

        assertThat(productTitlesFromCart.size(), greaterThanOrEqualTo(1));

    }

}