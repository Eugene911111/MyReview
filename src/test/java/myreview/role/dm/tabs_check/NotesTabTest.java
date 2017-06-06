package myreview.role.dm.tabs_check;

import core.Configuration;
import core.Postcondition;
import core.PreconditionBuilder;
import myreview.BaseTest;
import org.junit.Test;
import pages.BasePage;
import pages.CommonPage;
import pages.NoteTabPage;

public class NotesTabTest extends BaseTest {

    private BasePage basePage = new BasePage();
    private CommonPage commonPage = new CommonPage();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private Postcondition postcondition = new Postcondition();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void notesTabTest() throws Exception {
        preconditionBuilder.loginAs(Configuration.getInstance().getEpTesterDm());

        basePage.waitForElementIsClickableAndClick(commonPage.notesButton);
        basePage.checkElementIsDisplayed(noteTabPage.notesPageContent);

        postcondition.logout();
    }
}