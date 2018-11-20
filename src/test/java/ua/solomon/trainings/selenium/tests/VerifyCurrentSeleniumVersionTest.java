package ua.solomon.trainings.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.solomon.trainings.selenium.pages.GoogleSearchPage;
import ua.solomon.trainings.selenium.pages.GoogleSearchResultsPage;
import ua.solomon.trainings.selenium.pages.SeleniumDownloadPage;
import ua.solomon.trainings.selenium.pages.SeleniumHomePage;
import ua.solomon.trainings.selenium.utils.PomReader;

public class VerifyCurrentSeleniumVersionTest extends BaseTest {


    @Test
    public void verifyCurrentSeleniumVersion() {

        //given
        GoogleSearchPage googleSearchPage;
        GoogleSearchResultsPage googleSearchResultsPage;
        SeleniumHomePage seleniumHomePage;
        SeleniumDownloadPage seleniumDownloadPage;
        PomReader pomReader = new PomReader();
        String currentProgectSeleniumVersion = pomReader.getSeleniumVersion();

        //when
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.go();
        googleSearchPage.searchInput.sendKeys("Selenium");
        googleSearchPage.searchInput.submit();

        googleSearchResultsPage = new GoogleSearchResultsPage(driver);
        googleSearchResultsPage.at();
        googleSearchResultsPage.seleniumHomePageLink.click();

        seleniumHomePage = new SeleniumHomePage(driver);
        seleniumHomePage.at();
        seleniumHomePage.downloadTab.click();

        seleniumDownloadPage = new SeleniumDownloadPage(driver);
        seleniumDownloadPage.at();

        String latestSeleniumVersionFromOfficialSite = seleniumDownloadPage.versionNumberElement.getText();

        System.out.println("Current system version from POM " + currentProgectSeleniumVersion);
        System.out.println("From site " + latestSeleniumVersionFromOfficialSite);

        //then
        Assert.assertEquals(latestSeleniumVersionFromOfficialSite, currentProgectSeleniumVersion);
    }
}
