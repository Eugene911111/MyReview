package myreview;

import helpers.SqlQueries;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pages.CommonPage;
import pages.DepartmentPage;
import pages.FormTabPage;
import pages.LoginPage;

import static core.Configuration.*;

public class FullCycleFormTest extends BaseTest {
    private int numberOfAddedObjectives = 3;

    @Ignore
    @Test
    public void fullCycleFormTest() throws Exception {
        SqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, "committed");
        try {
            CommonPage.openFormTab();

            FormTabPage.sendFormToManager();
            Assert.assertEquals(USER_FORMS_STATUS_COMMITTED, SqlQueries.select("status", "user_forms", "user_id", EPTESTER_1_ID));

            CommonPage.logOut();
            LoginPage.logIn(EPTESTERDM);
            DepartmentPage.approveForm();
            Assert.assertEquals(USER_FORMS_STATUS_APPROVED, SqlQueries.select("status", "user_forms", "user_id", EPTESTER_1_ID));

            DepartmentPage.startMeeting();
            Assert.assertEquals(USER_FORMS_STATUS_APPRAISAL, SqlQueries.select("status", "user_forms", "user_id", EPTESTER_1_ID));

            DepartmentPage.submitForm();
            SqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_IN_PROGRESS);
        } catch (Exception exception) {
            SqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_IN_PROGRESS);
            throw exception;
        }
    }
}