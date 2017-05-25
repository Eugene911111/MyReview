package myreview.role.dm.tabs_check;

import core.Configuration;
import core.Preconditions;
import myreview.BaseTest;
import org.junit.Test;
import pages.CommonPage;
import pages.HistoryPage;

import static pages.BasePage.checkElementIsDisplayed;
import static pages.BasePage.waitForElementIsClickableAndClick;

public class HistoryTabTest extends BaseTest {

    private CommonPage commonPage = new CommonPage();
    private HistoryPage historyPage = new HistoryPage();
    private Preconditions preconditions = new Preconditions();

    @Test
    public void historyTabTest() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptesterdm());

        waitForElementIsClickableAndClick(commonPage.historyButton);
        checkElementIsDisplayed(historyPage.historyContent);

        preconditions.postcondition();
    }
}