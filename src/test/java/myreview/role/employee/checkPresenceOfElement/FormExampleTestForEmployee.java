package myreview.role.employee.checkPresenceOfElement;

import core.Preconditions;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.BasePage;
import pages.CommonPage;
import pages.NoteTabPage;

import static core.Configuration.EPTESTER_1;

public class FormExampleTestForEmployee extends BaseTest {
    private Preconditions preconditions = new Preconditions();
    private CommonPage commonPage = new CommonPage();
    private NoteTabPage noteTabPage = new NoteTabPage();
    @Test
    public void checkFormExample() throws Exception {
        preconditions.precondition(EPTESTER_1);

        commonPage.openFormExamplePage();
        Assert.assertTrue(BasePage.checkElementIsDisplayed(noteTabPage.formExampleImg));

        preconditions.postcondition();
    }
}