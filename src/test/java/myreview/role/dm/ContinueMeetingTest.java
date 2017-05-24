package myreview.role.dm;

import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Test;
import pages.DepartmentPage;

import static core.Configuration.EPTESTERDM;
import static core.Configuration.USER_FORMS_STATUS_APPROVED;

public class ContinueMeetingTest extends BaseTest {

    private int numberOfAddedObjectives = 3;
    private Preconditions preconditions = new Preconditions();
    private DepartmentPage departmentPage = new DepartmentPage();

    @Test
    public void continueMeeting() throws Exception {
        preconditions.precondition(EPTESTERDM);

        SqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, "committed");
        SqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_APPROVED);

        departmentPage.continueMeeting();
        preconditions.postcondition();
    }
}