package pages;

import org.openqa.selenium.By;

public class FeedbackDialogWindowPage extends BasePage {

    private By sendButton = By.xpath("//button[@ng-click=\"feedback.sendFeedback()\"]");
    private By bugRadioButton = By.xpath("//md-radio-button[@value=\"Bug\"]");
    private By commentsForFeedbackField = By.xpath("//textarea[@name=\"feedbackInput\"]");
    private By notificationAfterSendingFeedback = By.xpath("//span[@class=\"md-toast-text ng-binding\"][contains(., \" Thank you for feedback!\")]");

    public void sendFeedback() throws InterruptedException {
        waitForElementIsClickableAndClick(bugRadioButton);
        findElementAndSendKeys(commentsForFeedbackField, returnCurrentDate());
        waitForElementIsClickableAndClick(sendButton);
        checkElementIsDisplayed(notificationAfterSendingFeedback);
    }
}