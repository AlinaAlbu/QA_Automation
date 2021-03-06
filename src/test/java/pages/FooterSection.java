/*
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;

public class FooterSection {

    @FindBy(partialLinkText = "Contact us")
    private WebElement contactUsLink;

    @FindBy(xpath = "//ul[@class='networks']//a")
    private List<WebElement> socialMediaLinks;

    protected WebDriver driver;

    public FooterSection(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ContactPage goToContactPage() {
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(contactUsLink));
        contactUsLink.click();

        return new ContactPage(driver);
    }

    public void clickOnLinkWithIndex(int index) {
        try {
            socialMediaLinks.get(index).click();
        } catch (IndexOutOfBoundsException e) {
            fail("Social media link with index " + index + " was not available");
        }
    }
}*/


/*package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.fail;


public class FooterSection extends PageBase {

    @FindBy(partialLinkText = "Contact us")
    private WebElement contactUsLink;
    @FindBy(xpath = "//ul[@class='networks']//a")
    private List<WebElement> socialMediaLinks;

    public FooterSection(WebDriver driver) {
        super(driver);
    }

    public ContactPage goToContactPage() {
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(contactUsLink));
        contactUsLink.click();

        return new ContactPage(driver);
    }

    public void clickOnLinkWithIndex(int index) {
        try {
            socialMediaLinks.get(index).click();
        } catch (IndexOutOfBoundsException e) {
            fail("Social media link with index " + index + " was not available");
        }
// TODO
        Set<String> windowHandles = driver.getWindowHandles();

        driver.switchTo().window(windowHandles.iterator().next());
    }
}*/

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;


public class FooterSection extends PageBase {

    @FindBy(partialLinkText = "Contact us")
    private WebElement contactUsLink;

    @FindBy(xpath = "//ul[@class='networks']//a")
    private List<WebElement> socialMediaLinks;

    public FooterSection(WebDriver driver) {

        super(driver);
    }

    public ContactPage goToContactPage() {

        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(contactUsLink));
        contactUsLink.click();

        return new ContactPage(driver);
    }

    public void clickOnLinkWithIndex(int index) {

        try {
            socialMediaLinks.get(index).click();
        } catch (IndexOutOfBoundsException e) {
            fail("Social media link with index " + index + " was not available");
        }

        List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
    }

    public void switchBackToMainPageFromSocialMediaPage() {

        List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(0));
    }

}
