package myreview.role.dm.tabs_check;

import core.Configuration;
import core.Postcondition;
import core.PreconditionBuilder;
import myreview.BaseTest;
import org.junit.Test;
import pages.BasePage;
import pages.CommonPage;
import pages.DepartmentPage;

public class DepartmentTabTest extends BaseTest {

    private BasePage basePage = new BasePage();
    private CommonPage commonPage = new CommonPage();
    private Postcondition postcondition = new Postcondition();
    private DepartmentPage departmentPage = new DepartmentPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void departmentTabTest() throws Exception {
        preconditionBuilder.justLogIn(Configuration.getInstance().getEpTesterDm());

        basePage.waitForElementIsClickableAndClick(commonPage.departmentButton);
        basePage.checkElementIsDisplayed(departmentPage.departmentTabContent);

        postcondition.logout();
    }
}