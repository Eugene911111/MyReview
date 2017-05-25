package myreview.role.employee.actions_with_objectives;

import core.Configuration;
import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.CommonPage;
import pages.FormTabPage;
import pages.NoteTabPage;

public class AddObjectiveToFormTest extends BaseTest {

    private int numberOfNotesToAdd = 1;
    private CommonPage commonPage = new CommonPage();
    private FormTabPage formTabPage = new FormTabPage();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private Preconditions preconditions = new Preconditions();

    @Test
    public void addToFormTest() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptester1());
        SqlQueries.insert(numberOfNotesToAdd);

        noteTabPage.addToForm();
        commonPage.openFormTab();
        Assert.assertEquals(numberOfNotesToAdd, formTabPage.settingObjectiveCount());

        preconditions.postcondition();
    }
}