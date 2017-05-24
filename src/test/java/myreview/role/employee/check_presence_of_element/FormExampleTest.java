package myreview.role.employee.check_presence_of_element;

import core.Preconditions;
import myreview.BaseTest;
import pages.NoteTabPage;
import pages.CommonPage;
import org.junit.Assert;
import pages.BasePage;
import org.junit.Test;

import static core.Configuration.EPTESTER_1;

public class FormExampleTest extends BaseTest {

    private CommonPage commonPage = new CommonPage();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private Preconditions preconditions = new Preconditions();

    @Test
    public void checkFormExample() throws Exception {
        preconditions.precondition(EPTESTER_1);

        commonPage.openFormExamplePage();
        Assert.assertTrue(BasePage.checkElementIsDisplayed(noteTabPage.formExampleImg));

        preconditions.postcondition();
    }
}