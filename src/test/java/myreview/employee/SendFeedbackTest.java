package myreview.employee;

import core.Configuration;
import core.PreconditionBuilder;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CommonPage;
import pages.FeedbackDialogWindowPage;
import pages.NoteTabPage;

public class SendFeedbackTest extends BaseTest {

    private BasePage basePage = new BasePage();
    private CommonPage commonPage = new CommonPage();
    private SqlQueries sqlQueries = new SqlQueries();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();
    private FeedbackDialogWindowPage feedbackDialogWindowPage = new FeedbackDialogWindowPage();

    @Test
    public void sendFeedbackTest() throws Exception {
        preconditionBuilder
                .justLogIn(Configuration.getInstance().getATester1())
                .build();

        commonPage.openFeedbackDialogWindow();
        Assert.assertTrue(basePage.checkElementIsDisplayed(noteTabPage.feedbackDialogWindow));

        feedbackDialogWindowPage.sendFeedback();
        Assert.assertEquals(basePage.currentDate, sqlQueries.select("feedbacks", "comment", basePage.currentDate));

        sqlQueries.delete("notifications", "user_from_id", "=", Configuration.getInstance().getATester1());
        sqlQueries.delete("feedbacks", "comment", "=", basePage.currentDate, "author_id", Configuration.getInstance().getATester1());
    }
}

