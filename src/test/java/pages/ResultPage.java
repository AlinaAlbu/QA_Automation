package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;


public class ResultPage extends PageBase {

    private HeaderSection headerSection;

    public ResultPage(WebDriver driver) {
        super(driver);
        headerSection = new HeaderSection(driver);
    }

    @FindBy(className = "product-title")
    private List<WebElement> productTitleLists;

    @FindBy(xpath = "//div[@class='search-results']/div[@class='warning' or @class='no-result']")
    private WebElement messages;

    @FindBy(xpath = "//div[@class='no-result']")
    private WebElement searchError;

    @FindBy(xpath = "//div[@class='warning']")
    private WebElement searchWarning;

    @FindBy(xpath = "//div[@class='search-results']")
    private WebElement searchResult;

    @FindBy(xpath = "//div[@class='giftcard']")
    private WebElement giftCardArea;

    @FindBy(id = "adv")
    private WebElement advancedSearchButton;

    @FindBy(id = "cid")
    private WebElement advancedSearchCategoryField;

    @FindBy(id = "isc")
    private WebElement automaticallySearchInSubcategoriesButton;

    @FindBy(id = "mid")
    private WebElement manufacturerField;

    @FindBy(xpath = "//*[@class='price-from']")
    private WebElement priceRangeFrom;

    @FindBy(xpath = "//*[@class='price-to']")
    private WebElement priceRangeTo;

    @FindBy(id = "sid")
    private WebElement searchInProductDescription;

    @FindBy(xpath = "//*[@class='button-1 search-button']")
    private WebElement submitAdvancedSearchButton;

    @FindBy(className = "product-title")
    private List<WebElement> productTitlesList;

    @FindBy(xpath = "//input[@value='Add to cart']")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "//div[@class='search-results']/div[@class != 'product-grid']")
    private WebElement warningMessage;

    @FindBy (xpath = "//*[@class='product-title']")
    private List<WebElement> advancedSearchResult;

    @FindBy(xpath = "//input[@class='recipient-name']")
    private WebElement recipientName;

    @FindBy(xpath = "//input[@class='recipient-email']")
    private WebElement recipientEmail;

    @FindBy(xpath = "//input[@class='sender-name']")
    private WebElement senderName;

    @FindBy(xpath = "//input[@class='sender-email']")
    private WebElement senderEmail;

    @FindBy(xpath = "//textarea[@class='message']")
    private WebElement message;

    @FindBy(xpath = "//input[@class='qty-input']")
    private WebElement quantityBox;

    @FindBy(id = "add-to-cart-button-43")
    private WebElement addToCartButton;

    public List<String> getProductTitles() {

        List<String> titles = new ArrayList<String>();

        for (WebElement e : productTitleLists) {
            titles.add(e.getText());
        }
        return titles;
    }

    public void setAdvancedSearch() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("adv")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",advancedSearchButton );

        advancedSearchButton.click();
    }

    public String getMessages() {

        return messages.getText();
    }

    public String searchError() {

        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(searchError));

        return searchError.getText();
    }

    public String getSearchWarning() {

        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(searchWarning));

        return searchWarning.getText();
    }

    public String searchResult() {

        return searchResult.getText();
    }

    public void selectCategory(String category) {

        wait.until(ExpectedConditions.visibilityOf(advancedSearchCategoryField));

        new Select(advancedSearchCategoryField).selectByVisibleText(category);
    }

    public void setAutomaticallySearchInSubcategoriesButton() {

        automaticallySearchInSubcategoriesButton.click();
    }

    public void SetPriceRange(String priceFrom, String priceTo) {

        priceRangeFrom.clear();
        priceRangeTo.clear();

        fillInPriceFrom(priceFrom);
        fillInPriceTo(priceTo);
    }

    public void fillInPriceFrom(String priceFrom) {

        priceRangeFrom.sendKeys(priceFrom);
    }

    public void fillInPriceTo(String priceTo) {

        priceRangeTo.sendKeys(priceTo);
    }

    public void SetSearchInProductDescription(){

        searchInProductDescription.click();
    }

    public void SetSubmitAdvancedSearchButton(){


        submitAdvancedSearchButton.click();
    }

    public void selectManufacturer(String manufacturer) {

        new Select(manufacturerField).selectByVisibleText(manufacturer);
    }

    public Integer advancedSearchProductTitles(){

        return advancedSearchResult.size();
    }

    // PT POPUP
    public String getAlertNotification() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void addToCartProductWithIndex(int index) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(addToCartButtons));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButtons.get(index));

            //          new Actions(driver).moveToElement(addToCartButtons.get(index)).click().perform();
            //           addToCartButtons.get(index).click();

        } catch (IndexOutOfBoundsException e) {
            fail("Add to cart button with index " + index + " not available");

        }

        headerSection.waitForConfirmationBarToHide();
    }

    public void addToCartProductWithIndexWithoutConfirmationBar(int index) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(addToCartButtons));

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButtons.get(index));

            //          new Actions(driver).moveToElement(addToCartButtons.get(index)).click().perform();
            //           addToCartButtons.get(index).click();

        } catch (IndexOutOfBoundsException e) {
            fail("Add to cart button with index " + index + " not available");

        }

//        headerSection.waitForConfirmationBarToHide();

    }

    public void addGiftCardWithAdditionalDetailsToCart(){

        wait.until(ExpectedConditions.visibilityOf(giftCardArea));

        recipientName.sendKeys("blabla");
        recipientEmail.sendKeys("blabla@gmail.com");
        senderName.sendKeys("bla2");
        senderEmail.sendKeys("bla2@gmail.com");
        message.sendKeys("more bla");
        quantityBox.clear();
        quantityBox.sendKeys("2");
        addToCartButton.click();

        headerSection.waitForConfirmationBarToHide();
    }

    public HeaderSection getHeaderSection() {

        return headerSection;
    }
}