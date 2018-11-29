package ua.solomon.trainings.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class SeleniumHomePage extends BasePage {
    private final String MENU_DOWNLOAD_ID = "menu_download";

    public SeleniumHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = MENU_DOWNLOAD_ID)
    public WebElement downloadTab;

    @Override
    public void at() {
        String url = driver.getCurrentUrl();
        url.equals("https://www.seleniumhq.org/");
        waitUntil(presenceOfElementLocated(By.id(MENU_DOWNLOAD_ID)));
    }
}
