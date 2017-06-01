package myreview.role.dm.tabs_check;

import core.Configuration;
import core.Postcondition;
import core.PreconditionBuilder;
import myreview.BaseTest;
import org.junit.Test;
import pages.BasePage;
import pages.CommonPage;
import pages.FormTabPage;

public class FormTabTest extends BaseTest {

    private BasePage basePage = new BasePage();
    private CommonPage commonPage = new CommonPage();
    private FormTabPage formTabPage = new FormTabPage();
    private Postcondition postcondition = new Postcondition();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void formTabTest() throws Exception {
        preconditionBuilder.loginAs(Configuration.getInstance().getEpTesterDm());

        basePage.waitForElementIsClickableAndClick(commonPage.formButton);
        basePage.checkElementIsDisplayed(formTabPage.formTabContent);

        postcondition.logout();
    }
}
