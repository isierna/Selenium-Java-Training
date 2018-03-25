package ua.solomon.trainings.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class GoogleSearchResultsPage extends BasePage{
    public GoogleSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()[contains(.,'Web Browser Automation')]]")
    public WebElement seleniumHomePageLink;

    @Override
    public void go() {

    }

    @Override
    public void at() {
        waitUntil(presenceOfElementLocated(By.xpath("//div[@id='search']")));
    }

    @Override
    public void goTo(WebElement element) {

    }
}
