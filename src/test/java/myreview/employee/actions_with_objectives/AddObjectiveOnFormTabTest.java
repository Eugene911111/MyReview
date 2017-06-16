package myreview.employee.actions_with_objectives;

import core.Configuration;
import core.PreconditionBuilder;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.NoteTabPage;

public class AddObjectiveOnFormTabTest extends BaseTest {

    private int quantityOfObjectives = 1;
    private BasePage basePage = new BasePage();
    private SqlQueries sqlQueries = new SqlQueries();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void addObjectiveOnFormTab() throws Exception {
        preconditionBuilder
                .loginAs(Configuration.getInstance().getATester1())
                .build();

        basePage.openUrl(Configuration.getInstance().getFormTabUrl());
        noteTabPage.addObjective(quantityOfObjectives);
        Assert.assertEquals(sqlQueries.select("goals", "title", noteTabPage.currentTime), noteTabPage.currentTime);
    }
}