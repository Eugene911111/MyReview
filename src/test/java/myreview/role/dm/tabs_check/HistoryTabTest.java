package myreview.role.dm.tabs_check;

import core.Configuration;
import core.Postcondition;
import core.PreconditionBuilder;
import myreview.BaseTest;
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
        preconditionBuilder.loginAs(Configuration.getInstance().getEpTesterDm());

        basePage.waitForElementIsClickableAndClick(commonPage.historyButton);
        basePage.checkElementIsDisplayed(historyPage.historyContent);

        postcondition.logout();
    }
}