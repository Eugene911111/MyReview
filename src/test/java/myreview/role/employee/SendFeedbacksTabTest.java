package myreview.role.employee;

import core.Configuration;
import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.BasePage;
import pages.CommonPage;
import pages.FeedbackDialogWindowPage;
import pages.NoteTabPage;

public class SendFeedbacksTabTest extends BaseTest {

    private BasePage basePage = new BasePage();
    private CommonPage commonPage = new CommonPage();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private Preconditions preconditions = new Preconditions();
    private FeedbackDialogWindowPage feedbackDialogWindowPage = new FeedbackDialogWindowPage();

    @Test
    public void sendFeedbackTest() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptester1());

        commonPage.openFeedbackDialogWindow();
        Assert.assertTrue(basePage.checkElementIsDisplayed(noteTabPage.feedbackDialogWindow));

        feedbackDialogWindowPage.sendFeedback();
        Assert.assertEquals(basePage.currentDate, SqlQueries.select("feedbacks", "comment", basePage.currentDate));

        SqlQueries.delete("notifications", "user_from_id", "=", Configuration.getInstance().getEptester1());
        SqlQueries.delete("feedbacks", "comment", "=", basePage.currentDate, "author_id",  Configuration.getInstance().getEptester1());

        preconditions.postcondition();
    }
}

