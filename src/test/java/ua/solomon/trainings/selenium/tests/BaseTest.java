package ua.solomon.trainings.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.AfterMethod;

import ua.solomon.trainings.selenium.utils.FieldInjector;
import ua.solomon.trainings.selenium.utils.GetProperty;
import ua.solomon.trainings.selenium.utils.WebDriverUtils;

public class BaseTest {
    public static WebDriver driver;

    @GetProperty(property = "browser")
    public String browser;


    //@BeforeMethod
    // in order to call Field injector method we need to create its instance. Apparently with @BeforeMethod instance is not created.
    // therefore injectFieldValue() that expects an object, doesn't have it

    public void createBrowser() {
        FieldInjector.injectFieldValue(this);


        if (System.getProperty("browser") != null) {
            browser = System.getProperty("browser").toUpperCase();
        }

        switch (browser) {
            case "FIREFOX":
                driver = new FirefoxDriver();
                break;
            case "CHROME":
                driver = new ChromeDriver();
                break;
            case "SAFARI":
                driver = new SafariDriver();
                break;
            case "IE":
                driver = new InternetExplorerDriver();
                break;
            default:
                System.out.println("Please specify the browser in config file or in your command");

        }
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public <T> void waitUntil(ExpectedCondition<T> expectedCondition) {
        WebDriverUtils.waitUntil(driver, expectedCondition);
    }

}
