package myreview.role.employee.actions_with_objectives;

import core.Configuration;
import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import pages.NoteTabPage;
import org.junit.Assert;
import org.junit.Test;
import pages.BasePage;


public class CheckQuantityOfObjectivesTest extends BaseTest {
    private int numberOfNotesToAdd = 1;
    private BasePage basePage = new BasePage();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private Preconditions preconditions = new Preconditions();

    @Test
    public void checkQuantityOfObjectives() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptester1());
        SqlQueries.insert(numberOfNotesToAdd);

        Assert.assertTrue(basePage.checkElementIsDisplayed(noteTabPage.areaOfObjective));
        Assert.assertEquals(numberOfNotesToAdd, noteTabPage.objectiveCount());

        preconditions.postcondition();
    }
}