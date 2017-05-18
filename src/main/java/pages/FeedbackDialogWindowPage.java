package pages;

import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FeedbackDialogWindowPage extends BasePage {
    public final By bugRadioButton = By.xpath("//md-radio-button[@value=\"Bug\"]");
    public final By commentsForFeedbackField = By.xpath("//textarea[@name=\"feedbackInput\"]");
    public final By sendButton = By.xpath("//button[@ng-click=\"feedback.sendFeedback()\"]");
    public final By notificationAfterSendingFeedback = By.xpath("//span[@class=\"md-toast-text ng-binding\"][contains(., \" Thank you for feedback!\")]");

    public void sendFeedback() throws InterruptedException {
        waitForElementIsClickableAndClick(bugRadioButton);
        findElementAndSendKeys(commentsForFeedbackField, returnCurrentDate());
        waitForElementIsClickableAndClick(sendButton);
        checkElementIsDisplayed(notificationAfterSendingFeedback);
    }
}