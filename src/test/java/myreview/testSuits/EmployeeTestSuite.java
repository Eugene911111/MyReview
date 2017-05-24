package myreview.testSuits;

import myreview.role.employee.SendFeedbacksTabTest;
import myreview.role.employee.SendFormToManagerTest;
import myreview.role.employee.actionsWithObjectives.*;
import myreview.role.employee.checkPresenceOfElement.AboutMyReviewTestForEmployee;
import myreview.role.employee.checkPresenceOfElement.FormExampleTestForEmployee;
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
        SendFeedbacksTabTest.class,
        SendFormToManagerTest.class,
        AboutMyReviewTestForEmployee.class,
        FormExampleTestForEmployee.class
})

public class EmployeeTestSuite {
}
