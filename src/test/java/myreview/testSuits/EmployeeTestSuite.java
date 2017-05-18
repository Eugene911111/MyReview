package myreview.testSuits;

import myreview.employeeTests.SendFeedbackTest;
import myreview.employeeTests.SendFormToManagerTest;
import myreview.employeeTests.actionsWithObjectives.*;
import myreview.employeeTests.checkPresenceOfElement.AboutMyReviewTestForEmployee;
import myreview.employeeTests.checkPresenceOfElement.FormExampleTestForEmployee;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;



@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddingObjectiveOnNotesTabTest.class,
        AddObjectiveOnFormTabTest.class,
        AddObjectiveToFormTest.class,
        CheckQuantityOfObjectivesTest.class,
        DeleteObjectiveOnNoteTabTest.class,
        EditObjectiveOnNoteTabTest.class,
        ImportFromNotesToFormTestForEmployee.class,
        SendFeedbackTest.class,
        SendFormToManagerTest.class,
        AboutMyReviewTestForEmployee.class,
        FormExampleTestForEmployee.class
})

public class EmployeeTestSuite {
}
