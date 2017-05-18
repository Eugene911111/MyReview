package myreview.employeeTests.actionsWithObjectives;

import myreview.BaseTestForEmployee;
import org.junit.Assert;
import org.junit.Test;

public class AddObjectiveOnFormTabTest extends BaseTestForEmployee {

    @Test
    public void addObjectiveOnFormTab() throws Exception {
        formTabPage.openUrl(commonPage.formTabURL);
        noteTabPage.addObjective();
        Assert.assertEquals(sqlQueries.select("goals","title", noteTabPage.currentTime), noteTabPage.currentTime);
    }
}