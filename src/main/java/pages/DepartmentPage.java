package pages;

import org.openqa.selenium.By;

import static helpers.sqlQueries.EPTESTER_1_ID;
import static pages.LoginPage.PASSWORD;

public class DepartmentPage extends BasePage {
    public final By reviewFormButton = By.xpath("//a[@class=\"md-raised md-button md-ink-ripple\"][contains(., \"Review form\")]");
    public final By commentByManagerField = By.xpath("//*[@id=\"input_2\"]");
    public String commentByManager = "comment_created_with_auto_test";
    public final By rejectFormButton = By.xpath("//button[@class=\"md-raised md-primary md-button md-ink-ripple\"][contains(., \"Reject form\")]");

    public final By approveFormButton = By.xpath("//button[@class=\"md-raised md-primary md-button md-ink-ripple\"][contains(., \"Approve form\")]");
    public final By approveButton = By.xpath("//md-dialog-actions[@class=\"layout-row\"]/button[contains(., \"Approve\")]");
    public final By notificationForDmField = By.xpath("//a[@class=\"active\"]/span");
    public String departmentURL = "http://myreview.local/app_dev.php/#/department";
    private final By radioButtonExceedsExpectations = By.xpath("//md-radio-button[@value=\"Exceeds expectations\"]");
    public String rejectReason = "reject reason created with auto test";
    private final By rejectReasonField = By.xpath("//textarea[@name=\"commentFormReject\"]");
    private final By rejectButton = By.xpath("//md-dialog[@class=\"_md md-transition-in\"]//button[contains(., \"Reject\")]");
    private final By rejectWindow = By.xpath("//div[@class=\"md-dialog-container ng-scope\"]");
    private final By rejectMessage = By.xpath("/html/body/header/md-toast/div/span");
    private final By startMettingButton = By.xpath("//div[@class=\"goalsPane ng-scope\"]//button[contains(., \"Start Meeting\")][@aria-hidden=\"false\"]");
    private final By evaluationByEmployee = By.xpath("//div[@class=\"evaluationGroup ng-scope\"][contains(., \"Evaluation by employee: \")]//md-radio-button[@id=\"radio_4\"]");
    private final By evaluationByDm = By.xpath("//div[@class=\"evaluationGroup ng-scope\"][contains(., \"\")]//md-radio-button[@id=\"radio_8\"]");
    private final By employeePasswordField = By.xpath("//input[@name=\"password\"]");
    private final By submitFinalFormButton = By.xpath("//button[@class=\"md-raised md-primary md-button md-ink-ripple\"]");
    //public String password = "Levi9Pro";
    private final By submitButton = By.xpath("//md-dialog[@class=\"_md md-transition-in\"]//button[contains(., \"Submit\")]");
    private final By approveMessage = By.xpath("//*[contains(text(), \"You successfully submitted the form!\")] ");
    private final By submitFinalFormMessage = By.xpath("//*[contains(text(), \"You successfully finished Performance Review Meeting!\")] ");
    private final By fieldIsRequiredErrorMessage = By.xpath("//div[@class=\"paneContent\"]//div[@class=\"md-input-message-animation ng-scope\"]");
    public String reviewMeetingUrl = "http://myreview.local/app_dev.php/#/department/review-meeting/";
    public final By departmentTabContent = By.xpath("//div[@class=\"container-fluid department\"]");

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

       // highlightElementAndSendKeys(commentByManagerField, commentByManager);
     //   waitForPresenceOfTextInElement(commentByManagerField, commentByManager);
      //  checkElementIsNotDisplayed(fieldIsRequiredErrorMessage);
     //   waitForElementIsClickableAndClick(radioButtonExceedsExpectations);
        waitForElementIsClickableAndClick(approveFormButton);
        waitForElementIsPresentAndClick(approveButton);
        checkElementIsDisplayed(approveMessage);
    }

    public void startMeeting() throws InterruptedException {
        waitForElementIsClickableAndClick(startMettingButton);
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

    // rewright this
    public void continueMeeting() throws InterruptedException {
        waitForElementIsClickableAndClick(startMettingButton);
        for (int i = 0; i < 1; i++) {
            try {
                changeFocusToPage(1);
                checkElementIsDisplayed(submitFinalFormButton);
                driver.close();
            } catch (IndexOutOfBoundsException ignored) {
                System.out.println("!");
            }
        }
        changeFocusToPage(0);
        driver.navigate().refresh();
        waitForElementIsPresentAndClick(By.xpath("/html/body/div/department/div/div/div[2]/div[2]/div[2]/div[1]/div/div[3]/div[2]/button[2]"));
        changeFocusToPage(2);
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
