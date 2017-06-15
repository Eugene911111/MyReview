package pages;

import core.Configuration;
import org.openqa.selenium.By;

import static core.TestApi.getDriver;

public class FormTabPage extends BasePage {

    private DepartmentPage departmentPage = new DepartmentPage();
    public By sendButton = By.xpath("//md-dialog-actions/button[contains(., 'Send')]");
    private By closeButton = By.xpath("//button[@class='md-icon-button md-button md-ink-ripple']");
    private By clearButton = By.xpath("//button[@class='md-raised md-button md-ink-ripple']");
    private By addToFormButton = By.xpath("//md-list-item/button[contains(., 'Add to form')]");
    private By notesModalWindow = By.xpath("//div[@class='notesModal']");
    private By evaluationAreaTrue = By.xpath("//md-radio-button[@aria-checked='true']");
    public By sendToManagerButton = By.xpath("/html/body/div/user-form/div[1]/button[1]");
    private By importFromNotesButton = By.xpath("//button[contains(., 'Import from notes')]");
    public By formHasBeenSentMessage = By.xpath("//div[@class='md-whiteframe-4dp form-status'][contains(., 'Form has been sent to manager')]");
    private By lastElementInListOfObjectives = By.xpath("//div[@id='objectives']//following::div[@class='col-xs-2 goalTitle ng-binding'][last()]");
    public By commentByEmployeeField = By.xpath("//textarea[@name='employee']");
    public By rejectReasonField = By.xpath("//div[@class='rejectReason ng-binding']");
    public By formTabContent = By.xpath("//div[@class='container-fluid goalForm ng-scope']");
    public By evaluationByEmployee = By.xpath("//md-radio-button[@id=\"radio_10\"]");
    public String commentByManager = "comment_created_with_auto_test";
    private int quantityOfObjectives = 3;
    private NoteTabPage noteTabPage = new NoteTabPage();

    public void pressImportFromNotesButton() throws InterruptedException {
        openUrl(Configuration.getInstance().getFormTabUrl());
        waitForElementIsClickableAndClick(importFromNotesButton);
        checkElementIsDisplayed(notesModalWindow);
        waitForElementIsClickableAndClick(addToFormButton);
        waitForElementIsClickableAndClick(closeButton);
        checkElementIsNotDisplayed(notesModalWindow);
    }


    public void sendFormToManager() throws Exception {
        openUrl(Configuration.getInstance().getFormTabUrl());
        waitForElementIsClickableAndClick(sendToManagerButton);
        checkElementIsDisplayed(sendButton);
        waitForElementIsClickableAndClick(sendButton);
        checkElementIsDisplayed(formHasBeenSentMessage);
    }

    public void sendFormToManagerManualy() throws Exception {
        openUrl(Configuration.getInstance().getFormTabUrl());
        noteTabPage.addObjective(quantityOfObjectives);

        findElementClearAndSendKeys(commentByEmployeeField, commentByManager);
        waitForElementIsClickableAndClick(evaluationByEmployee);
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
        getDriver().get(Configuration.getInstance().getFormTabUrl());
        waitForElementIsClickableAndClick(departmentPage.radioButtonExceedsExpectations);
        checkElementIsDisplayed(evaluationAreaTrue);
        waitForElementIsClickableAndClick(clearButton);
        checkElementIsNotDisplayed(evaluationAreaTrue);
        getDriver().navigate().refresh();
        checkElementIsDisplayed(departmentPage.radioButtonExceedsExpectations);
        checkElementIsNotDisplayed(evaluationAreaTrue);
    }
}