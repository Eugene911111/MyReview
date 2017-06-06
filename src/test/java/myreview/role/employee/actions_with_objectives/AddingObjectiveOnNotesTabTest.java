package myreview.role.employee.actions_with_objectives;

import core.Configuration;
import core.PreconditionBuilder;
import core.Postcondition;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.NoteTabPage;

public class AddingObjectiveOnNotesTabTest extends BaseTest {

    private SqlQueries sqlQueries = new SqlQueries();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private Postcondition postcondition = new Postcondition();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void addObjectiveOnNotesTab() throws Exception {
        preconditionBuilder
                .loginAs(Configuration.getInstance().getEpTester1())
                .build();

        noteTabPage.addObjective();
        Assert.assertEquals(sqlQueries.select("goals", "title", noteTabPage.currentTime), noteTabPage.currentTime);

        postcondition.logout();
    }
}