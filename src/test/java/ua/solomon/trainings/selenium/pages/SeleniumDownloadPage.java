package ua.solomon.trainings.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class SeleniumDownloadPage extends BasePage {
    private final String VERSION_NUMBER_XPATH = "//td[text()='Java']/following-sibling::td[1]";

    public SeleniumDownloadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = VERSION_NUMBER_XPATH)
    public WebElement versionNumberElement;

    @Override
    public void at() {
        String url = driver.getCurrentUrl();
        url.equals("https://www.seleniumhq.org/download/");
        waitUntil(presenceOfElementLocated(By.xpath("//p[text()[contains(.,'Download version')]]")));
    }

}
