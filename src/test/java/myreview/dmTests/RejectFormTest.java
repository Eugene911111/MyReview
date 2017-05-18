package myreview.dmTests;

import myreview.BaseTestForDm;
import org.junit.Assert;
import org.junit.Test;

import static core.Configuration.*;
import static pages.CommonPage.formTabUrl;

public class RejectFormTest extends BaseTestForDm {
    private int numberOfObjectivesToAdd = 3;

    @Test
    public void rejectFormTest() throws Exception {
        sqlQueries.addNoteToSettingObjectiveDB(numberOfObjectivesToAdd, "committed");
        sqlQueries.changeStatusOfUserForm1(USER_FORMS_STATUS_COMMITTED);

        departmentPage.rejectForm();
        Assert.assertEquals(USER_FORMS_STATUS_IN_PROGRESS, sqlQueries.select("status", "user_forms", "user_id", EPTESTER_1_ID));

        //checking text of reject reason as employee
        commonPage.logOut();
        loginPage.logIn(EPTESTER_1);
        formTabPage.openUrl(formTabUrl);
        Assert.assertEquals(departmentPage.currentDate, formTabPage.getTextFromElement(formTabPage.rejectReasonField));
    }
}
