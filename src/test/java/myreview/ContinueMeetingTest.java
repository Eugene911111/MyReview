package myreview;

import org.junit.Ignore;
import org.junit.Test;

import static helpers.sqlQueries.USER_FORMS_STATUS_APPROVED;

public class ContinueMeetingTest extends BaseTestForDm {
    private int numberOfAddedObjectives = 3;
@Ignore
    @Test
    public void continueMeeting() throws Exception {
        sqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, "committed");
        sqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_APPROVED);

        departmentPage.continueMeeting();
    }
}