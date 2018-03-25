package ua.solomon.trainings.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class SeleniumDownloadPage extends BasePage{
    public SeleniumDownloadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[text()='Java']/following-sibling::td[1]")
    public WebElement versionNumberElement;

    @Override
    public void go() {

    }

    @Override
    public void at() {
        String url = driver.getCurrentUrl();
        url.equals("https://www.seleniumhq.org/download/");
        waitUntil(presenceOfElementLocated(By.xpath("//p[text()[contains(.,'Download version')]]")));
    }

    @Override
    public void goTo(WebElement element) {

    }
}
