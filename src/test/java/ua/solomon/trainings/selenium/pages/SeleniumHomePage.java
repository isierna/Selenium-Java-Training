package ua.solomon.trainings.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class SeleniumHomePage extends BasePage{
    public SeleniumHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/download/'][1]")
    public WebElement downloadTab;

    @Override
    public void go() {

    }

    @Override
    public void at() {
        String url = driver.getCurrentUrl();
        url.equals("https://www.seleniumhq.org/");
        waitUntil(presenceOfElementLocated(By.xpath("//*[@class='homepage push']")));
    }

    @Override
    public void goTo(WebElement element) {

    }
}
