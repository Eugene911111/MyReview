package myreview.employee.actions_with_objectives;

import core.Configuration;
import core.Postcondition;
import core.PreconditionBuilder;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NoteTabPage;

public class DeleteObjectiveOnNoteTabTest extends BaseTest {
    private int numberOfNotesToAdd = 1;
    private SqlQueries sqlQueries = new SqlQueries();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private Postcondition postcondition = new Postcondition();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void deleteObjectiveOnNoteTab() throws Exception {
        preconditionBuilder
                .loginAs(Configuration.getInstance().getATester1())
                .insert(numberOfNotesToAdd)
                .build();

        noteTabPage.deleteObjectiveFromNotes();
        Assert.assertEquals(null, (sqlQueries.select("goals", "title", "autoTestTitle")));
    }
}