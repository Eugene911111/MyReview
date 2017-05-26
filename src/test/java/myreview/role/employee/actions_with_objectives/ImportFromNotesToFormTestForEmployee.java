package myreview.role.employee.actions_with_objectives;

import core.Configuration;
import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import pages.NoteTabPage;
import pages.FormTabPage;
import pages.CommonPage;
import org.junit.Assert;
import org.junit.Test;


public class ImportFromNotesToFormTestForEmployee extends BaseTest {

    private int numberOfNotedToAdd = 1;
    private String expectedTitle = "autoTestTitle";
    private FormTabPage formTabPage = new FormTabPage();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private Preconditions preconditions = new Preconditions();
    private CommonPage commonPage = new CommonPage();


    @Test
    public void importFromNotesToFormTest() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptester1());
        SqlQueries.insert(numberOfNotedToAdd);

        commonPage.openUrl(commonPage.formTabUrl);
        formTabPage.pressImportFromNotesButton();
        Assert.assertEquals(expectedTitle, noteTabPage.getTextFromElement(noteTabPage.lastObjectiveTitleInList));

        preconditions.postcondition();
    }
}