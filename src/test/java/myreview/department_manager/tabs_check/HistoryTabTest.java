package myreview.department_manager.tabs_check;

import core.Configuration;
import core.PreconditionBuilder;
import myreview.BaseTest;
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

    @Test
    public void historyTabTest() throws Exception {
        preconditionBuilder.justLogIn(Configuration.getInstance().getATesterDm());

        basePage.waitForElementIsClickableAndClick(commonPage.historyButton);
        Assert.assertTrue(basePage.checkElementIsDisplayed(historyPage.historyContent));
    }
}