package pages;

import org.openqa.selenium.By;

public class FormTabPage extends BasePage {
    private By importFromNotesButton = By.xpath("//button[@class=\"addGoalButton md-raised md-button md-ink-ripple\"][contains(., \"Import from notes\")]");
    private By notesModalWindow = By.xpath("//div[@class=\"notesModal\"]");
    private By addToFormButton = By.xpath("//button[@class=\"md-raised goalActionButton md-button md-ink-ripple\"][contains(., \"Add to form\")]");
    private By closeButton = By.xpath("//button[@class=\"md-icon-button md-button md-ink-ripple\"]");
    private By deleteFromSettingObjectivesButton = By.xpath("//button[@class=\"md-raised goalActionButton md-button md-ink-ripple\"][contains(., \"Delete\")]");
    private By deleteObjectiveDialogWindow = By.xpath("//button[@class=\"md-raised goalActionButton md-button md-ink-ripple\"][contains(., \"Delete\")]");
    private By deleteObjectiveDialogWindowButton = By.xpath("//button[@class=\"md-raised md-primary md-button md-ink-ripple\"][contains(., \"Delete\")]");
    private By lastElementInListOfObjectives = By.xpath("//div[@id=\"objectives\"]//following::div[@class=\"col-xs-2 goalTitle ng-binding\"][last()]");
    private By sendToManagerButton = By.xpath("/html/body/div/user-form/div[1]/button[1]");
    private By sendButton = By.xpath("//md-dialog-actions[@class=\"layout-row\"]//button[contains(., \"Send\")]");
    private By formHasBeenSentMessage = By.xpath("//div[@class=\"md-whiteframe-4dp form-status\"][contains(., \"Form has been sent to manager\")]");
    public String formTabURL = "http://myreview.local/app_dev.php/#/form";
    public By rejectReasonField = By.xpath("//div[@class=\"rejectReason ng-binding\"]");
    public By formTabContent = By.xpath("//div[@class=\"container-fluid goalForm ng-scope\"]");

    public void pressImportFromNotesButton() throws InterruptedException {
        waitForElementIsClickableAndClick(importFromNotesButton);
        checkElementIsDisplayed(notesModalWindow);
        waitForElementIsClickableAndClick(addToFormButton);
        waitForElementIsClickableAndClick(closeButton);
        checkElementIsNotDisplayed(notesModalWindow);
    }

    public void sendFormToManager() throws Exception {
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