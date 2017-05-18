package myreview.dmTests;

import myreview.BaseTestForDm;
import org.junit.Assert;
import org.junit.Test;

public class NotificationForDmTest extends BaseTestForDm {
    private final String notificationMessageText = "1";

    @Test
    public void checkNotificationForDm() throws Exception {
        sqlQueries.changeStatusOfUserForm(sqlQueries.USER_FORMS_STATUS_COMMITTED);

        Assert.assertEquals(notificationMessageText,departmentPage.getTextFromElement(departmentPage.notificationForDmField));

        sqlQueries.changeStatusOfUserForm(sqlQueries.USER_FORMS_STATUS_IN_PROGRESS);
    }
}