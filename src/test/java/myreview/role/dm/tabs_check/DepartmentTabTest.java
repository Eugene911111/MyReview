package myreview.role.dm.tabs_check;

import core.Preconditions;
import myreview.BaseTest;
import org.junit.Test;
import pages.CommonPage;
import pages.DepartmentPage;

import static core.Configuration.EPTESTERDM;
import static pages.BasePage.checkElementIsDisplayed;
import static pages.BasePage.waitForElementIsClickableAndClick;

public class DepartmentTabTest extends BaseTest {
    private CommonPage commonPage = new CommonPage();
    private DepartmentPage departmentPage = new DepartmentPage();
    private Preconditions preconditions = new Preconditions();

    @Test
    public void departmentTabTest() throws Exception {
        preconditions.precondition(EPTESTERDM);

        waitForElementIsClickableAndClick(commonPage.departmentButton);
        checkElementIsDisplayed(departmentPage.departmentTabContent);

        preconditions.postcondition();
    }
}