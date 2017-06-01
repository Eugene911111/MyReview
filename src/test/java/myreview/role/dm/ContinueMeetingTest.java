package myreview.role.dm;

import core.Configuration;
import core.PreconditionBuilder;
import core.Postcondition;
import myreview.BaseTest;
import org.junit.Test;
import pages.DepartmentPage;

public class ContinueMeetingTest extends BaseTest {

    private int numberOfAddedObjectives = 3;
    private Postcondition postcondition = new Postcondition();
    private DepartmentPage departmentPage = new DepartmentPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void continueMeeting() throws Exception {
        preconditionBuilder.loginAs(Configuration.getInstance().getEpTesterDm())
                .addNoteToSettingObjectiveDB(numberOfAddedObjectives, "committed")
                .changeStatusOfUserForm(Configuration.getInstance().getApproved());

        departmentPage.continueMeeting();

        postcondition.logout();
    }
}