package myreview.employeeTests.actionsWithObjectives;

import myreview.BaseTestForEmployee;
import org.junit.Assert;
import org.junit.Test;

public class AddObjectiveToFormTest extends BaseTestForEmployee {
    private int numberOfNotesToAdd = 1;

    @Test
    public void addToFormTest() throws Exception {
        sqlQueries.insert(numberOfNotesToAdd);

        noteTabPage.addToForm();
        commonPage.openFormTab();
        Assert.assertEquals(numberOfNotesToAdd, formTabPage.settingObjectiveCount());
    }
}