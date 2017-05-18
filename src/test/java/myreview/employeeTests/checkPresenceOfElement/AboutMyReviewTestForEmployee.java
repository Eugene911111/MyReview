package myreview.employeeTests.checkPresenceOfElement;

import myreview.BaseTestForEmployee;
import org.junit.Assert;
import org.junit.Test;

public class AboutMyReviewTestForEmployee extends BaseTestForEmployee {

    @Test
    public void checkAboutMyReview() throws Exception {
        commonPage.openAboutMyReviewPage();
        Assert.assertTrue(noteTabPage.checkElementIsDisplayed(aboutMyReviewPage.aboutMyReviewContent));
    }
}