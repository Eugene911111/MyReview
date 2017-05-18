package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NoteTabPage extends CommonPage {
    private final By LogInFormName = By.xpath("//div[@class=\"panel-heading\"][contains(., 'Log In')]");
    public String noteTabUrl = "http://myreview.local/app_dev.php/#/notes";
    public String formTabUrl = "http://myreview.local/app_dev.php/#/form";
    public final By addObjectiveButton = By.xpath("//button[@class=\"addGoalButton md-raised md-button md-ink-ripple\"][contains(.,\"Add objective\")]");
    public final By titleField = By.xpath("//div[@class=\"md-dialog-content\"]//input[@name=\"title\"]");
    public final By commentByEmployeeField = By.xpath("//div[@class=\"md-dialog-content\"]//textarea[@name=\"Comment by employee\"]");
    public String commentByEmployee = "comment";
    public final By saveButton = By.xpath("//button[@class=\"md-raised md-primary md-button md-ink-ripple\"][contains(., \"Save\")]");
    public final By addObjectiveWindow = By.xpath("//md-dialog[@aria-label=\"Edit\"]");
    public final By deleteButton = By.xpath("//button[@type=\"button\"][contains(.,\"Delete\")]");
    public final By deleteObjectiveWindow = By.xpath("//md-dialog[@class=\"_md md-transition-in\"]");
    public final By deleteObjectiveWindowButton = By.xpath("//md-dialog[@class=\"_md md-transition-in\"]//button[contains(.,\"Delete\")]");
    public final By lastObjectiveTitleInList = By.xpath("//div[@id=\"objectives\"]//following::div[@class=\"col-xs-2 goalTitle ng-binding\"][last()]");
    public final By lastTitleInList = By.xpath("//div[@class=\"clearfix goal\"]/div[1]");
    public final By areaOfObjective = By.xpath("//div[@class=\"clearfix goal\"]");
    public final By formExampleImg = By.xpath("//img[@src=\"/uploads/example.png\"]");
    public final By feedbackDialogWindow = By.xpath("//md-dialog[@class=\"_md md-transition-in\"]");
    public final By editButton = By.xpath("//button[@class=\"md-raised goalActionButton md-button md-ink-ripple\"][contains(.,\"Edit\")]");
    public final By addToFormButton = By.xpath("//button[@class=\"md-raised goalActionButton md-button md-ink-ripple\"][contains(., \"Add to form\")]");
    public String titleAfterEdit = ("title after edit");
    public String commentAfterEdit = ("comment after edit");
    public String currentTime;
    public final By notesPageContent = By.xpath("//div[@class=\"container-fluid goalForm ng-scope\"]");

    public void logOut() throws Exception {
        pressLogoutButton();
        checkElementIsDisplayed(levi9Logo);
        checkElementIsDisplayed(LogInFormName);
    }

    public int objectiveCount() throws Exception {
        return driver.findElement(By.xpath("//div[@class=\"paneContent\"]")).findElements(By.xpath("//div[@class=\"clearfix goal\"]")).size();
    }

    public String returnCurrentTime() throws InterruptedException {
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
        checkElementIsDisplayed(formButton);
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