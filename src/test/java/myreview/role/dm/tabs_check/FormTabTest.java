package myreview.role.dm.tabs_check;

import core.Configuration;
import core.Preconditions;
import myreview.BaseTest;
import org.junit.Test;
import pages.BasePage;
import pages.CommonPage;
import pages.FormTabPage;

public class FormTabTest extends BaseTest {
    private CommonPage commonPage = new CommonPage();
    private FormTabPage formTabPage = new FormTabPage();
    private Preconditions preconditions = new Preconditions();
    private BasePage basePage = new BasePage();


    @Test
    public void formTabTest() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptesterdm());

        basePage.waitForElementIsClickableAndClick(commonPage.formButton);
        basePage.checkElementIsDisplayed(formTabPage.formTabContent);

        preconditions.postcondition();
    }
}
