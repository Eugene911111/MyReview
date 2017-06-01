package myreview.role.employee.actions_with_objectives;

import core.Configuration;
import core.Postcondition;
import core.PreconditionBuilder;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.NoteTabPage;

public class EditObjectiveOnNoteTabTest extends BaseTest {

    private int numberOfNotesToAdd = 1;
    private SqlQueries sqlQueries = new SqlQueries();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private Postcondition postcondition = new Postcondition();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void checkEditOfTheObjective() throws Exception {
        preconditionBuilder
                .loginAs(Configuration.getInstance().getEpTester1())
                .insert(numberOfNotesToAdd)
                .build();

        noteTabPage.editObjective(noteTabPage.titleAfterEdit, noteTabPage.commentAfterEdit);
        /** UI check */
        Assert.assertEquals(noteTabPage.getTextFromElement(noteTabPage.lastTitleInList), noteTabPage.titleAfterEdit);
        /** DB check */
        Assert.assertEquals((sqlQueries.select("goals", "title", noteTabPage.titleAfterEdit)), noteTabPage.titleAfterEdit);

        postcondition.logout();
    }
}