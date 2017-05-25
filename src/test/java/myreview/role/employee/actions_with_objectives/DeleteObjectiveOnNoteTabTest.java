package myreview.role.employee.actions_with_objectives;

import core.Configuration;
import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.NoteTabPage;

public class DeleteObjectiveOnNoteTabTest extends BaseTest {
    private int numberOfNotesToAdd = 1;
    private NoteTabPage noteTabPage = new NoteTabPage();
    private Preconditions preconditions = new Preconditions();

    @Test
    public void deleteObjectiveOnNoteTab() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptester1());
        SqlQueries.insert(numberOfNotesToAdd);

        noteTabPage.deleteObjectiveFromNotes();
        Assert.assertEquals(null, (SqlQueries.select("goals", "title", "autoTestTitle")));

        preconditions.postcondition();
    }
}