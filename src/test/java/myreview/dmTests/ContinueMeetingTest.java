package myreview.dmTests;

import myreview.BaseTestForDm;
import org.junit.Test;

import static core.Configuration.USER_FORMS_STATUS_APPROVED;

public class ContinueMeetingTest extends BaseTestForDm {
    private int numberOfAddedObjectives = 3;

    @Test
    public void continueMeeting() throws Exception {
        sqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, "committed");
        sqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_APPROVED);

        departmentPage.continueMeeting();
    }
}