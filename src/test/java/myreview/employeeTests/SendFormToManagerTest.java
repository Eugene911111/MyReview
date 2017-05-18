package myreview.employeeTests;

import myreview.BaseTestForEmployee;
import org.junit.Assert;
import org.junit.Test;

import static core.Configuration.*;

public class SendFormToManagerTest extends BaseTestForEmployee {
    private final int numberOfAddedObjectives = 3;

    @Test
    public void sendFormToManager() throws Exception {
        sqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, "committed");
        sqlQueries.addEmployeeComment();

        commonPage.openFormTab();
        formTabPage.sendFormToManager();
        Assert.assertEquals(USER_FORMS_STATUS_COMMITTED, sqlQueries.select("status", "user_forms", "user_id", EPTESTER_1_ID));
        sqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_IN_PROGRESS);
    }
}