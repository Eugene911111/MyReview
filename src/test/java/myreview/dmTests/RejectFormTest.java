package myreview.dmTests;

import myreview.BaseTestForDm;
import org.junit.Assert;
import org.junit.Test;

import static helpers.sqlQueries.EPTESTER_1_ID;
import static helpers.sqlQueries.USER_FORMS_STATUS_IN_PROGRESS;

public class RejectFormTest extends BaseTestForDm {
    private final int numberOfObjectivesToAdd = 3;

    @Test
    public void rejectFormTest() throws Exception {
        sqlQueries.addNoteToSettingObjectiveDB(numberOfObjectivesToAdd, "committed");
        sqlQueries.changeStatusOfUserForm1(sqlQueries.USER_FORMS_STATUS_COMMITTED);

        departmentPage.rejectForm();
        Assert.assertEquals(USER_FORMS_STATUS_IN_PROGRESS, sqlQueries.select("status", "user_forms", "user_id", EPTESTER_1_ID));

        //checking text of reject reason as employee
        noteTabPage.logOut();
        loginPage.logIn(loginPage.EPTESTER_1);
        formTabPage.openUrl(formTabPage.formTabURL);
        Assert.assertEquals(departmentPage.currentDate, formTabPage.getTextFromElement(formTabPage.rejectReasonField));
    }
}
