package myreview.department_manager;

import core.Configuration;
import core.PreconditionBuilder;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DepartmentPage;

public class StartMeeting extends BaseTest {
    private int numberOfAddedObjectives = 3;
    private SqlQueries sqlQueries = new SqlQueries();
    private DepartmentPage departmentPage = new DepartmentPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void startMeeting() throws Exception {
        preconditionBuilder.loginAs(Configuration.getInstance().getATesterDm())
                .addNoteToSettingObjectiveDB(numberOfAddedObjectives, Configuration.getInstance().getCommitted())
                .changeStatusOfUserForm(Configuration.getInstance().getApproved())
                .build();

        departmentPage.clickElementSetPageIndexCheckElementIsDisplayed(departmentPage.startMeetingButton, 1, departmentPage.reviewMeetingPage);
        Assert.assertEquals(Configuration.getInstance().getAppraisal(), sqlQueries.select("status", "user_forms", "user_id", Configuration.getInstance().getATester1Id()));
    }
}