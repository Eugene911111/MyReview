package pages;

import core.Configuration;
import org.openqa.selenium.By;

import static core.TestApi.getDriver;

public class DepartmentPage extends BasePage {

    private By rejectButton = By.xpath("//md-dialog[@class=\"_md md-transition-in\"]//button[contains(., \"Reject\")]");
    private By submitButton = By.xpath("//md-dialog//button[contains(., \"Submit\")]");
    private By approveButton = By.xpath("//md-dialog-actions[@class=\"layout-row\"]/button[contains(., \"Approve\")]");
    private By rejectMessage = By.xpath("/html/body/header/md-toast/div/span");
    private By approveMessage = By.xpath("//*[contains(text(), \"You successfully submitted the form!\")] ");
    private By continueButton = By.xpath("/html/body/div/department/div/div/div[2]/div[2]/div[2]/div[1]/div/div[3]/div[2]/button[2]/span");
    private By evaluationByDm = By.xpath("//md-radio-button[@id=\"radio_8\"]");
    private By departmentButton = By.xpath("//a[@ui-sref=\"department\"]");
    private By reviewFormButton = By.xpath("//a[contains(., \"Review form\")]");
    private By rejectFormButton = By.xpath("//button[contains(., \"Reject form\")]");
    private By approveFormButton = By.xpath("//button[contains(., \"Approve form\")]");
    private By startMetingButton = By.xpath("//button[contains(., \"Start Meeting\")][@aria-hidden=\"false\"]");
    private By rejectReasonField = By.xpath("//textarea[@name=\"commentFormReject\"]");
    private By evaluationByEmployee = By.xpath("//md-radio-button[@id=\"radio_4\"]");
    private By submitFinalFormButton = By.xpath("//button[@class=\"md-raised md-primary md-button md-ink-ripple\"]");
    private By employeePasswordField = By.xpath("//input[@name=\"password\"]");
    private By commentByManagerField = By.xpath("//*[@id=\"input_2\"]");
    private By submitFinalFormMessage = By.xpath("//*[contains(text(), \"You successfully finished Performance Review Meeting!\")] ");
    private String commentByManager = "comment_created_with_auto_test";
    public By departmentTabContent = By.xpath("//div[@class=\"container-fluid department\"]");
    public By notificationForDmField = By.xpath("//a[@class=\"active\"]/span");
    By radioButtonExceedsExpectations = By.xpath("//md-radio-button[@value=\"Exceeds expectations\"]");
    private BasePage basePage = new BasePage();

    public void rejectForm() throws InterruptedException {
        openUrl(Configuration.getInstance().getDepartmentTabUrl());
        waitForElementIsClickableAndClick(reviewFormButton);
        changeFocusToPage(1);
        waitForElementIsClickableAndClick(radioButtonExceedsExpectations);
        findElementClearAndSendKeys(commentByManagerField, commentByManager);
        waitForPresenceOfTextInTextAreaInputElement(commentByManagerField, commentByManager);
        waitForElementIsClickableAndClick(rejectFormButton);
        findElementClearAndSendKeys(rejectReasonField, returnCurrentDate());
        waitForPresenceOfTextInTextAreaInputElement(rejectReasonField, currentDate);
        waitForElementIsClickableAndClick(rejectButton);
        checkElementIsDisplayed(rejectMessage);
    }

    public void approveForm() throws InterruptedException {
        openUrl(Configuration.getInstance().getDepartmentTabUrl());
        waitForElementIsClickableAndClick(reviewFormButton);
        changeFocusToPage(1);
        waitForElementIsClickableAndClick(approveFormButton);
        waitForElementIsClickableAndClick(approveButton);
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

    public void continueMeeting() throws InterruptedException {
        waitForElementIsClickableAndClick(startMetingButton);
        getDriver().navigate().refresh();
        changeFocusToPage(0);
        checkElementIsDisplayed(continueButton);
    }

    public void submitForm() throws Exception {
        openUrl(Configuration.getInstance().getReviewMeetingUrl() + Configuration.getInstance().getEpTester1Id());
        waitForElementIsClickableAndClick(evaluationByEmployee);
        waitForElementIsClickableAndClick(evaluationByDm);
        findElementClearAndSendKeys(employeePasswordField, Configuration.getInstance().getPassword());
        waitForElementIsClickableAndClick(submitFinalFormButton);
        waitForElementIsClickableAndClick(submitButton);
        checkElementIsDisplayed(submitFinalFormMessage);
    }

    public boolean notificationIsNotDisplayed() throws Exception {
        checkElementIsDisplayed(departmentButton);
        checkElementIsNotDisplayed(notificationForDmField);
        return true;
    }
}
