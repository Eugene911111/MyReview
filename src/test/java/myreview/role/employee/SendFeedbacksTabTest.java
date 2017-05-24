package myreview.role.employee;

import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.BasePage;
import pages.CommonPage;
import pages.FeedbackDialogWindowPage;
import pages.NoteTabPage;

import static core.Configuration.EPTESTER_1;
import static core.Configuration.EPTESTER_1_ID;

public class SendFeedbacksTabTest extends BaseTest {
    private CommonPage commonPage = new CommonPage();
    private FeedbackDialogWindowPage feedbackDialogWindowPage = new FeedbackDialogWindowPage();
    private Preconditions preconditions = new Preconditions();
    private NoteTabPage noteTabPage = new NoteTabPage();

    @Test
    public void sendFeedbackTest() throws Exception {
        preconditions.precondition(EPTESTER_1);

        commonPage.openFeedbackDialogWindow();
        Assert.assertTrue(BasePage.checkElementIsDisplayed(noteTabPage.feedbackDialogWindow));

        feedbackDialogWindowPage.sendFeedback();
        Assert.assertEquals(FeedbackDialogWindowPage.currentDate, SqlQueries.select("feedbacks", "comment", FeedbackDialogWindowPage.currentDate));

        SqlQueries.delete("notifications", "user_from_id", "=", EPTESTER_1_ID);
        SqlQueries.delete("feedbacks", "comment", "=", FeedbackDialogWindowPage.currentDate, "author_id", EPTESTER_1_ID);

        preconditions.postcondition();
    }
}

