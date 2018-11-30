package ua.solomon.trainings.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WebDriverUtils {
    public static <T> void waitUntil(WebDriver driver, ExpectedCondition<T> expectedCondition) {

        String defaultTimeout = ProjectUtils.getProperty("timeout");
        long timeoutInSec;
        WebDriverWait wait;

        if(System.getProperty("timeout") == null) {
            timeoutInSec = Long.parseLong(defaultTimeout);
            wait = new WebDriverWait(driver, timeoutInSec);
            wait.until(expectedCondition);
        } else {
            timeoutInSec = Long.parseLong(System.getProperty("timeout"));
            wait = new WebDriverWait(driver, timeoutInSec);
            wait.until(expectedCondition);
        }
    }
}
