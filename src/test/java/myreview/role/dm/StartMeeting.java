package myreview.role.dm;

import core.Configuration;
import core.PreconditionBuilder;
import core.Postcondition;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.DepartmentPage;

public class StartMeeting extends BaseTest {
    private int numberOfAddedObjectives = 3;
    private Postcondition postcondition = new Postcondition();
    private DepartmentPage departmentPage = new DepartmentPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();
    private SqlQueries sqlQueries = new SqlQueries();

    @Test
    public void startMeeting() throws Exception {
        preconditionBuilder.loginAs(Configuration.getInstance().getEpTesterDm())
                .addNoteToSettingObjectiveDB(numberOfAddedObjectives, Configuration.getInstance().getCommitted())
                .changeStatusOfUserForm(Configuration.getInstance().getApproved())
                .build();

        departmentPage.startMeeting();
        Assert.assertEquals(Configuration.getInstance().getAppraisal(), sqlQueries.select("status", "user_forms", "user_id", Configuration.getInstance().getEpTester1Id()));

        postcondition.logout();
    }
}