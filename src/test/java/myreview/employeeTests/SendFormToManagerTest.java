package myreview.employeeTests;

import myreview.BaseTestForEmployee;
import org.junit.*;

import static helpers.sqlQueries.EPTESTER_1_ID;
import static helpers.sqlQueries.USER_FORMS_STATUS_COMMITTED;
import static helpers.sqlQueries.USER_FORMS_STATUS_IN_PROGRESS;

public class SendFormToManagerTest extends BaseTestForEmployee {
    private final int numberOfAddedObjectives = 3;

    @Test
    public void sendFormToManager() throws Exception {
        sqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, "committed");
        sqlQueries.addEmployeeComment();

        commonPage.openFormTab();
        formTabPage.sendFormToManager();
        try {
            Assert.assertEquals(USER_FORMS_STATUS_COMMITTED, sqlQueries.select("status", "user_forms", "user_id", EPTESTER_1_ID));
        } catch (AssertionError assertionError) {
            sqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_IN_PROGRESS);
            throw assertionError;
        }
        sqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_IN_PROGRESS);
    }
}