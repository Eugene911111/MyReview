package myreview.role.employee.actions_with_objectives;

import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import pages.NoteTabPage;
import org.junit.Assert;
import org.junit.Test;

import static core.Configuration.EPTESTER_1;

public class EditObjectiveOnNoteTabTest extends BaseTest {

    private int numberOfNotesToAdd = 1;
    private NoteTabPage noteTabPage = new NoteTabPage();
    private Preconditions preconditions = new Preconditions();

    @Test
    public void checkEditOfTheObjective() throws Exception {
        preconditions.precondition(EPTESTER_1);
        SqlQueries.insert(numberOfNotesToAdd);

        noteTabPage.editObjective(noteTabPage.titleAfterEdit, noteTabPage.commentAfterEdit);
        // UI check
        Assert.assertEquals(NoteTabPage.getTextFromElement(noteTabPage.lastTitleInList), noteTabPage.titleAfterEdit);
        // DB check
        Assert.assertEquals((SqlQueries.select("goals", "title", noteTabPage.titleAfterEdit)), noteTabPage.titleAfterEdit);

        preconditions.postcondition();
    }
}