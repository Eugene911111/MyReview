package myreview.role.dm;

import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.BasePage;
import pages.DepartmentPage;

import static core.Configuration.EPTESTERDM;
import static core.Configuration.USER_FORMS_STATUS_COMMITTED;

public class NotificationForDmTest extends BaseTest {
    private String notificationMessageText = "1";
    private Preconditions preconditions = new Preconditions();
    private DepartmentPage departmentPage = new DepartmentPage();

    @Test
    public void checkNotificationForDm() throws Exception {
        preconditions.precondition(EPTESTERDM);
        SqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_COMMITTED);

        Assert.assertEquals(notificationMessageText, BasePage.getTextFromElement(departmentPage.notificationForDmField));

        preconditions.postcondition();
    }
}