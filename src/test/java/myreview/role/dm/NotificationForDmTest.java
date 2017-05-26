package myreview.role.dm;

import core.Configuration;
import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.BasePage;
import pages.DepartmentPage;

public class NotificationForDmTest extends BaseTest {
    private String notificationMessageText = "1";
    private BasePage basePage = new BasePage();
    private Preconditions preconditions = new Preconditions();
    private DepartmentPage departmentPage = new DepartmentPage();

    @Test
    public void checkNotificationIsDisplayed() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptesterdm());
        SqlQueries.changeStatusOfUserForm(Configuration.getInstance().getCommitted());

        Assert.assertEquals(notificationMessageText, basePage.getTextFromElement(departmentPage.notificationForDmField));

        preconditions.postcondition();
    }

    @Test
    public void checkNotificationIsNotDisplayed() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptesterdm());
        SqlQueries.changeStatusOfUserForm(Configuration.getInstance().getInProgress());

        Assert.assertEquals(true, departmentPage.notificationIsNotDisplayed());

        preconditions.postcondition();
    }
}