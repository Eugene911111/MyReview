package myreview.dmTests.tabsCheck;

import myreview.BaseTestForDm;
import org.junit.Test;

public class FormTabTest extends BaseTestForDm {

    @Test
    public void formTabTest() throws InterruptedException{
        commonPage.waitForElementIsClickableAndClick(commonPage.formButton);
        formTabPage.checkElementIsDisplayed(formTabPage.formTabContent);
    }
}
