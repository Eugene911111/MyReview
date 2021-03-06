package myreview.dmTests;

import myreview.BaseTestForDm;
import org.junit.Assert;
import org.junit.Test;

import static helpers.sqlQueries.*;

public class StartMeeting extends BaseTestForDm {
    private int numberOfAddedObjectives = 3;

    @Test
    public void startMeeting() throws Exception {
        sqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, "committed");
        sqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_APPROVED);

        departmentPage.startMeeting();
        Assert.assertEquals(USER_FORMS_STATUS_APPRAISAL, sqlQueries.select("status", "user_forms", "user_id", EPTESTER_1_ID));
        sqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_IN_PROGRESS);
    }
}