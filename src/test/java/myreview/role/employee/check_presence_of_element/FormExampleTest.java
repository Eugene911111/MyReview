package myreview.role.employee.check_presence_of_element;

import core.Configuration;
import core.Preconditions;
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
    private Preconditions preconditions = new Preconditions();

    @Test
    public void checkFormExample() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptester1());

        commonPage.openFormExamplePage();
        Assert.assertTrue(basePage.checkElementIsDisplayed(noteTabPage.formExampleImg));

        preconditions.postcondition();
    }
}