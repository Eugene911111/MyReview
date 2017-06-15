package myreview.department_manager.tabs_check;

import core.Configuration;
import core.Postcondition;
import core.PreconditionBuilder;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.BasePage;
import pages.CommonPage;
import pages.HistoryPage;

public class HistoryTabTest extends BaseTest {

    private BasePage basePage = new BasePage();
    private CommonPage commonPage = new CommonPage();
    private HistoryPage historyPage = new HistoryPage();
    private Postcondition postcondition = new Postcondition();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void historyTabTest() throws Exception {
        preconditionBuilder.justLogIn(Configuration.getInstance().getATesterDm());

        basePage.waitForElementIsClickableAndClick(commonPage.historyButton);
        Assert.assertTrue(basePage.checkElementIsDisplayed(historyPage.historyContent));

        postcondition.logout();
    }
}