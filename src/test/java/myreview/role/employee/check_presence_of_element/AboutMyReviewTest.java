package myreview.role.employee.check_presence_of_element;

import core.Configuration;
import core.Preconditions;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.AboutMyReviewPage;
import pages.BasePage;
import pages.CommonPage;

public class AboutMyReviewTest extends BaseTest {

    private BasePage basePage = new BasePage();
    private CommonPage commonPage = new CommonPage();
    private Preconditions preconditions = new Preconditions();
    private AboutMyReviewPage aboutMyReviewPage = new AboutMyReviewPage();

    @Test
    public void checkAboutMyReview() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptester1());

        commonPage.openAboutMyReviewPage();
        Assert.assertTrue(basePage.checkElementIsDisplayed(aboutMyReviewPage.aboutMyReviewContent));

        preconditions.postcondition();
    }
}