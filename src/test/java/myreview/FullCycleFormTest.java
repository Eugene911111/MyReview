package myreview;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static core.Configuration.EPTESTERDM;
import static helpers.sqlQueries.*;

public class FullCycleFormTest extends BaseTestForEmployee {
    private final int numberOfAddedObjectives = 3;

    @Ignore
    @Test
    public void fullCycleFormTest() throws Exception {
        sqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, "committed");
        try {
            commonPage.openFormTab();

            formTabPage.sendFormToManager();
            Assert.assertEquals(USER_FORMS_STATUS_COMMITTED, sqlQueries.select("status", "user_forms", "user_id", EPTESTER_1_ID));

            noteTabPage.logOut();
            loginPage.logIn(EPTESTERDM);
            departmentPage.approveForm();
            Assert.assertEquals(USER_FORMS_STATUS_APPROVED, sqlQueries.select("status", "user_forms", "user_id", EPTESTER_1_ID));

            departmentPage.startMeeting();
            Assert.assertEquals(USER_FORMS_STATUS_APPRAISAL, sqlQueries.select("status", "user_forms", "user_id", EPTESTER_1_ID));

            departmentPage.submitForm();
            sqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_IN_PROGRESS);
        } catch (Exception exception) {
            sqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_IN_PROGRESS);
            throw exception;
        }
    }
}