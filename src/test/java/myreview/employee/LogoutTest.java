package myreview.employee;

import core.Configuration;
import core.Postcondition;
import core.PreconditionBuilder;
import myreview.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {
    private BasePage basePage = new BasePage();
    private LoginPage loginPage = new LoginPage();
    private Postcondition postcondition = new Postcondition();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void logout() throws Exception {
        preconditionBuilder.justLogIn(Configuration.getInstance().getATester1()).build();

        postcondition.logout();
        Assert.assertTrue(basePage.checkElementIsDisplayed(loginPage.logInFormName));
    }
}
