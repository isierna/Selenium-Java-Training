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

        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        GoogleSearchResultsPage googleSearchResultsPage = new GoogleSearchResultsPage(driver);
        SeleniumHomePage seleniumHomePage = new SeleniumHomePage(driver);
        SeleniumDownloadPage seleniumDownloadPage = new SeleniumDownloadPage(driver);
        PomReader pomReader = new PomReader();
        String currentProgectSeleniumVersion = pomReader.getSeleniumVersion();

        //when

        googleSearchPage.go();
        googleSearchPage.searchInput.sendKeys("Selenium");
        googleSearchPage.searchInput.submit();
        googleSearchResultsPage.at();
        googleSearchResultsPage.seleniumHomePageLink.click();
        seleniumHomePage.at();
        seleniumHomePage.downloadTab.click();
        seleniumDownloadPage.at();

        String latestSeleniumVersionFromOfficialSite = seleniumDownloadPage.versionNumberElement.getText();

        System.out.println("Current system version from POM " + currentProgectSeleniumVersion);
        System.out.println("From site " + latestSeleniumVersionFromOfficialSite);

        //then

        Assert.assertEquals(latestSeleniumVersionFromOfficialSite, currentProgectSeleniumVersion);
    }
}
