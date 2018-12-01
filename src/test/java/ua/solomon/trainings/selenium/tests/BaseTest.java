package ua.solomon.trainings.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ua.solomon.trainings.selenium.utils.ProjectUtils;
import ua.solomon.trainings.selenium.utils.WebDriverUtils;

public abstract class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void createBrowser() {
        String browser;

        if (System.getProperty("browser") == null) {
            browser = ProjectUtils.getProperty("browser").toLowerCase();
        } else {
            browser = System.getProperty("browser").toLowerCase();
        }

        switch (browser) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "IE":
                driver = new InternetExplorerDriver();
                break;
            default:
                driver = new FirefoxDriver();
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
