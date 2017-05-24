package myreview.role.employee.check_presence_of_element;

import pages.AboutMyReviewPage;
import core.Preconditions;
import myreview.BaseTest;
import pages.NoteTabPage;
import org.junit.Assert;
import pages.CommonPage;
import org.junit.Test;

import static core.Configuration.EPTESTER_1;

public class AboutMyReviewTest extends BaseTest {

    private CommonPage commonPage = new CommonPage();
    private Preconditions preconditions = new Preconditions();
    private AboutMyReviewPage aboutMyReviewPage = new AboutMyReviewPage();

    @Test
    public void checkAboutMyReview() throws Exception {
        preconditions.precondition(EPTESTER_1);

        commonPage.openAboutMyReviewPage();
        Assert.assertTrue(NoteTabPage.checkElementIsDisplayed(aboutMyReviewPage.aboutMyReviewContent));

        preconditions.postcondition();
    }
}