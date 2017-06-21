package myreview.department_manager;

import core.Configuration;
import core.PreconditionBuilder;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.testng.annotations.Test;
import pages.DepartmentPage;

import static org.testng.Assert.assertEquals;


public class ApproveFormTest extends BaseTest {

    private int numberOfAddedObjectives = 3;
    private SqlQueries sqlQueries = new SqlQueries();
    private DepartmentPage departmentPage = new DepartmentPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void approveForm() throws Exception {
        preconditionBuilder
                .loginAs(Configuration.getInstance().getATesterDm())
                .addNoteToSettingObjectiveDB(numberOfAddedObjectives, Configuration.getInstance().getCommitted())
                .changeStatusOfUserForm(Configuration.getInstance().getCommitted());

        departmentPage.approveForm();
        assertEquals(Configuration.getInstance().getApproved(), sqlQueries.select("status", "user_forms", "user_id", Configuration.getInstance().getATester1Id()));
    }
}