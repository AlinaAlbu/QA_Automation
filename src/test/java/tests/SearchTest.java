//    driver.getCurrentUrl();
//    assertThat (titles.size() = 0);

package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.ResultPage;
import java.util.List;
import java.util.stream.Stream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SearchTest extends TestBase {

    //definit obiectul homePage
    private HomePage homePage;

    @BeforeEach
    public void setUp() {

        driver.get("https://demo.nopcommerce.com");

// instantiat (pasat driverul sa il populez)

        homePage = new HomePage(driver);
    }

//simple search

    @ParameterizedTest
    @ValueSource(strings = {"book", "computer", "HTC"})

    public void canSearchForAnExistingItem(String query) {

        ResultPage resultPage = homePage.searchFor(query);
        List<String> titles = resultPage.getProductTitles();

        for (String t : titles) {
            assertThat(t, containsStringIgnoringCase(query));
        }
        assertThat(titles.size(), greaterThan(0));

    }

    @ParameterizedTest
    @MethodSource("stringsProvider")

    public void cannotSearchForInvalidItem(String query, String expectedWarningMessage) {
        ResultPage resultPage = homePage.searchFor(query);
        assertThat(resultPage.getMessages(), is(expectedWarningMessage));

    }

    public static Stream<Arguments> stringsProvider() {
        return Stream.of(
                arguments("t", "Search term minimum length is 3 characters"),
                arguments("452", "No products were found that matched your criteria."),
                arguments("santa hat", "No products were found that matched your criteria.")
        );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/NopCommerceSearchItems.csv", numLinesToSkip = 1)

    public void canSearchForAnExistingItemsFromCSVFile(String query) {
        ResultPage resultPage = homePage.searchFor(query);
        List<String> productTitles = resultPage.getProductTitles();

        assertThat(productTitles.size(), greaterThan(0));
        for (String title : productTitles) {
            assertThat(title, containsStringIgnoringCase(query));
        }
    }


// advance search merge doar daca pun un break point pe linia unde fac click pe advanced search, si step over

    @Test
    public void canSearchWithAdvancedField() {
        HomePage homePage = new HomePage(driver);

        ResultPage resultPage = homePage.searchFor("book");

        resultPage.setAdvancedSearch();

        resultPage.selectCategory("All");
        resultPage.setAutomaticallySearchInSubcategoriesButton();
        resultPage.selectManufacturer("All" +
                "");
        resultPage.SetPriceRange("1", "9999");
        resultPage.SetSearchInProductDescription();
        resultPage.SetSubmitAdvancedSearchButton();

        assertThat(resultPage.advancedSearchProductTitles(), greaterThanOrEqualTo(1));
    }

    /*    @Test
    public void canSearchForAnExistingItem() {
        HomePage homePage = new HomePage(driver);
        ResultPage resultPage = homePage.searchFor("book");
        List<String> titles = resultPage.getProductTitles();
        for (String t : titles) {
            assertThat(t, containsStringIgnoringCase("book"));
        }
    }

    @Test
    public void cannotSearchForAnInexistingItem() {
        HomePage homePage = new HomePage(driver);
        ResultPage resultPage = homePage.searchFor("erdftgyuhjikofbrs");
        assertThat(resultPage.searchError(), is("No products were found that matched your criteria."));
    }

    @Test
    public void cannotSearchWithLessThan3Caracters() {
        HomePage homePage = new HomePage(driver);
        ResultPage resultPage = homePage.searchFor("1");
        assertThat(resultPage.searchResult(), is("Search term minimum length is 3 characters"));
    }

    @Test
    public void cannotSearchForEmptyString() {
        HomePage homePage = new HomePage(driver);
        ResultPage resultPage = homePage.searchFor("");
        assertThat(resultPage.getAlertNotification(), is("Please enter some search keyword"));
    }*/
}


