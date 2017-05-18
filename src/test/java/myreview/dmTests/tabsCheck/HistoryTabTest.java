package myreview.dmTests.tabsCheck;

import myreview.BaseTestForDm;
import org.junit.Test;

public class HistoryTabTest extends BaseTestForDm {
    @Test
    public void historyTabTest() throws InterruptedException {
        commonPage.waitForElementIsClickableAndClick(commonPage.historyButton);
        historyPage.checkElementIsDisplayed(historyPage.historyContent);
    }
}