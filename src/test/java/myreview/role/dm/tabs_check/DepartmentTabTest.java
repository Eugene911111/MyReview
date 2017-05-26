package myreview.role.dm.tabs_check;

import core.Configuration;
import core.Preconditions;
import myreview.BaseTest;
import org.junit.Test;
import pages.BasePage;
import pages.CommonPage;
import pages.DepartmentPage;


public class DepartmentTabTest extends BaseTest {
    private CommonPage commonPage = new CommonPage();
    private Preconditions preconditions = new Preconditions();
    private DepartmentPage departmentPage = new DepartmentPage();
    private BasePage basePage = new BasePage();
    @Test
    public void departmentTabTest() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptesterdm());

        basePage.waitForElementIsClickableAndClick(commonPage.departmentButton);
        basePage.checkElementIsDisplayed(departmentPage.departmentTabContent);

        preconditions.postcondition();
    }
}