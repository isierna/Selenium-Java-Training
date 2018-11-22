package ua.solomon.trainings.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ua.solomon.trainings.selenium.utils.WebDriverUtils;

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

    public <T> void waitUntil(ExpectedCondition<T> expectedCondition) {
        WebDriverUtils.waitUntil(driver, expectedCondition);
    }

}
