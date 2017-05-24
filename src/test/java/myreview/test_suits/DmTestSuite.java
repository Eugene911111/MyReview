package myreview.test_suits;

import myreview.role.dm.*;
import myreview.role.dm.tabs_check.DepartmentTabTest;
import myreview.role.dm.tabs_check.FormTabTest;
import myreview.role.dm.tabs_check.HistoryTabTest;
import myreview.role.dm.tabs_check.NotesTabTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ApproveFormTest.class,
        ContinueMeetingTest.class,
        HistoryTest.class,
        NotificationForDmTest.class,
        RejectFormTest.class,
        StartMeeting.class,
        SubmitForm.class,
        DepartmentTabTest.class,
        FormTabTest.class,
        HistoryTabTest.class,
        NotesTabTest.class
})

public class DmTestSuite {
}