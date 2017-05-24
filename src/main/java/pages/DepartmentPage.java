package pages;

import org.openqa.selenium.By;

import static core.Configuration.EPTESTER_1_ID;
import static core.Configuration.PASSWORD;
import static core.TestApi.getDriver;
import static pages.CommonPage.*;

public class DepartmentPage extends BasePage {
    private By rejectButton = By.xpath("//md-dialog[@class=\"_md md-transition-in\"]//button[contains(., \"Reject\")]");
    private By submitButton = By.xpath("//md-dialog[@class=\"_md md-transition-in\"]//button[contains(., \"Submit\")]");
    private By approveButton = By.xpath("//md-dialog-actions[@class=\"layout-row\"]/button[contains(., \"Approve\")]");
    private By rejectMessage = By.xpath("/html/body/header/md-toast/div/span");
    private By approveMessage = By.xpath("//*[contains(text(), \"You successfully submitted the form!\")] ");
    private By continueButton = By.xpath("/html/body/div/department/div/div/div[2]/div[2]/div[2]/div[1]/div/div[3]/div[2]/button[2]/span");
    private By evaluationByDm = By.xpath("//div[@class=\"evaluationGroup ng-scope\"][contains(., \"\")]//md-radio-button[@id=\"radio_8\"]");
    private By reviewFormButton = By.xpath("//a[@class=\"md-raised md-button md-ink-ripple\"][contains(., \"Review form\")]");
    private By rejectFormButton = By.xpath("//button[@class=\"md-raised md-primary md-button md-ink-ripple\"][contains(., \"Reject form\")]");
    private By approveFormButton = By.xpath("//button[@class=\"md-raised md-primary md-button md-ink-ripple\"][contains(., \"Approve form\")]");
    private By startMetingButton = By.xpath("//div[@class=\"goalsPane ng-scope\"]//button[contains(., \"Start Meeting\")][@aria-hidden=\"false\"]");
    private By rejectReasonField = By.xpath("//textarea[@name=\"commentFormReject\"]");
    private By evaluationByEmployee = By.xpath("//div[@class=\"evaluationGroup ng-scope\"][contains(., \"Evaluation by employee: \")]//md-radio-button[@id=\"radio_4\"]");
    private By submitFinalFormButton = By.xpath("//button[@class=\"md-raised md-primary md-button md-ink-ripple\"]");
    private By employeePasswordField = By.xpath("//input[@name=\"password\"]");
    private By commentByManagerField = By.xpath("//*[@id=\"input_2\"]");
    private By submitFinalFormMessage = By.xpath("//*[contains(text(), \"You successfully finished Performance Review Meeting!\")] ");
    private By radioButtonExceedsExpectations = By.xpath("//md-radio-button[@value=\"Exceeds expectations\"]");
    private String departmentURL = "http://myreview.local/app_dev.php/#/department";
    private String commentByManager = "comment_created_with_auto_test";
    public By departmentTabContent = By.xpath("//div[@class=\"container-fluid department\"]");
    public By notificationForDmField = By.xpath("//a[@class=\"active\"]/span");

    public void rejectForm() throws InterruptedException {
        openUrl(departmentURL);
        waitForElementIsClickableAndClick(reviewFormButton);
        changeFocusToPage(1);
        waitForElementIsClickableAndClick(radioButtonExceedsExpectations);
        highlightElementAndSendKeys(commentByManagerField, commentByManager);
        waitForPresenceOfTextInElement(commentByManagerField, commentByManager);
        waitForElementIsClickableAndClick(rejectFormButton);
        findElementClearAndSendKeys(rejectReasonField, returnCurrentDate());
        waitForPresenceOfTextInElement(rejectReasonField, currentDate);
        waitForElementIsClickableAndClick(rejectButton);
        checkElementIsDisplayed(rejectMessage);
    }

    public void approveForm() throws InterruptedException {
        openUrl(departmentURL);
        waitForElementIsClickableAndClick(reviewFormButton);
        changeFocusToPage(1);
        waitForElementIsClickableAndClick(approveFormButton);
        waitForElementIsPresentAndClick(approveButton);
        checkElementIsDisplayed(approveMessage);
    }

    public void startMeeting() throws InterruptedException {
        waitForElementIsClickableAndClick(startMetingButton);
        int i = 0;
        while (i < 1) {
            try {
                changeFocusToPage(1);
                checkElementIsDisplayed(submitFinalFormButton);
                i++;
            } catch (IndexOutOfBoundsException ignored) {
            }
        }
    }

    public  void continueMeeting() throws InterruptedException {
        waitForElementIsClickableAndClick(startMetingButton);
        getDriver().navigate().refresh();
        changeFocusToPage(0);
        checkElementIsDisplayed(continueButton);
    }

    public void submitForm() throws InterruptedException {
        openUrl(reviewMeetingUrl + EPTESTER_1_ID);
        waitForElementIsClickableAndClick(evaluationByEmployee);
        waitForElementIsClickableAndClick(evaluationByDm);
        findElementAndSendKeys(employeePasswordField, PASSWORD);
        waitForElementIsPresentAndClick(submitFinalFormButton);
        waitForElementIsPresentAndClick(submitButton);
        checkElementIsDisplayed(submitFinalFormMessage);
    }
}
