package myreview.role.dm;

import core.Configuration;
import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Test;
import pages.DepartmentPage;

import static org.junit.Assert.assertEquals;

public class ApproveFormTest extends BaseTest {

    private int numberOfAddedObjectives = 3;
    private Preconditions preconditions = new Preconditions();
    private DepartmentPage departmentPage = new DepartmentPage();

    @Test
    public void approveForm() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptesterdm());
        SqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, Configuration.getInstance().getCommitted());
        SqlQueries.changeStatusOfUserForm(Configuration.getInstance().getCommitted());

        departmentPage.approveForm();
        assertEquals(Configuration.getInstance().getApproved(), SqlQueries.select("status", "user_forms", "user_id", "644E3D87-E5EC-4274-8B26-EF76C5537E93"));

        preconditions.postcondition();
    }
}