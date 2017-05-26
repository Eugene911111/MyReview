package myreview.role.dm.tabs_check;

import core.Configuration;
import core.Preconditions;
import myreview.BaseTest;
import org.junit.Test;
import pages.BasePage;
import pages.CommonPage;
import pages.HistoryPage;

public class HistoryTabTest extends BaseTest {

    private CommonPage commonPage = new CommonPage();
    private HistoryPage historyPage = new HistoryPage();
    private Preconditions preconditions = new Preconditions();
    private BasePage basePage = new BasePage();

    @Test
    public void historyTabTest() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptesterdm());

        basePage.waitForElementIsClickableAndClick(commonPage.historyButton);
        basePage.checkElementIsDisplayed(historyPage.historyContent);

        preconditions.postcondition();
    }
}