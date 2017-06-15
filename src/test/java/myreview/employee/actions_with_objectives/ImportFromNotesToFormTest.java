package myreview.employee.actions_with_objectives;

import core.Configuration;
import core.Postcondition;
import core.PreconditionBuilder;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.CommonPage;
import pages.FormTabPage;
import pages.NoteTabPage;

public class ImportFromNotesToFormTest extends BaseTest {

    private int numberOfNotesToAdd = 1;
    private String expectedTitle = "autoTestTitle";
    private CommonPage commonPage = new CommonPage();
    private FormTabPage formTabPage = new FormTabPage();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private Postcondition postcondition = new Postcondition();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void importFromNotesToFormTest() throws Exception {
        preconditionBuilder
                .loginAs(Configuration.getInstance().getATester1())
                .insert(numberOfNotesToAdd)
                .build();

        formTabPage.pressImportFromNotesButton();
        Assert.assertEquals(expectedTitle, noteTabPage.getTextFromElement(noteTabPage.lastObjectiveTitleInList));

        //postcondition.logout();
    }
}