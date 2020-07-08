package tests;

import Utils.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;
import pages.RegisterPage;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;

public class RegisterPageTest extends TestBase {

    @BeforeEach
    public void setUp() {
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }

// de inregistrat cont nou

/*    @Test
    public void canRegisterWithValidCredentials() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerAs("female", "Alina", "Albu", 01, "January",
                1950, StringUtils.getRandomEmailAddress(), "BlaBlaSRL", true,
                "qazwsx", "qazwsx");
        assertThat(registerPage.getResultRegistration(), is("Your registration completed"));
    }   */

    @Test
    public void canRegisterWithValidCredentials() {
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.registerAs("female", "Zmantana", "DeCasa", 01, "January",
                2000, "zmantana_1@gmail.com", "VacaMU SRL", true,
                "qazwsxedcrfv", "qazwsxedcrfv");

        assertThat(registerPage.getResultRegistration(), is("Your registration completed"));
    }

    @Test
    public void cannotRegisterTwiceWithTheSameEmail() {
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.registerAs("female", "Zmantana", "DeCasa", 01, "January",
                2000, "zmantana_1@gmail.com", "VacaMU SRL", true,
                "qazwsxedcrfv", "qazwsxedcrfv");

        assertThat(registerPage.getAlreadyRegisteredError(), is("The specified email already exists"));
    }

    @Test
    public void cannotRegisterWithInvalidEmail() {
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.registerAs("female", "Alina", "Albu", 01, "February",
                1910, "zmantana@ceva", "BlaBlaSRL", true,
                "qazwsx", "qazwsx");

        for (String e : registerPage.getErrorMessages()) {
            assertThat(e, is("Wrong email"));
        }
    }

    @Test
    public void cannotRegisterWithOutPasswords() {
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.registerAs("female", "Alina", "Albu", 01, "February",
                1910, "zmantana@gmail.com", "BlaBlaSRL", true,
                "", "");

        for (String e : registerPage.getErrorMessages()) {
            assertThat(e, is("Password is required."));
        }
    }

    @Test
    public void cannotRegisterWithOutPasswordConfimation() {
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.registerAs("female", "Alina", "Albu", 01, "February",
                1910, "zmantana@gmail.com", "BlaBlaSRL", true,
                "123456", "");

        for (String e : registerPage.getErrorMessages()) {
            assertThat(e, is("Password is required."));
        }
    }

    @Test
    public void cannotRegisterWithDifferentPasswords() {
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.registerAs("female", "Alina", "Albu", 01, "February",
                1910, "zmantana@gmail.com", "BlaBlaSRL", true,
                "123456", "12345678");

        assertThat(registerPage.getErrorMessages(), contains("The password and confirmation password do not match."));
    }
}

