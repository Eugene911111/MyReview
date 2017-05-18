package pages;

import org.openqa.selenium.By;

public class FormTabPage extends BasePage {
    public final By importFromNotesButton = By.xpath("//button[@class=\"addGoalButton md-raised md-button md-ink-ripple\"][contains(., \"Import from notes\")]");
    public final By notesModalWindow = By.xpath("//div[@class=\"notesModal\"]");
    public final By addToFormButton = By.xpath("//button[@class=\"md-raised goalActionButton md-button md-ink-ripple\"][contains(., \"Add to form\")]");
    public final By closeButton = By.xpath("//button[@class=\"md-icon-button md-button md-ink-ripple\"]");
    public final By deleteFromSettingObjectivesButton = By.xpath("//button[@class=\"md-raised goalActionButton md-button md-ink-ripple\"][contains(., \"Delete\")]");
    public final By deleteObjectiveDialogWindow = By.xpath("//button[@class=\"md-raised goalActionButton md-button md-ink-ripple\"][contains(., \"Delete\")]");
    public final By deleteObjectiveDialogWindowButton = By.xpath("//button[@class=\"md-raised md-primary md-button md-ink-ripple\"][contains(., \"Delete\")]");
    public final By lastElementInListOfObjectives = By.xpath("//div[@id=\"objectives\"]//following::div[@class=\"col-xs-2 goalTitle ng-binding\"][last()]");
    public final By commentByEmployeeField = By.xpath("//textarea[@name=\"employee\"]");
    public final String commentByEmployee = "comment created with auto test";
    public final By sendToManagerButton = By.xpath("/html/body/div/user-form/div[1]/button[1]");
    private final By radioButtonExceedsExpectations = By.xpath("//md-radio-button[@value=\"Exceeds expectations\"]");
    public final By sendButton = By.xpath("//md-dialog-actions[@class=\"layout-row\"]//button[contains(., \"Send\")]");
    public final By formHasBeenSentMessage = By.xpath("//div[@class=\"md-whiteframe-4dp form-status\"][contains(., \"Form has been sent to manager\")]");
    public final String formTabURL = "http://myreview.local/app_dev.php/#/form";
    public final By rejectReasonField = By.xpath("//div[@class=\"rejectReason ng-binding\"]");
    public final By sendFormDialogWindow = By.xpath("//md-dialog[@class=\"_md md-transition-in\"]");
    private final By fieldIsRequiredErrorMessage = By.xpath("//div[@class=\"paneContent\"]//div[@class=\"md-input-message-animation ng-scope\"]");
    public final By formTabContent = By.xpath("//div[@class=\"container-fluid goalForm ng-scope\"]");

    public void pressImportFromNotesButton() throws InterruptedException {
        waitForElementIsClickableAndClick(importFromNotesButton);
        checkElementIsDisplayed(notesModalWindow);
        waitForElementIsClickableAndClick(addToFormButton);
        waitForElementIsClickableAndClick(closeButton);
        checkElementIsNotDisplayed(notesModalWindow);
    }

    public void deleteFromSettingObjectives() throws InterruptedException {
        waitForElementIsClickableAndClick(deleteFromSettingObjectivesButton);
        checkElementIsDisplayed(deleteObjectiveDialogWindow);
        waitForElementIsClickableAndClick(deleteObjectiveDialogWindowButton);
        checkElementIsNotDisplayed(lastElementInListOfObjectives);
    }

    public void sendFormToManager() throws Exception {
        // clearElement(commentByEmployeeField);
        // highlightElementAndSendKeys(commentByEmployeeField, commentByEmployee);
        // waitForPresenceOfTextInElement(commentByEmployeeField, commentByEmployee);
        // checkElementIsNotDisplayed(fieldIsRequiredErrorMessage);
        // checkElementIsNotDisplayed(By.xpath("//*[@id=\"overallComment\"]/div[4]/form/md-input-container/div[3]/div"));
        // waitForElementIsClickableAndClick(By.xpath("//button[@class=\"md-raised md-button md-ink-ripple\"]"));
        // waitForElementIsClickableAndClick(radioButtonExceedsExpectations);
        waitForElementIsClickableAndClick(sendToManagerButton);
        checkElementIsDisplayed(sendButton);
        waitForElementIsClickableAndClick(sendButton);
        checkElementIsDisplayed(formHasBeenSentMessage);
    }

    public int settingObjectiveCount() throws Exception {
        checkElementIsDisplayed(lastElementInListOfObjectives);
        int objectiveCount = driver.findElements(lastElementInListOfObjectives).size();
        return objectiveCount;
    }
}