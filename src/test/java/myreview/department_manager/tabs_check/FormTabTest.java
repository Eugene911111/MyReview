package myreview.department_manager.tabs_check;

import core.Configuration;
import core.Postcondition;
import core.PreconditionBuilder;
import myreview.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
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
        preconditionBuilder.justLogIn(Configuration.getInstance().getATesterDm());

        basePage.waitForElementIsClickableAndClick(commonPage.formButton);
        Assert.assertTrue(basePage.checkElementIsDisplayed(formTabPage.formTabContent));
    }
}
