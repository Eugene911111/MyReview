package myreview.dmTests;

import myreview.BaseTestForDm;
import org.junit.Assert;
import org.junit.Test;

import static helpers.sqlQueries.*;

public class ApproveFormTest extends BaseTestForDm {
    private int numberOfAddedObjectives = 3;

    @Test
    public void approveForm() throws Exception {
        sqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, "committed");
        sqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_COMMITTED);
        departmentPage.approveForm();
        Assert.assertEquals(USER_FORMS_STATUS_APPROVED, sqlQueries.select("status", "user_forms", "user_id", EPTESTER_1_ID));

        sqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_IN_PROGRESS);
    }
}