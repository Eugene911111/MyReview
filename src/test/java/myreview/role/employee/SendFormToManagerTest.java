package myreview.role.employee;

import core.Configuration;
import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.CommonPage;
import pages.FormTabPage;

public class SendFormToManagerTest extends BaseTest {

    private int numberOfAddedObjectives = 3;
    private CommonPage commonPage = new CommonPage();
    private FormTabPage formTabPage = new FormTabPage();
    private Preconditions preconditions = new Preconditions();

    @Test
    public void sendFormToManager() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptester1());

        SqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, "committed");
        SqlQueries.addEmployeeComment();

        commonPage.openFormTab();
        formTabPage.sendFormToManager();
        Assert.assertEquals(Configuration.getInstance().getCommitted(), SqlQueries.select("status", "user_forms", "user_id", Configuration.getInstance().getEPTESTER_1_ID()));
        SqlQueries.changeStatusOfUserForm(Configuration.getInstance().getInProgress());

        preconditions.postcondition();
    }
}