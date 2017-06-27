package myreview.department_manager.tabs_check;

import core.PreconditionBuilder;
import myreview.BaseTest;
import myreview.Data;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CommonPage;
import pages.FormTabPage;

public class FormTabTest extends BaseTest {
    private BasePage basePage = new BasePage();
    private CommonPage commonPage = new CommonPage();
    private FormTabPage formTabPage = new FormTabPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test(dataProvider = "all_users", dataProviderClass = Data.class)
    public void formTabTest(String useName) throws Exception {
        preconditionBuilder.justLogIn(useName);

        basePage.waitForElementIsClickableAndClick(commonPage.formButton);
        Assert.assertTrue(basePage.checkElementIsDisplayed(formTabPage.formTabContent));
    }
}
