package myreview.role.employee.actions_with_objectives;

import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.BasePage;
import pages.NoteTabPage;

import static core.Configuration.EPTESTER_1;

public class CheckQuantityOfObjectivesTest extends BaseTest {
    private int numberOfNotesToAdd = 1;
    private Preconditions preconditions = new Preconditions();
    private NoteTabPage noteTabPage = new NoteTabPage();

    @Test
    public void checkQuantityOfObjectives() throws Exception {
        preconditions.precondition(EPTESTER_1);
        SqlQueries.insert(numberOfNotesToAdd);

        Assert.assertTrue(BasePage.checkElementIsDisplayed(noteTabPage.areaOfObjective));
        Assert.assertEquals(numberOfNotesToAdd, noteTabPage.objectiveCount());

        preconditions.postcondition();
    }
}