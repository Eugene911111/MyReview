package myreview.employee.check_presence_of_element;

import core.Configuration;
import core.PreconditionBuilder;
import myreview.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AboutMyReviewPage;
import pages.BasePage;
import pages.CommonPage;

public class AboutMyReviewTest extends BaseTest {

    private BasePage basePage = new BasePage();
    private CommonPage commonPage = new CommonPage();
    private AboutMyReviewPage aboutMyReviewPage = new AboutMyReviewPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void checkAboutMyReview() throws Exception {
        preconditionBuilder
                .justLogIn(Configuration.getInstance().getATester1())
                .build();

        commonPage.openAboutMyReviewPage();
        Assert.assertTrue(basePage.checkElementIsDisplayed(aboutMyReviewPage.aboutMyReviewContent));
    }
}