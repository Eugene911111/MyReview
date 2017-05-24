package myreview.role.employee.actionsWithObjectives;

import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.CommonPage;
import pages.FormTabPage;
import pages.NoteTabPage;

import static core.Configuration.EPTESTER_1;

public class AddObjectiveToFormTest extends BaseTest {
    private int numberOfNotesToAdd = 1;
    private NoteTabPage noteTabPage = new NoteTabPage();
    private CommonPage commonPage = new CommonPage();
    private FormTabPage formTabPage = new FormTabPage();
    private Preconditions preconditions = new Preconditions();

    @Test
    public void addToFormTest() throws Exception {
        preconditions.precondition(EPTESTER_1);
        SqlQueries.insert(numberOfNotesToAdd);

        noteTabPage.addToForm();
        commonPage.openFormTab();
        Assert.assertEquals(numberOfNotesToAdd, formTabPage.settingObjectiveCount());

        preconditions.postcondition();
    }
}