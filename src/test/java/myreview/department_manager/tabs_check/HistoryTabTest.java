package myreview.department_manager.tabs_check;

import core.PreconditionBuilder;
import myreview.BaseTest;
import myreview.Data;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CommonPage;
import pages.HistoryPage;

public class HistoryTabTest extends BaseTest {
    private BasePage basePage = new BasePage();
    private CommonPage commonPage = new CommonPage();
    private HistoryPage historyPage = new HistoryPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test(dataProvider = "all_users", dataProviderClass = Data.class)
    public void historyTabTest(String userName) throws Exception {
        preconditionBuilder.justLogIn(userName);

        basePage.waitForElementIsClickableAndClick(commonPage.historyButton);
        Assert.assertTrue(basePage.checkElementIsDisplayed(historyPage.historyContent));
    }
}