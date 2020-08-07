package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends PageBase {

    @FindBy(className = "product-title")
    private List<WebElement> featuredProductsTitles;

    @FindBy(xpath = "//input[@value='Add to cart']")
    private List<WebElement> addToCartButtons;

    @FindBy(id = "small-searchterms")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@value='Search']")
    private WebElement searchButton;


    @FindBy(className = "name")
    private List<WebElement> cartProductNames;

    @FindBy(xpath = "//input[@value='Add to cart']")
    private List<WebElement> featuredSectionAddToCartButtons;

    private HeaderSection headerSection;
    private FooterSection footerSection;

    public HomePage(WebDriver driver) {
        super(driver);

        headerSection = new HeaderSection(driver);
        footerSection = new FooterSection(driver);
    }

    public List<String> getProductTitlesAddedToTheCart() {
        List<String> productTitles = new ArrayList<>();

        for (WebElement title : featuredProductsTitles) {
            productTitles.add(title.getText());
        }

        return productTitles;
    }

    public ResultPage searchFor(String query) {
        searchInput.clear();
        searchInput.sendKeys(query);
        searchButton.click();

        return new ResultPage(driver);
    }

    public void addToCartProductWithIndex(int index) {
        addToCartButtons.get(index).click();
        headerSection.waitForConfirmationBarToHide();
    }

    public HeaderSection getHeaderSection() {

        return headerSection;
    }

    public FooterSection getFooterSection() {

        return footerSection;
    }



    public List<String> getShoppingCartItems() {
        headerSection.viewCartContent();
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


    /*
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;



public class HomePage extends PageBase {

    private HeaderSection headerSection;
    private FooterSection footerSection;

    public HomePage(WebDriver driver) {
        super(driver);

        HeaderSection headerSection = new HeaderSection(driver);
        FooterSection footerSection = new FooterSection(driver);
    }
//search
    @FindBy(id = "small-searchterms")
    private WebElement searchInput;
    @FindBy(xpath = "//input[@value='Search']")
    private WebElement searchButton;

//add to cart
    @FindBy(xpath ="//input[@value='Add to cart']")
    private List<WebElement> addToCartButtons;
    @FindBy (className = "product-title")
    private List<WebElement> itemTitlesAddedToCart;

//search
    public ResultPage searchFor(String query){
        searchInput.clear();
        searchInput.sendKeys(query);
        searchButton.click();
        return new ResultPage(driver);
    }

//add to cart
    public void addToCartProductWithIndex(int index){
        addToCartButtons.get(index).click();
    }

    public List<String> getProductTitlesAddedToTheCart(){
        List<String> titles = new ArrayList<>();
        for (WebElement b:itemTitlesAddedToCart){
            titles.add(b.getText());
        }
        return titles;
    }

    public HeaderSection getHeaderSection() {
        return headerSection;
    }
    public FooterSection getFooterSection() {
        return footerSection;
    }*/
}