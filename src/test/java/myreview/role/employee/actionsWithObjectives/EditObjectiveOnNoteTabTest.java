package myreview.role.employee.actionsWithObjectives;

import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.NoteTabPage;

import static core.Configuration.EPTESTER_1;

public class EditObjectiveOnNoteTabTest extends BaseTest {
    private int numberOfNotesToAdd = 1;
    private Preconditions preconditions = new Preconditions();
    private NoteTabPage noteTabPage = new NoteTabPage();

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