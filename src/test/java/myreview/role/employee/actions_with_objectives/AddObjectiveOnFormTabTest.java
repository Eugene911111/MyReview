package myreview.role.employee.actions_with_objectives;

import core.Configuration;
import core.Postcondition;
import core.PreconditionBuilder;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.BasePage;
import pages.NoteTabPage;

public class AddObjectiveOnFormTabTest extends BaseTest {

    private BasePage basePage = new BasePage();
    private SqlQueries sqlQueries = new SqlQueries();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private Postcondition postcondition = new Postcondition();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void addObjectiveOnFormTab() throws Exception {
        preconditionBuilder
                .loginAs(Configuration.getInstance().getEpTester1())
                .build();

        basePage.openUrl(Configuration.getInstance().getFormTabUrl());
        noteTabPage.addObjective();
        Assert.assertEquals(sqlQueries.select("goals", "title", noteTabPage.currentTime), noteTabPage.currentTime);

        postcondition.logout();
    }
}