package pages;

import org.openqa.selenium.By;

import static core.TestApi.getDriver;

public class FormTabPage extends BasePage {

    private By sendButton = By.xpath("//md-dialog-actions[@class=\"layout-row\"]//button[contains(., \"Send\")]");
    private By closeButton = By.xpath("//button[@class=\"md-icon-button md-button md-ink-ripple\"]");
    private By addToFormButton = By.xpath("//button[@class=\"md-raised goalActionButton md-button md-ink-ripple\"][contains(., \"Add to form\")]");
    private By notesModalWindow = By.xpath("//div[@class=\"notesModal\"]");
    private By sendToManagerButton = By.xpath("/html/body/div/user-form/div[1]/button[1]");
    private By importFromNotesButton = By.xpath("//button[@class=\"addGoalButton md-raised md-button md-ink-ripple\"][contains(., \"Import from notes\")]");
    private By formHasBeenSentMessage = By.xpath("//div[@class=\"md-whiteframe-4dp form-status\"][contains(., \"Form has been sent to manager\")]");
    private By lastElementInListOfObjectives = By.xpath("//div[@id=\"objectives\"]//following::div[@class=\"col-xs-2 goalTitle ng-binding\"][last()]");
    private By clearButton = By.xpath("//button[@class=\"md-raised md-button md-ink-ripple\"]");
    public By rejectReasonField = By.xpath("//div[@class=\"rejectReason ng-binding\"]");
    public By formTabContent = By.xpath("//div[@class=\"container-fluid goalForm ng-scope\"]");
    private DepartmentPage departmentPage = new DepartmentPage();
    private CommonPage commonPage = new CommonPage();
    private By evaluationAreaTrue = By.xpath("//md-radio-button[@aria-checked=\"true\"]");

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
        return getDriver().findElements(lastElementInListOfObjectives).size();
    }

    public void clearEvaluationByEmployee() throws Exception {
        getDriver().get(commonPage.formTabUrl);
        waitForElementIsClickableAndClick(departmentPage.radioButtonExceedsExpectations);
        checkElementIsDisplayed(evaluationAreaTrue);
        waitForElementIsClickableAndClick(clearButton);
        checkElementIsNotDisplayed(evaluationAreaTrue);
        getDriver().navigate().refresh();
        checkElementIsDisplayed(departmentPage.radioButtonExceedsExpectations);
        checkElementIsNotDisplayed(evaluationAreaTrue);
    }
}