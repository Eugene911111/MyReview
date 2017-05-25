package myreview.role.dm;

import core.Configuration;
import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.DepartmentPage;

public class StartMeeting extends BaseTest {
    private int numberOfAddedObjectives = 3;
    private Preconditions preconditions = new Preconditions();
    private DepartmentPage departmentPage = new DepartmentPage();

    @Test
    public void startMeeting() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptesterdm());
        SqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, "committed");
        SqlQueries.changeStatusOfUserForm(Configuration.getInstance().getApproved());

        departmentPage.startMeeting();
        Assert.assertEquals(Configuration.getInstance().getAppraisal(), SqlQueries.select("status", "user_forms", "user_id", Configuration.getInstance().getEPTESTER_1_ID()));

        preconditions.postcondition();
    }
}