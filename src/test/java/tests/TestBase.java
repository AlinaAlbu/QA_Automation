package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    public void baseSetUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/ivi/workspace/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @AfterEach
    public void tearDown() {

        driver.quit();
    }
}
