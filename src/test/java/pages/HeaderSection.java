

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.checkout.ShoppingCartPage;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class HeaderSection extends PageBase {

    @FindBy(partialLinkText = "Log")
    private WebElement logInMenuLink;

    @FindBy(className = "cart-label")
    private WebElement shoppingCartLink;
    @FindBy(xpath = "//input[@value='Go to cart']")
    private WebElement goToCartButton;

    @FindBy(xpath = "//div[@class='product']/div[@class='name']")
    private List<WebElement> cartProductTitles;

    @FindBy(xpath = "//div[@class='quantity']/span")
    private List<WebElement> cartProductQuantities;

    @FindBy(id = "bar-notification")
    private WebElement barNotification;

    @FindBy(className = "close")
    private WebElement notificationCloseButton;

    @FindBy(id = "small-searchterms")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@value='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li/a")
    private List<WebElement> menuItems;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//ul[@class='sublist first-level']//a")
    private List<WebElement> submenuItems;

    public HeaderSection(WebDriver driver) {
        super(driver);
    }

    public LogInPage clickLogin() {

        assumeTrue(logInMenuLink.getText().contains("Log in"));
        logInMenuLink.click();

        return new LogInPage(driver);
    }

    public HomePage logOut() {

        assumeTrue(logInMenuLink.getText().contains("Log out"));
        logInMenuLink.click();

        return new HomePage(driver);
    }

    public String getLoginMessage() {

        return logInMenuLink.getText();
    }

    public boolean isUserLoggedIn() {

        return logInMenuLink.getText().contains("Log out");
    }

    public List<String> getProductTitlesFromCart() {

        viewCartContent();

        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(cartProductTitles));
        } catch (TimeoutException e) {
        }

        List<String> titles = new ArrayList<>();
        for (WebElement productTitle : cartProductTitles) {
            titles.add(productTitle.getText());
        }

        return titles;
    }

    public List<Integer> getProductQuantitiesFromCart() {
        viewCartContent();

        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(cartProductQuantities));
        } catch (TimeoutException e) {
        }

        List<Integer> quantities = new ArrayList<>();
        for (WebElement qty : cartProductQuantities) {
            quantities.add(Integer.valueOf(qty.getText()));
        }

        return quantities;
    }

    public ShoppingCartPage goToCartPage() {
        viewCartContent();
        wait.until(ExpectedConditions.visibilityOf(goToCartButton));
        goToCartButton.click();

        return new ShoppingCartPage(driver);
    }

    public void viewCartContent() {

        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCartLink).perform();
    }

    public void waitForConfirmationBarToHide() {

        wait.until(ExpectedConditions.visibilityOf(barNotification));
        notificationCloseButton.click();
        wait.until(ExpectedConditions.invisibilityOf(barNotification));
    }

    public ResultPage searchFor(String query) {

        searchInput.clear();
        searchInput.sendKeys(query);
        searchButton.click();

        return new ResultPage(driver);
    }

    public ResultPage selectMenuItem(String categoryName) {

        List<String> stringItems = getMenuItems();

        if (stringItems.contains(categoryName)) {
            int itemIndex = stringItems.indexOf(categoryName);
            menuItems.get(itemIndex).click();
        } else
            fail("Main menu item " + categoryName + " not available");

        return new ResultPage(driver);
    }

    public ResultPage selectMenuItem(String categoryName, String subCategoryName) {

        List<String> stringItems = getMenuItems();

        if (stringItems.contains(categoryName)) {
            int itemIndex = stringItems.indexOf(categoryName);
            Actions actions = new Actions(driver);
            actions.moveToElement(menuItems.get(itemIndex)).perform();
        } else
            fail("Main menu item " + categoryName + " not available");

        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText(subCategoryName))));
            WebElement subCategoryMenuItem = driver.findElement(By.partialLinkText(subCategoryName));
            subCategoryMenuItem.click();
        } catch (TimeoutException e) {
            fail("Secondary menu item " + categoryName + " not available");
        }

        return new ResultPage(driver);
    }

    public List<String> getMenuItems() {

        List<String> stringItems = new ArrayList<>();
        for (WebElement item : menuItems) {
            stringItems.add(item.getText());
        }

        return stringItems;
    }
}

