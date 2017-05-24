package myreview.role.employee.checkPresenceOfElement;

import core.Preconditions;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.AboutMyReviewPage;
import pages.CommonPage;
import pages.NoteTabPage;

import static core.Configuration.EPTESTER_1;

public class AboutMyReviewTestForEmployee extends BaseTest {
    private Preconditions preconditions = new Preconditions();
    private CommonPage commonPage = new CommonPage();
    private AboutMyReviewPage aboutMyReviewPage = new AboutMyReviewPage();

    @Test
    public void checkAboutMyReview() throws Exception {
        preconditions.precondition(EPTESTER_1);

        commonPage.openAboutMyReviewPage();
        Assert.assertTrue(NoteTabPage.checkElementIsDisplayed(aboutMyReviewPage.aboutMyReviewContent));

        preconditions.postcondition();
    }
}