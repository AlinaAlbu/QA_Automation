package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LogInPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LogInTest extends TestBase {

    @BeforeEach
    public void setUp() {
        driver.manage().window().maximize();
    }

    // de facut alt cont cu credentiale valide

    @Test
    public void canLoginWithValidCredentials() {
        driver.get("https://demo.nopcommerce.com/login");

        LogInPage loginPage = new LogInPage(driver);
        loginPage.loginAs("vreau_la_munte@gmail.com", "qazwsxedc");

        assertThat(loginPage.getLoginMessage(), is("Log out"));
    }

    @Test
    public void cannotLogInWithInvalidPassoword() {
        driver.get("https://demo.nopcommerce.com/login");

        LogInPage loginPage = new LogInPage(driver);
        loginPage.loginAs("maria.stancescu@gmail.com", "Invalid");

        assertThat(loginPage.getErrorMessage(), is("Login was unsuccessful. Please correct the errors and try again.\n"
                + "The credentials provided are incorrect"));
    }

    @Test
    public void cannotLogInWithInvalidEmail() {
        driver.get("https://demo.nopcommerce.com/login");

        LogInPage loginPage = new LogInPage(driver);
        loginPage.loginAs("maria.stancescu@yahoo.com.com", "qazwsxedc");

        assertThat(loginPage.getErrorMessage(), is("Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found"));
    }

    @Test
    public void cannotLogInWithInvalidEmailAndPassword() {
        driver.get("https://demo.nopcommerce.com/login");

        LogInPage loginPage = new LogInPage(driver);
        loginPage.loginAs("blabla@yahoo.com", "invalid");

        assertThat(loginPage.getErrorMessage(), is("Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found"));
    }

    @Test
    public void cannotLogInWithNoEmailAndPassword() {
        driver.get("https://demo.nopcommerce.com/login");

        LogInPage loginPage = new LogInPage(driver);
        loginPage.loginAs("", "");

        assertThat(loginPage.getErrorEmail(), is("Please enter your email"));
    }
}