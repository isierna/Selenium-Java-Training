package ua.solomon.trainings.selenium.pages;

import org.openqa.selenium.WebDriver;
import ua.solomon.trainings.selenium.utils.Waiter;

public abstract class BasePage {
    WebDriver driver;
    Waiter waiter;

    public abstract void at();

}
