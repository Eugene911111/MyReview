package myreview.employee.actions_with_objectives;

import core.Configuration;
import core.PreconditionBuilder;
import myreview.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.NoteTabPage;

public class CheckQuantityOfObjectivesTest extends BaseTest {
    private int numberOfNotesToAdd = 1;
    private BasePage basePage = new BasePage();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void checkQuantityOfObjectives() throws Exception {
        preconditionBuilder
                .loginAs(Configuration.getInstance().getATester1())
                .insert(numberOfNotesToAdd)
                .build();

        Assert.assertTrue(basePage.checkElementIsDisplayed(noteTabPage.areaOfObjective));
        Assert.assertEquals(numberOfNotesToAdd, noteTabPage.objectiveCount());
    }
}