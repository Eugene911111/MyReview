package myreview.role.dm;

import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.DepartmentPage;

import static core.Configuration.*;

public class StartMeeting extends BaseTest {
    private int numberOfAddedObjectives = 3;
    private Preconditions preconditions = new Preconditions();
    private DepartmentPage departmentPage = new DepartmentPage();

    @Test
    public void startMeeting() throws Exception {
        preconditions.precondition(EPTESTERDM);
        SqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, "committed");
        SqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_APPROVED);

        departmentPage.startMeeting();
        Assert.assertEquals(USER_FORMS_STATUS_APPRAISAL, SqlQueries.select("status", "user_forms", "user_id", EPTESTER_1_ID));

        preconditions.postcondition();
    }
}