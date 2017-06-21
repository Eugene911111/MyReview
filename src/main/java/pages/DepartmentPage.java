package pages;

import core.Configuration;
import org.openqa.selenium.By;

import static core.TestApi.getDrivers;


public class DepartmentPage extends BasePage {

    private By rejectButton = By.xpath("//md-dialog[@class='_md md-transition-in']//button[contains(., 'Reject')]");
    private By approveButton = By.xpath("//md-dialog-actions[@class='layout-row']/button[contains(., 'Approve')]");
    private By rejectMessage = By.xpath("/html/body/header/md-toast/div/span");
    private By approveMessage = By.xpath("//*[contains(text(), 'You successfully submitted the form!')] ");
    private By continueButton = By.xpath("/html/body/div/department/div/div/div[2]/div[2]/div[2]/div[1]/div/div[3]/div[2]/button[2]/span");
    private By departmentButton = By.xpath("//a[@ui-sref='department']");
    private By reviewFormButton = By.xpath("//a[contains(., 'Review form')]");
    private By rejectFormButton = By.xpath("//button[contains(., 'Reject form')]");
    private By approveFormButton = By.xpath("//button[contains(., 'Approve form')]");
    private By rejectReasonField = By.xpath("//textarea[@name='commentFormReject']");
    private By commentByManagerField = By.xpath("//*[@id='input_9']");
    private By evaluationByDmMeetsExpactations = By.xpath("//md-radio-button[@id='radio_11']");
    private String commentByManager = "comment_created_with_auto_test";
    private By submitButton = By.xpath("//md-dialog//button[contains(., 'Submit')]");
    private By evaluationByDm = By.xpath("//md-radio-button[@id='radio_16']");
    public By reviewMeetingPage = By.xpath("//div[@class='container-fluid goalForm ng-scope']");
    public By startMeetingButton = By.xpath("//button[contains(., 'Start Meeting')][@aria-hidden='false']");
    public By evaluationByEmployee = By.xpath("//md-radio-button[@id='radio_11']");
    public By departmentTabContent = By.xpath("//div[@class='container-fluid department']");
    private By submitFinalFormButton = By.xpath("//button[@class='md-raised md-primary md-button md-ink-ripple']");
    private By employeePasswordField = By.xpath("//input[@name='password']");
    private By submitFinalFormMessage = By.xpath("//*[contains(text(), 'You successfully finished Performance Review Meeting!')] ");
    public By notificationForDmField = By.xpath("//a[@class='active']/span");
    By radioButtonExceedsExpectations = By.xpath("//md-radio-button[@value='Exceeds expectations']");

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

    public void approveFormManually() throws Exception {
        waitForElementIsClickableAndClick(reviewFormButton);
        changeFocusToPage(1);
        findElementClearAndSendKeys(commentByManagerField, commentByManager);
        waitForElementIsClickableAndClick(evaluationByDmMeetsExpactations);
        waitForElementIsClickableAndClick(approveFormButton);
        waitForElementIsClickableAndClick(approveButton);
        checkElementIsDisplayed(approveMessage);
    }

    public void startMeeting() throws InterruptedException {
        waitForElementIsClickableAndClick(startMeetingButton);
        int i = 0;
        long startTime = System.currentTimeMillis();
        while ((System.currentTimeMillis() - startTime) < 5000 && i < 1) {
            try {
                changeFocusToPage(1);
                checkElementIsDisplayed(reviewMeetingPage);
                i++;
            } catch (IndexOutOfBoundsException ignored) {
            }
        }
    }

    public void clickElementSetPageIndexCheckElementIsDisplayed(By clickElement, int pageIndex, By elementIsDisplayed) throws InterruptedException {
        waitForElementIsClickableAndClick(clickElement);
        int i = 0;
        long startTime = System.currentTimeMillis();
        while ((System.currentTimeMillis() - startTime) < 5000 && i < 1) {
            try {
                changeFocusToPage(pageIndex);
                checkElementIsDisplayed(elementIsDisplayed);
                i++;
            } catch (IndexOutOfBoundsException ignored) {
            }
        }
    }

    public void continueMeeting() throws InterruptedException {
        waitForElementIsClickableAndClick(startMeetingButton);
        changeFocusToPage(0);
        getDrivers().navigate().refresh();
        checkElementIsDisplayed(continueButton);
        waitForElementIsClickableAndClick(continueButton);
        changeFocusToPage(1);
        checkElementIsDisplayed(reviewMeetingPage);
    }

    public void submitForm() throws Exception {
        openUrl(Configuration.getInstance().getReviewMeetingUrl() + Configuration.getInstance().getATester1Id());
        waitForElementIsClickableAndClick(evaluationByEmployee);
        waitForElementIsClickableAndClick(evaluationByDm);
        findElementClearAndSendKeys(employeePasswordField, Configuration.getInstance().getPassword());
        waitForElementIsClickableAndClick(submitFinalFormButton);
        waitForElementIsClickableAndClick(submitButton);
        checkElementIsDisplayed(submitFinalFormMessage);
    }

    public void submitFormManually() throws Exception {
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
