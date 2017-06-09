package myreview.role.dm;

import core.Configuration;
import core.PreconditionBuilder;
import core.Postcondition;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Test;
import pages.DepartmentPage;

import static org.junit.Assert.assertEquals;

public class ContinueMeetingTest extends BaseTest {

    private int numberOfAddedObjectives = 3;
    private SqlQueries sqlQueries = new SqlQueries();
    private Postcondition postcondition = new Postcondition();
    private DepartmentPage departmentPage = new DepartmentPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void continueMeeting() throws Exception {
        preconditionBuilder.loginAs(Configuration.getInstance().getEpTesterDm())
                .addNoteToSettingObjectiveDB(numberOfAddedObjectives, "committed")
                .changeStatusOfUserForm(Configuration.getInstance().getApproved());

        departmentPage.continueMeeting();
        assertEquals(Configuration.getInstance().getAppraisal(), sqlQueries.select("status", "user_forms", "user_id", Configuration.getInstance().getEpTester1Id()));

        postcondition.logout();
    }
}