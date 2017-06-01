package myreview.role.dm;

import core.Configuration;
import core.Postcondition;
import core.PreconditionBuilder;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Test;
import pages.DepartmentPage;

import static org.junit.Assert.assertEquals;

public class ApproveFormTest extends BaseTest {

    private int numberOfAddedObjectives = 3;
    private SqlQueries sqlQueries = new SqlQueries();
    private Postcondition postcondition = new Postcondition();
    private DepartmentPage departmentPage = new DepartmentPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void approveForm() throws Exception {
        preconditionBuilder
                .loginAs(Configuration.getInstance().getEpTesterDm())
                .addNoteToSettingObjectiveDB(numberOfAddedObjectives, Configuration.getInstance().getCommitted())
                .changeStatusOfUserForm(Configuration.getInstance().getCommitted());

        departmentPage.approveForm();
        assertEquals(Configuration.getInstance().getApproved(), sqlQueries.select("status", "user_forms", "user_id", "644E3D87-E5EC-4274-8B26-EF76C5537E93"));

        postcondition.logout();
    }
}