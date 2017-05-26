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

public class AddObjectiveOnFormTabTest extends BaseTest {

    private CommonPage commonPage = new CommonPage();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private Preconditions preconditions = new Preconditions();


    @Test
    public void addObjectiveOnFormTab() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptester1());

        commonPage.openUrl(commonPage.formTabUrl);
        noteTabPage.addObjective();
        Assert.assertEquals(SqlQueries.select("goals", "title", noteTabPage.currentTime), noteTabPage.currentTime);

        preconditions.postcondition();
    }
}