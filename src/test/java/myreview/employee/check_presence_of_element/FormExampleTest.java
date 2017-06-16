package myreview.employee.check_presence_of_element;

import core.Configuration;
import core.PreconditionBuilder;
import myreview.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CommonPage;
import pages.NoteTabPage;

public class FormExampleTest extends BaseTest {

    private BasePage basePage = new BasePage();
    private CommonPage commonPage = new CommonPage();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void checkFormExample() throws Exception {
        preconditionBuilder
                .justLogIn(Configuration.getInstance().getATester1())
                .build();

        commonPage.openFormExamplePage();
        Assert.assertTrue(basePage.checkElementIsDisplayed(noteTabPage.formExampleImg));
    }
}