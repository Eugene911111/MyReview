package myreview.department_manager;

import core.Configuration;
import core.Postcondition;
import core.PreconditionBuilder;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.*;

public class RejectFormTest extends BaseTest {
    private int numberOfObjectivesToAdd = 3;
    private LoginPage loginPage = new LoginPage();
    private CommonPage commonPage = new CommonPage();
    private SqlQueries sqlQueries = new SqlQueries();
    private FormTabPage formTabPage = new FormTabPage();
    private Postcondition postcondition = new Postcondition();
    private DepartmentPage departmentPage = new DepartmentPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void rejectFormTest() throws Exception {
        preconditionBuilder
                .loginAs(Configuration.getInstance().getATesterDm())
                .addNoteToSettingObjectiveDB(numberOfObjectivesToAdd, Configuration.getInstance().getCommitted())
                .changeStatusOfUserForm(Configuration.getInstance().getCommitted())
                .build();

        departmentPage.rejectForm();
        Assert.assertEquals(Configuration.getInstance().getInProgress(), sqlQueries.select("status", "user_forms", "user_id", Configuration.getInstance().getATester1Id()));

        commonPage.logOut();
        loginPage.logIn(Configuration.getInstance().getATester1());
        commonPage.openUrl(Configuration.getInstance().getFormTabUrl());
        Assert.assertEquals(departmentPage.currentDate, formTabPage.getTextFromElement(formTabPage.rejectReasonField));

      //  postcondition.logout();
    }
}