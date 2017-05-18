package myreview.dmTests.tabsCheck;

import myreview.BaseTestForDm;
import org.junit.Test;

public class DepartmentTabTest extends BaseTestForDm {

    @Test
    public void departmentTabTest() throws InterruptedException {
        commonPage.waitForElementIsClickableAndClick(commonPage.departmentButton);
        departmentPage.checkElementIsDisplayed(departmentPage.departmentTabContent);
    }
}
