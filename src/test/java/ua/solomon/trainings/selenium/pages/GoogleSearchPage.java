package ua.solomon.trainings.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.solomon.trainings.selenium.utils.Waiter;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class GoogleSearchPage extends BasePage {
    private final String SEARCH_INPUT_NAME = "q";

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.waiter = new Waiter(driver);
    }

    @FindBy(name = SEARCH_INPUT_NAME)
    public WebElement searchInput;

    @Override
    public void at() {
        waiter.waitUntil(presenceOfElementLocated(By.name(SEARCH_INPUT_NAME)));
    }

    public void go() {
        driver.get("https://www.google.com");
        at();
    }
}
