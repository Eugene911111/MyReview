package myreview.role.dm.tabs_check;

import core.Configuration;
import core.Preconditions;
import myreview.BaseTest;
import org.junit.Test;
import pages.BasePage;
import pages.CommonPage;
import pages.NoteTabPage;

public class NotesTabTest extends BaseTest {

    private CommonPage commonPage = new CommonPage();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private Preconditions preconditions = new Preconditions();
    private BasePage basePage = new BasePage();

    @Test
    public void notesTabTest() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptesterdm());

        basePage.waitForElementIsClickableAndClick(commonPage.notesButton);
        basePage.checkElementIsDisplayed(noteTabPage.notesPageContent);

        preconditions.postcondition();
    }
}
