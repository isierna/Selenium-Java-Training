package ua.solomon.trainings.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ua.solomon.trainings.selenium.utils.WebDriverUtils;

public abstract class BasePage {
    public WebDriver driver;

    public abstract void at();

    public <T> void waitUntil(ExpectedCondition<T> expectedCondition) {
        WebDriverUtils.waitUntil(driver, expectedCondition);
    }

}
