package ua.solomon.trainings.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.solomon.trainings.selenium.pages.GoogleSearchPage;
import ua.solomon.trainings.selenium.pages.GoogleSearchResultsPage;
import ua.solomon.trainings.selenium.pages.SeleniumDownloadPage;
import ua.solomon.trainings.selenium.pages.SeleniumHomePage;
import ua.solomon.trainings.selenium.utils.ProjectUtils;

import java.io.IOException;

public class VerifyCurrentSeleniumVersion extends BaseTest {
        private static GoogleSearchPage googleSearchPage;
        private static GoogleSearchResultsPage googleSearchResultsPage;
        private static SeleniumHomePage seleniumHomePage;
        private static SeleniumDownloadPage seleniumDownloadPage;
        private String verionNumber;


        @Test
        public void verifyCurrentSeleniumVersion() throws IOException {
            googleSearchPage = new GoogleSearchPage(driver);
            googleSearchPage.go();
            googleSearchPage.at();

            googleSearchPage.searchInput.click();
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
            verionNumber = seleniumDownloadPage.versionNumberElement.getText();

            ProjectUtils projectUtils = new ProjectUtils();

            Assert.assertEquals(verionNumber, projectUtils.getSystemSeleniumVersion());
        }
}
