package myreview.role.employee.actions_with_objectives;

import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.FormTabPage;
import pages.NoteTabPage;

import static core.Configuration.EPTESTER_1;
import static pages.CommonPage.formTabUrl;

public class AddObjectiveOnFormTabTest extends BaseTest {

    private NoteTabPage noteTabPage = new NoteTabPage();
    private Preconditions preconditions = new Preconditions();

    @Test
    public void addObjectiveOnFormTab() throws Exception {
        preconditions.precondition(EPTESTER_1);

        FormTabPage.openUrl(formTabUrl);
        noteTabPage.addObjective();
        Assert.assertEquals(SqlQueries.select("goals", "title", noteTabPage.currentTime), noteTabPage.currentTime);

        preconditions.postcondition();
    }
}