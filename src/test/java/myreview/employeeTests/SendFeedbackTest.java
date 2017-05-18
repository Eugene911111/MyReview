package myreview.employeeTests;

import myreview.BaseTestForEmployee;
import org.junit.Assert;
import org.junit.Test;
import static helpers.sqlQueries.EPTESTER_1_ID;

public class SendFeedbackTest extends BaseTestForEmployee {

    @Test
    public void sendFeedbackTest() throws Exception {
        commonPage.openFeedbackDialogWindow();
        Assert.assertTrue(noteTabPage.checkElementIsDisplayed(noteTabPage.feedbackDialogWindow));

        feedbackDialogWindowPage.sendFeedback();
        Assert.assertEquals(feedbackDialogWindowPage.currentDate,sqlQueries.select("feedbacks", "comment", feedbackDialogWindowPage.currentDate));

        sqlQueries.delete("notifications", "user_from_id", "=", EPTESTER_1_ID);
        sqlQueries.delete("feedbacks", "comment", "=", feedbackDialogWindowPage.currentDate, "author_id", EPTESTER_1_ID);
    }
}

