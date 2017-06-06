package myreview.role.dm;

import core.Configuration;
import core.Postcondition;
import core.PreconditionBuilder;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.BasePage;
import pages.DepartmentPage;

public class NotificationForDmTest extends BaseTest {
    private String notificationMessageText = "1";
    private BasePage basePage = new BasePage();
    private Postcondition postcondition = new Postcondition();
    private DepartmentPage departmentPage = new DepartmentPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void checkNotificationIsDisplayed() throws Exception {
        preconditionBuilder.loginAs(Configuration.getInstance().getEpTesterDm())
                .changeStatusOfUserForm(Configuration.getInstance().getCommitted())
                .build();

        Assert.assertEquals(notificationMessageText, basePage.getTextFromElement(departmentPage.notificationForDmField));

        postcondition.logout();
    }

    @Test
    public void checkNotificationIsNotDisplayed() throws Exception {
        preconditionBuilder.loginAs(Configuration.getInstance().getEpTesterDm())
                .changeStatusOfUserForm(Configuration.getInstance().getInProgress())
                .build();

        Assert.assertEquals(true, departmentPage.notificationIsNotDisplayed());

        postcondition.logout();
    }
}