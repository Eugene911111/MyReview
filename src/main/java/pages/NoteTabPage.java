package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

import static core.TestApi.getDriver;

public class NoteTabPage extends BasePage {

    private CommonPage commonPage = new CommonPage();
    private String commentByEmployee = "comment";
    private By titleField = By.xpath("//div[@class=\"md-dialog-content\"]//input[@name=\"title\"]");
    private By saveButton = By.xpath("//button[@class=\"md-raised md-primary md-button md-ink-ripple\"][contains(., \"Save\")]");
    private By editButton = By.xpath("//button[@class=\"md-raised goalActionButton md-button md-ink-ripple\"][contains(.,\"Edit\")]");
    private By deleteButton = By.xpath("//button[@type=\"button\"][contains(.,\"Delete\")]");
    private By addToFormButton = By.xpath("//button[@class=\"md-raised goalActionButton md-button md-ink-ripple\"][contains(., \"Add to form\")]");
    private By addObjectiveButton = By.xpath("//button[@class=\"addGoalButton md-raised md-button md-ink-ripple\"][contains(.,\"Add objective\")]");
    private By addObjectiveWindow = By.xpath("//md-dialog[@aria-label=\"Edit\"]");
    private By deleteObjectiveWindow = By.xpath("//md-dialog[@class=\"_md md-transition-in\"]");
    private By commentByEmployeeField = By.xpath("//div[@class=\"md-dialog-content\"]//textarea[@name=\"Comment by employee\"]");
    private By deleteObjectiveWindowButton = By.xpath("//md-dialog[@class=\"_md md-transition-in\"]//button[contains(.,\"Delete\")]");
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
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh.mm.ss a");
        currentTime = ft.format(new Date());
        return currentTime;
    }

    public void addObjective() throws InterruptedException {
        waitForElementIsClickableAndClick(addObjectiveButton);
        checkElementIsDisplayed(addObjectiveWindow);
        findElementAndSendKeys(commentByEmployeeField, commentByEmployee);
        waitForPresenceOfTextInElement(commentByEmployeeField, commentByEmployee);
        findElementAndSendKeys(titleField, returnCurrentTime());
        waitForPresenceOfTextInElement(titleField, currentTime);
        waitForElementIsClickableAndClick(saveButton);
        waitForPresenceOfTextInElement1(lastObjectiveTitleInList, currentTime);
        Assert.assertEquals(currentTime, getTextFromElement(lastObjectiveTitleInList));
        checkElementIsDisplayed(commonPage.formButton);
    }

    public void editObjective(String titleAfterEdit, String commentAfterEdit) throws InterruptedException {
        waitForElementIsClickableAndClick(editButton);
        findElementClearAndSendKeys(commentByEmployeeField, commentAfterEdit);
        waitForPresenceOfTextInElement(commentByEmployeeField, commentAfterEdit);
        findElementClearAndSendKeys(titleField, titleAfterEdit);
        waitForPresenceOfTextInElement(titleField, titleAfterEdit);
        waitForElementIsClickableAndClick(saveButton);
        waitForPresenceOfTextInElement1(lastTitleInList, titleAfterEdit);
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