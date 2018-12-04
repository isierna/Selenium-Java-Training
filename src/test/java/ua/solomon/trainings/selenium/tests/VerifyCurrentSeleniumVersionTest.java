package ua.solomon.trainings.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.solomon.trainings.selenium.pages.GoogleSearchPage;
import ua.solomon.trainings.selenium.pages.GoogleSearchResultsPage;
import ua.solomon.trainings.selenium.pages.SeleniumDownloadPage;
import ua.solomon.trainings.selenium.pages.SeleniumHomePage;
import ua.solomon.trainings.selenium.utils.FindProperie;
import ua.solomon.trainings.selenium.utils.PomReader;

public class VerifyCurrentSeleniumVersionTest extends BaseTest {
    @FindProperie(prop = "browser")
    public WebDriver driver;


    @Test
    public void verifyCurrentSeleniumVersion() {
        //given
        PomReader pomReader = new PomReader();
        String currentProjectSeleniumVersion = pomReader.getSeleniumVersion();

        //when
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.go();
        googleSearchPage.searchInput.sendKeys("Selenium");
        googleSearchPage.searchInput.submit();

        GoogleSearchResultsPage googleSearchResultsPage = new GoogleSearchResultsPage(driver);
        googleSearchResultsPage.at();
        googleSearchResultsPage.seleniumHomePageLink.click();

        SeleniumHomePage seleniumHomePage = new SeleniumHomePage(driver);
        seleniumHomePage.at();
        seleniumHomePage.downloadTab.click();

        SeleniumDownloadPage seleniumDownloadPage = new SeleniumDownloadPage(driver);
        seleniumDownloadPage.at();

        String latestSeleniumVersionFromOfficialSite = seleniumDownloadPage.versionNumberElement.getText();

        System.out.println("Current system version from POM " + currentProjectSeleniumVersion);
        System.out.println("From site " + latestSeleniumVersionFromOfficialSite);

        //then
        Assert.assertEquals(latestSeleniumVersionFromOfficialSite, currentProjectSeleniumVersion);
    }
}
