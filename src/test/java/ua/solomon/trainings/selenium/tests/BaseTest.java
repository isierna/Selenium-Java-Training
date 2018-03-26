package ua.solomon.trainings.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void createBrowser() {
        driver = new FirefoxDriver();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
