package myreview.department_manager.tabs_check;

import core.PreconditionBuilder;
import myreview.BaseTest;
import myreview.Data;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CommonPage;
import pages.DepartmentPage;

public class DepartmentTabTest extends BaseTest {

    private BasePage basePage = new BasePage();
    private CommonPage commonPage = new CommonPage();
    private DepartmentPage departmentPage = new DepartmentPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test(dataProvider = "department_managers", dataProviderClass = Data.class)
    public void departmentTabTest(String userName) throws Exception {
        preconditionBuilder.justLogIn(userName);

        basePage.waitForElementIsClickableAndClick(commonPage.departmentButton);
        Assert.assertTrue(basePage.checkElementIsDisplayed(departmentPage.departmentTabContent));
    }
}