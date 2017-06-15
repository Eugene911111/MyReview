package myreview.employee.check_presence_of_element;

import core.Configuration;
import core.Postcondition;
import core.PreconditionBuilder;
import myreview.BaseTest;
import pages.NoteTabPage;
import pages.CommonPage;
import org.junit.Assert;
import pages.BasePage;
import org.junit.Test;

public class FormExampleTest extends BaseTest {

    private BasePage basePage = new BasePage();
    private CommonPage commonPage = new CommonPage();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private Postcondition postcondition = new Postcondition();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void checkFormExample() throws Exception {
        preconditionBuilder
                .justLogIn(Configuration.getInstance().getATester1())
                .build();

        commonPage.openFormExamplePage();
        Assert.assertTrue(basePage.checkElementIsDisplayed(noteTabPage.formExampleImg));

        //postcondition.logout();
    }
}