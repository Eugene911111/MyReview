package myreview.role.employee.actions_with_objectives;

import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.NoteTabPage;

import static core.Configuration.EPTESTER_1;

public class AddingObjectiveOnNotesTabTest extends BaseTest {
    private Preconditions preconditions = new Preconditions();
    private NoteTabPage noteTabPage = new NoteTabPage();

    @Test
    public void addObjectiveOnNotesTab() throws Exception {
        preconditions.precondition(EPTESTER_1);

        noteTabPage.addObjective();
        Assert.assertEquals(SqlQueries.select("goals","title", noteTabPage.currentTime), noteTabPage.currentTime);

        preconditions.postcondition();
    }
}