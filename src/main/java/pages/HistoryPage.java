package pages;

import org.openqa.selenium.By;

public class HistoryPage extends BasePage {
    private BasePage basePage = new BasePage();
    public By historyContent = By.xpath("//div[@class='historyForm container-fluid ng-scope']");

    public void checkThatItISPossibleToOpenAndCloseInformationAboutMeeting() throws InterruptedException {
        basePage.waitForElementIsClickableAndClick(By.xpath("//div[@class='paneHeader ng-scope']"));
        basePage.checkElementIsDisplayed(By.xpath("//div[@aria-expanded='true']//div[@class='previewReviewThin'][contains(., 'Overall')]"));
        basePage.waitForElementIsClickableAndClick(By.xpath("//div[@class='paneHeader ng-scope']"));
        basePage.checkElementIsNotDisplayed(By.xpath("//div[@aria-expanded='true']//div[@class='previewReviewThin'][contains(., 'Overall')]"));
        basePage.waitForElementIsClickableAndClick(By.xpath("//div[@class='paneHeader ng-scope']"));
    }
}
