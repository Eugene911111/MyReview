package myreview.testSuits;

import myreview.dmTests.*;
import myreview.dmTests.tabsCheck.DepartmentTabTest;
import myreview.dmTests.tabsCheck.FormTabTest;
import myreview.dmTests.tabsCheck.HistoryTabTest;
import myreview.dmTests.tabsCheck.NotesTabTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        ApproveFormTest.class,
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