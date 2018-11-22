package ua.solomon.trainings.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.solomon.trainings.selenium.utils.Waiter;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class GoogleSearchResultsPage extends BasePage {
    private final String SELENIUM_LINK_XPATH = "//a/h3[contains(text(),'Web Browser Automation')]";
    private final String FOOTER_PAGINATION_ID = "navcnt";

    public GoogleSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.waiter = new Waiter(driver);
    }

    @FindBy(xpath = SELENIUM_LINK_XPATH)
    public WebElement seleniumHomePageLink;

    @FindBy(id = FOOTER_PAGINATION_ID)
    public WebElement googleFooterPaginationElement;

    @Override
    public void at() {
        waiter.waitUntil(presenceOfElementLocated(By.id(FOOTER_PAGINATION_ID)));
    }
}
