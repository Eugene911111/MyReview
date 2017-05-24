package myreview.role.dm.tabs_check;

import core.Preconditions;
import myreview.BaseTest;
import org.junit.Test;
import pages.CommonPage;
import pages.FormTabPage;

import static core.Configuration.EPTESTERDM;
import static pages.BasePage.checkElementIsDisplayed;
import static pages.BasePage.waitForElementIsClickableAndClick;

public class FormTabTest extends BaseTest {
    private CommonPage commonPage = new CommonPage();
    private Preconditions preconditions = new Preconditions();
    private FormTabPage formTabPage = new FormTabPage();


    @Test
    public void formTabTest() throws Exception {
        preconditions.precondition(EPTESTERDM);

        waitForElementIsClickableAndClick(commonPage.formButton);
        checkElementIsDisplayed(formTabPage.formTabContent);

        preconditions.postcondition();
    }
}
