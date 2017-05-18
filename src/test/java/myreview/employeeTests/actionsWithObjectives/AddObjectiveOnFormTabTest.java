package myreview.employeeTests.actionsWithObjectives;

import myreview.BaseTestForEmployee;
import org.junit.Assert;
import org.junit.Test;

import static pages.CommonPage.formTabUrl;

public class AddObjectiveOnFormTabTest extends BaseTestForEmployee {

    @Test
    public void addObjectiveOnFormTab() throws Exception {
        formTabPage.openUrl(formTabUrl);
        noteTabPage.addObjective();
        Assert.assertEquals(sqlQueries.select("goals","title", noteTabPage.currentTime), noteTabPage.currentTime);
    }
}