/*// intai obiectul (search input) apoi actiunea (cuvinte de input t search term query)

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.List;

public class HeaderSection extends PageBase {
    public HeaderSection(WebDriver driver) {
        super(driver);
    }

//social media
    @FindBy(id = "small-searchterms")
    private WebElement searchInput;
    @FindBy(xpath = "//input[@class='button-1 search-box-button']")
    private WebElement searchButton;

    public void search(String searchTermQuery) {
        searchInput.sendKeys(searchTermQuery);
        searchButton.click();
    }

//shopping cart

    @FindBy(xpath = "//span[@class='cart-label']")
    private WebElement shoppingCartLink;
    @FindBy (xpath = "//h2[@class='product-title']")
    private List<WebElement> itemTitles;

    public void getItemTitlesInCart(){
        Actions actions= new Actions (driver);
        actions.moveToElement(shoppingCartLink).perform();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("bar-notification")));
        wait.until(ExpectedConditions.visibilityOfAllElements(itemTitles));
    }

}*/

/*package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class HeaderSection extends PageBase {

    @FindBy(partialLinkText = "Log")
    private WebElement logInMenuLink;
    @FindBy(className = "cart-label")
    private WebElement shoppingCartLink;
    @FindBy(className = "name")
    private List<WebElement> cartProductTitles;
    @FindBy(id = "bar-notification")
    private WebElement barNotification;
    @FindBy(className = "close")
    private WebElement notificationCloseButton;
    @FindBy(id = "small-searchterms")
    private WebElement searchInput;
    @FindBy(xpath = "//input[@value='Search']")
    private WebElement searchButton;
    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li/a")
    private List<WebElement> menuItems;
    @FindBy(xpath = "//input[@id='itemquantity17135']")
    private WebElement productQuantitiesInCart;


    public HeaderSection(WebDriver driver) {
        super(driver);
    }

    public LogInPage clickLogin() {
        assumeTrue(logInMenuLink.getText().contains("Log in"));
        logInMenuLink.click();

        return new LogInPage(driver);
    }

    public HomePage logOut() {
        assumeTrue(logInMenuLink.getText().contains("Log out"));
        logInMenuLink.click();

        return new HomePage(driver);
    }

    public String getLoginMessage() {
        return logInMenuLink.getText();
    }

    public boolean isUserLoggedIn() {
        return logInMenuLink.getText().contains("Log out");
    }

    public List<String> getProductTitlesFromCart() {
        viewCartContent();

        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(cartProductTitles));
        } catch (TimeoutException e) {
        }

        List<String> titles = new ArrayList<>();
        for (WebElement productTitle : cartProductTitles) {
            titles.add(productTitle.getText());
        }
        return titles;
    }

    private void viewCartContent() {
        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCartLink).perform();
    }

    public void waitForConfirmationBarToHide() {
        wait.until(ExpectedConditions.visibilityOf(barNotification));
        notificationCloseButton.click();
        wait.until(ExpectedConditions.invisibilityOf(barNotification));
    }

    public ResultPage searchFor(String query) {
        searchInput.clear();
        searchInput.sendKeys(query);
        searchButton.click();

        return new ResultPage(driver);
    }

    public ResultPage selectMenuItem(String itemName) {
        List<String> stringItems = getMenuItems();

        if (stringItems.contains(itemName)) {
            int itemIndex = stringItems.indexOf(itemName);
            menuItems.get(itemIndex).click();
        } else
            fail("Menu item " + itemName + " not available");
        return null;
    }
    //    TODO
    public ResultPage selectMenuItem(String itemName, String subCategoryName) {
        List<String> stringItems = getMenuItems();

        if (stringItems.contains(itemName)) {
            int itemIndex = stringItems.indexOf(itemName);
            menuItems.get(itemIndex).click();
        } else
            fail("Menu item " + itemName + " not available");
        return null;
    }

    public List<String> getMenuItems() {
        List<String> stringItems = new ArrayList<>();
        for (WebElement item : menuItems) {
            stringItems.add(item.getText());
        }
        return stringItems;
    }

    public List<Integer> getProductQuantitiesFromCart() {
        return getProductQuantitiesFromCart() ;
    }
}*/
