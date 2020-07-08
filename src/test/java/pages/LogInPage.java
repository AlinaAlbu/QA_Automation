package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class LogInPage extends PageBase {

    public LogInPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(partialLinkText = "Log")
    private WebElement logInMenuLink;

    @FindBy(tagName = "h1") //@FindBy(xpath="//h1")
    private WebElement title;

    @FindBy(id = "Email")
    private WebElement emailInput;

    @FindBy(id = "Password")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    private WebElement errorMessage;

    @FindBy(xpath = "//span[@class='field-validation-error']")
    private WebElement emailError;

    @FindBy(xpath = "//input[@value='Log in']")
    private WebElement logInButton;

/*    protected WebDriver driver;  //intri in taxi : Webdriver=masina, driver=sofer
        public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }*/ //il gasim in PageBase, ca este parinte, iar restul paginilor mostenesc - sa elimin duplicatele

    public void loginAs(String email, String pass) {

        fillInEmail(email);
        fillInPassword(pass);
        clickLogin();
    }

    public void fillInEmail(String email) {

        emailInput.sendKeys(email);
    }

    public void fillInPassword(String password) {

        passwordInput.sendKeys(password);
    }

    public void clickLogin() {

        logInButton.click();
    }

    public String getErrorMessage() {

        return errorMessage.getText();
    }

    public String getErrorEmail() {

        return emailError.getText();
    }

    public String getLoginMessage() {

        return logInMenuLink.getText();
    }

    public boolean isUserLoggedIn() {

        return logInMenuLink.getText().contains("Log out");
    }
}