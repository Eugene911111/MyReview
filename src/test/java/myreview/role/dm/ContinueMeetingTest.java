package myreview.role.dm;

import core.Configuration;
import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Test;
import pages.DepartmentPage;


public class ContinueMeetingTest extends BaseTest {

    private int numberOfAddedObjectives = 3;
    private Preconditions preconditions = new Preconditions();
    private DepartmentPage departmentPage = new DepartmentPage();

    @Test
    public void continueMeeting() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptesterdm());

        SqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, "committed");
        SqlQueries.changeStatusOfUserForm(Configuration.getInstance().getApproved());

        departmentPage.continueMeeting();
        preconditions.postcondition();
    }
}