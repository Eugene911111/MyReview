package myreview.role.dm.tabs_check;

import core.Configuration;
import core.Preconditions;
import myreview.BaseTest;
import org.junit.Test;
import pages.CommonPage;
import pages.DepartmentPage;

import static pages.BasePage.checkElementIsDisplayed;
import static pages.BasePage.waitForElementIsClickableAndClick;

public class DepartmentTabTest extends BaseTest {
    private CommonPage commonPage = new CommonPage();
    private Preconditions preconditions = new Preconditions();
    private DepartmentPage departmentPage = new DepartmentPage();

    @Test
    public void departmentTabTest() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptesterdm());

        waitForElementIsClickableAndClick(commonPage.departmentButton);
        checkElementIsDisplayed(departmentPage.departmentTabContent);

        preconditions.postcondition();
    }
}