package myreview.role.employee;

import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import pages.FormTabPage;
import org.junit.Assert;
import pages.CommonPage;
import org.junit.Test;

import static core.Configuration.*;

public class SendFormToManagerTest extends BaseTest {

    private int numberOfAddedObjectives = 3;
    private CommonPage commonPage = new CommonPage();
    private FormTabPage formTabPage = new FormTabPage();
    private Preconditions preconditions = new Preconditions();

    @Test
    public void sendFormToManager() throws Exception {
        preconditions.precondition(EPTESTER_1);

        SqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, "committed");
        SqlQueries.addEmployeeComment();

        commonPage.openFormTab();
        formTabPage.sendFormToManager();
        Assert.assertEquals(USER_FORMS_STATUS_COMMITTED, SqlQueries.select("status", "user_forms", "user_id", EPTESTER_1_ID));
        SqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_IN_PROGRESS);

        preconditions.postcondition();
    }
}