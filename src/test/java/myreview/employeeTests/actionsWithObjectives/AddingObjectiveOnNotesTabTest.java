package myreview.employeeTests.actionsWithObjectives;

import myreview.BaseTestForEmployee;
import org.junit.Assert;
import org.junit.Test;

public class AddingObjectiveOnNotesTabTest extends BaseTestForEmployee {

    @Test
    public void addObjectiveOnNotesTab() throws Exception {
        noteTabPage.addObjective();
        Assert.assertEquals(sqlQueries.select("goals","title", noteTabPage.currentTime), noteTabPage.currentTime);
    }
}