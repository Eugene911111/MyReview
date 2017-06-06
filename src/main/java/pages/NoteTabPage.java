package pages;

import org.openqa.selenium.By;
import org.junit.Assert;

import java.util.Date;
import java.text.SimpleDateFormat;

import static core.TestApi.getDriver;

public class NoteTabPage extends BasePage {

    private CommonPage commonPage = new CommonPage();
    private String commentByEmployee = "comment";
    private String dateFormat = "E yyyy.MM.dd 'at' hh.mm.ss a";
    private By titleField = By.xpath("//input[@name=\"title\"]");
    private By saveButton = By.xpath("//button[contains(., \"Save\")]");
    private By editButton = By.xpath("//button[contains(.,\"Edit\")]");
    private By deleteButton = By.xpath("//button[contains(.,\"Delete\")]");
    private By addToFormButton = By.xpath("//button[contains(., \"Add to form\")]");
    private By addObjectiveButton = By.xpath("//button[contains(.,\"Add objective\")]");
    private By addObjectiveWindow = By.xpath("//md-dialog[@aria-label=\"Edit\"]");
    private By deleteObjectiveWindow = By.xpath("//md-dialog[@class=\"_md md-transition-in\"]");
    private By commentByEmployeeField = By.xpath("//textarea[@name=\"Comment by employee\"]");
    private By deleteObjectiveWindowButton = By.xpath("//md-dialog//button[contains(.,\"Delete\")]");
    public By lastObjectiveTitleInList = By.xpath("//div[@id=\"objectives\"]//following::div[@class=\"col-xs-2 goalTitle ng-binding\"][last()]");
    public By feedbackDialogWindow = By.xpath("//md-dialog[@class=\"_md md-transition-in\"]");
    public By notesPageContent = By.xpath("//div[@class=\"container-fluid goalForm ng-scope\"]");
    public By lastTitleInList = By.xpath("//div[@class=\"clearfix goal\"]/div[1]");
    public By areaOfObjective = By.xpath("//div[@class=\"clearfix goal\"]");
    public By formExampleImg = By.xpath("//img[@src=\"/uploads/example.png\"]");
    public String commentAfterEdit = ("comment after edit");
    public String titleAfterEdit = ("title after edit");
    public String currentTime;

    public int objectiveCount() throws Exception {
        return getDriver().findElement(By.xpath("//div[@class=\"paneContent\"]")).findElements(By.xpath("//div[@class=\"clearfix goal\"]")).size();
    }

    private String returnCurrentTime() throws InterruptedException {
        SimpleDateFormat ft = new SimpleDateFormat(dateFormat);
        currentTime = ft.format(new Date());
        return currentTime;
    }

    public void addObjective() throws InterruptedException {
        waitForElementIsClickableAndClick(addObjectiveButton);
        checkElementIsDisplayed(addObjectiveWindow);
        findElementClearAndSendKeys(commentByEmployeeField, commentByEmployee);
        waitForPresenceOfTextInTextAreaInputElement(commentByEmployeeField, commentByEmployee);
        findElementClearAndSendKeys(titleField, returnCurrentTime());
        waitForPresenceOfTextInTextAreaInputElement(titleField, currentTime);
        waitForElementIsClickableAndClick(saveButton);
        waitForPresenceOfTextInDivElement(lastObjectiveTitleInList, currentTime);
        Assert.assertEquals(currentTime, getTextFromElement(lastObjectiveTitleInList));
        checkElementIsDisplayed(commonPage.formButton);
    }

    public void editObjective(String titleAfterEdit, String commentAfterEdit) throws InterruptedException {
        waitForElementIsClickableAndClick(editButton);
        findElementClearAndSendKeys(commentByEmployeeField, commentAfterEdit);
        waitForPresenceOfTextInTextAreaInputElement(commentByEmployeeField, commentAfterEdit);
        findElementClearAndSendKeys(titleField, titleAfterEdit);
        waitForPresenceOfTextInTextAreaInputElement(titleField, titleAfterEdit);
        waitForElementIsClickableAndClick(saveButton);
        waitForPresenceOfTextInDivElement(lastTitleInList, titleAfterEdit);
    }

    public void deleteObjectiveFromNotes() throws InterruptedException {
        waitForElementIsClickableAndClick(deleteButton);
        checkElementIsDisplayed(deleteObjectiveWindow);
        waitForElementIsClickableAndClick(deleteObjectiveWindowButton);
        checkElementIsNotDisplayed(deleteObjectiveWindow);
        checkElementIsNotDisplayed(areaOfObjective);
    }

    public void addToForm() throws InterruptedException {
        waitForElementIsClickableAndClick(addToFormButton);
        checkElementIsNotDisplayed(areaOfObjective);
    }
}