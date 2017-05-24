package myreview.role.employee.actions_with_objectives;

import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.NoteTabPage;

import static core.Configuration.EPTESTER_1;

public class DeleteObjectiveOnNoteTabTest extends BaseTest {

    private int numberOfNotesToAdd = 1;
    private NoteTabPage noteTabPage = new NoteTabPage();
    private Preconditions preconditions = new Preconditions();

    @Test
    public void deleteObjectiveOnNoteTab() throws Exception {
        preconditions.precondition(EPTESTER_1);
        SqlQueries.insert(numberOfNotesToAdd);

        noteTabPage.deleteObjectiveFromNotes();
        Assert.assertEquals(null, (SqlQueries.select("goals", "title", "autoTestTitle")));

        preconditions.postcondition();
    }
}