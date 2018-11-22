package ua.solomon.trainings.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.solomon.trainings.selenium.utils.Waiter;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class SeleniumDownloadPage extends BasePage {
    private final String VERSION_NUMBER_CSS = "table:nth-child(13)>tbody>tr:nth-child(1)>td:nth-child(2)";

    public SeleniumDownloadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.waiter = new Waiter(driver);
    }

    @FindBy(css = VERSION_NUMBER_CSS)
    public WebElement versionNumberElement;

    @Override
    public void at() {
        String url = driver.getCurrentUrl();
        url.equals("https://www.seleniumhq.org/download/");
        waiter.waitUntil(presenceOfElementLocated(By.name("client-drivers")));
    }

}
