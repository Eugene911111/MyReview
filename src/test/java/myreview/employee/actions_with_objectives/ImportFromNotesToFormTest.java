package myreview.employee.actions_with_objectives;

import core.Configuration;
import core.PreconditionBuilder;
import myreview.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormTabPage;
import pages.NoteTabPage;

public class ImportFromNotesToFormTest extends BaseTest {

    private int numberOfNotesToAdd = 1;
    private String expectedTitle = "autoTestTitle";
    private FormTabPage formTabPage = new FormTabPage();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void importFromNotesToFormTest() throws Exception {
        preconditionBuilder
                .loginAs(Configuration.getInstance().getATester1())
                .insert(numberOfNotesToAdd)
                .build();

        formTabPage.pressImportFromNotesButton();
        Assert.assertEquals(expectedTitle, noteTabPage.getTextFromElement(noteTabPage.lastObjectiveTitleInList));
    }
}