package myreview.employeeTests.actionsWithObjectives;

import myreview.BaseTestForEmployee;
import org.junit.Assert;
import org.junit.Test;

public class CheckQuantityOfObjectivesTest extends BaseTestForEmployee {
    private int numberOfNotesToAdd = 1;

    @Test
    public void checkQuantityOfObjectives() throws Exception {
        sqlQueries.insert(numberOfNotesToAdd);

        Assert.assertTrue(noteTabPage.checkElementIsDisplayed(noteTabPage.areaOfObjective));
        Assert.assertEquals(numberOfNotesToAdd, noteTabPage.objectiveCount());
    }
}