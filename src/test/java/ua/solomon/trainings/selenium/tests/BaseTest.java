package ua.solomon.trainings.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import ua.solomon.trainings.selenium.utils.ProjectUtils;
import ua.solomon.trainings.selenium.utils.WebDriverUtils;

public abstract class BaseTest {
    public WebDriver driver;

    @Parameters("browser")

    @BeforeMethod
    public void createBrowser() {
        String browser = ProjectUtils.getPropertie("browser");

        if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else
            System.out.println("Driver was not set, using the default Firefox");
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
