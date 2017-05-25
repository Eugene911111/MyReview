package myreview.role.dm.tabs_check;

import core.Configuration;
import core.Preconditions;
import myreview.BaseTest;
import org.junit.Test;
import pages.CommonPage;
import pages.NoteTabPage;

import static pages.BasePage.checkElementIsDisplayed;
import static pages.BasePage.waitForElementIsClickableAndClick;

public class NotesTabTest extends BaseTest {

    private CommonPage commonPage = new CommonPage();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private Preconditions preconditions = new Preconditions();

    @Test
    public void notesTabTest() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptesterdm());

        waitForElementIsClickableAndClick(commonPage.notesButton);
        checkElementIsDisplayed(noteTabPage.notesPageContent);

        preconditions.postcondition();
    }
}
