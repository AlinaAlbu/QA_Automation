// alt F& sa vezi in ce clasa e folosit obiectul

package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactPage;
import pages.LogInPage;
import pages.ResultPage;
import java.util.List;
import java.util.stream.Stream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ContactPageTest extends TestBase {


    @Test
    public void canSubmitContactForm() {
        driver.get("https://demo.nopcommerce.com/contactus");
        ContactPage contactPage = new ContactPage(driver);

        contactPage.submitForm("alina", "zmantana@gmail.com", "wertyu");

        assertThat(contactPage.getResult(), is("Your enquiry has been successfully sent to the store owner."));
    }

/*    @ParameterizedTest
    @MethodSource("fillInData")
    public void cannotSubmitContactForm(String fillInData, String errorMessages) {
        driver.get("https://demo.nopcommerce.com/contactus");
        ContactPage contactPage = new ContactPage(driver);
        contactPage.submitForm("", "", "");
        assertThat(contactPage.getErrorMessages(), is(errorMessages));
    }

    public static Stream<Arguments> fillInData() {
        return Stream.of(
                arguments(" ", "zmantana@gmail.com", "1234dvbghuobvnld", "Enter your name"),
                arguments("Alina", " ", "1234dvbghuobvnld", "Enter email"),
                arguments("Alina", "zmantana@gmail.com", " ", "Enter enquiry"));
    }*/

    @Test
    public void cannotSubmitContactFormWithNoName() {
        driver.get("https://demo.nopcommerce.com/contactus");
        ContactPage contactPage = new ContactPage(driver);

        contactPage.submitForm("", "sma@gmail.com", "asd");

        assertThat(contactPage.getNameError(), is("Enter your name"));

    }

    @Test
    public void cannotSubmitContactFormWithNoEmail() {
        driver.get("https://demo.nopcommerce.com/contactus");
        ContactPage contactPage = new ContactPage(driver);

        contactPage.submitForm("asd", "", "asdf");

        assertThat(contactPage.getEmailError(), is("Enter email"));

    }

    @Test
    public void cannotSubmitContactFormWithOutEnquiry() {
        driver.get("https://demo.nopcommerce.com/contactus");
        ContactPage contactPage = new ContactPage(driver);

        contactPage.submitForm("asd", "qwe@gmail.com", "");

        for (String e : contactPage.getErrorMessages()) {
            assertThat(e, is("Enter enquiry"));
        }

    }


    @Test
    public void whenUserIsLoggedInPersonalDetailsAreFilledIn() {
        driver.get("https://demo.nopcommerce.com/login");

        LogInPage loginPage = new LogInPage(driver);
        loginPage.loginAs("zmantana@gmail.com", "qazwsxedc");

        driver.get("https://demo.nopcommerce.com/contactus");
        ContactPage contactPage = new ContactPage(driver);

        assertThat(contactPage.fullNameInput(), is("Zmantana DeCasa"));
        assertThat(contactPage.emailInput(), is("zmantana@gmail.com"));

    }
}

