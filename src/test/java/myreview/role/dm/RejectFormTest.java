package myreview.role.dm;

import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.*;

import static core.Configuration.*;
import static pages.CommonPage.formTabUrl;

public class RejectFormTest extends BaseTest {
    private int numberOfObjectivesToAdd = 3;
    private Preconditions preconditions = new Preconditions();
    private LoginPage loginPage = new LoginPage();
    private CommonPage commonPage = new CommonPage();
    private DepartmentPage departmentPage = new DepartmentPage();
    private FormTabPage formTabPage = new FormTabPage();
    @Test
    public void rejectFormTest() throws Exception {
        preconditions.precondition(EPTESTERDM);

        SqlQueries.addNoteToSettingObjectiveDB(numberOfObjectivesToAdd, "committed");
        SqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_COMMITTED);

        departmentPage.rejectForm();
        Assert.assertEquals(USER_FORMS_STATUS_IN_PROGRESS, SqlQueries.select("status", "user_forms", "user_id", EPTESTER_1_ID));

        commonPage.logOut();
        loginPage.logIn(EPTESTER_1);
        BasePage.openUrl(formTabUrl);
        Assert.assertEquals(DepartmentPage.currentDate, FormTabPage.getTextFromElement(formTabPage.rejectReasonField));

        preconditions.postcondition();
    }
}
