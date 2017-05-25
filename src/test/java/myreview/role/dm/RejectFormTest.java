package myreview.role.dm;

import core.Configuration;
import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.*;

import static pages.CommonPage.formTabUrl;

public class RejectFormTest extends BaseTest {
    private int numberOfObjectivesToAdd = 3;
    private LoginPage loginPage = new LoginPage();
    private CommonPage commonPage = new CommonPage();
    private FormTabPage formTabPage = new FormTabPage();
    private Preconditions preconditions = new Preconditions();
    private DepartmentPage departmentPage = new DepartmentPage();

    @Test
    public void rejectFormTest() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptesterdm());

        SqlQueries.addNoteToSettingObjectiveDB(numberOfObjectivesToAdd, "committed");
        SqlQueries.changeStatusOfUserForm(Configuration.getInstance().getCommitted());

        departmentPage.rejectForm();
        Assert.assertEquals(Configuration.getInstance().getInProgress(), SqlQueries.select("status", "user_forms", "user_id", Configuration.getInstance().getEPTESTER_1_ID()));

        commonPage.logOut();
        loginPage.logIn(Configuration.getInstance().getEptester1());
        BasePage.openUrl(formTabUrl);
        Assert.assertEquals(DepartmentPage.currentDate, FormTabPage.getTextFromElement(formTabPage.rejectReasonField));

        preconditions.postcondition();
    }
}
