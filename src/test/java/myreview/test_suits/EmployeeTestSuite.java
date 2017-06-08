package myreview.test_suits;

import myreview.role.employee.ClearButtonTest;
import myreview.role.employee.SendFeedbacksTabTest;
import myreview.role.employee.SendFormToManagerTest;
import myreview.role.employee.actions_with_objectives.*;
import myreview.role.employee.check_presence_of_element.AboutMyReviewTest;
import myreview.role.employee.check_presence_of_element.FormExampleTest;
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
        AboutMyReviewTest.class,
        FormExampleTest.class,
        ClearButtonTest.class
})

public class EmployeeTestSuite {
}
