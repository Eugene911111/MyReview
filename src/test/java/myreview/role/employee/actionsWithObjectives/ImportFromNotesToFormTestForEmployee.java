package myreview.role.employee.actionsWithObjectives;

import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.CommonPage;
import pages.FormTabPage;
import pages.NoteTabPage;

import static core.Configuration.EPTESTER_1;
import static pages.CommonPage.formTabUrl;

public class ImportFromNotesToFormTestForEmployee extends BaseTest {
    private int numberOfNotedToAdd = 1;
    private String expectedTitle = "autoTestTitle";
    private Preconditions preconditions = new Preconditions();
    private FormTabPage formTabPage = new FormTabPage();
    private NoteTabPage noteTabPage = new NoteTabPage();
    @Test
    public void importFromNotesToFormTest() throws Exception {
        preconditions.precondition(EPTESTER_1);
        SqlQueries.insert(numberOfNotedToAdd);

        CommonPage.openUrl(formTabUrl);
        formTabPage.pressImportFromNotesButton();
        Assert.assertEquals(expectedTitle, NoteTabPage.getTextFromElement(noteTabPage.lastObjectiveTitleInList));

        preconditions.postcondition();
    }
}