package myreview.employeeTests.actionsWithObjectives;

import core.Configuration;
import myreview.BaseTestForEmployee;
import org.junit.Assert;
import org.junit.Test;

public class DeleteObjectiveOnNoteTabTest extends BaseTestForEmployee {
    private int numberOfNotesToAdd = 1;

    static {
        Configuration.TIME_OUT = 15;
    }

    @Test
    public void deleteObjectiveOnNoteTab() throws Exception {
        sqlQueries.insert(numberOfNotesToAdd);

        noteTabPage.deleteObjectiveFromNotes();
        Assert.assertEquals(null, (sqlQueries.select("goals","title", "autoTestTitle")));
    }
}