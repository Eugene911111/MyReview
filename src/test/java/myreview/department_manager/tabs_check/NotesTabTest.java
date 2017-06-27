package myreview.department_manager.tabs_check;

import core.PreconditionBuilder;
import myreview.BaseTest;
import myreview.Data;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CommonPage;
import pages.NoteTabPage;

public class NotesTabTest extends BaseTest {

    private BasePage basePage = new BasePage();
    private CommonPage commonPage = new CommonPage();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test(dataProvider = "all_users", dataProviderClass = Data.class)
    public void notesTabTest(String userName) throws Exception {
        preconditionBuilder.justLogIn(userName);

        basePage.waitForElementIsClickableAndClick(commonPage.notesButton);
        Assert.assertTrue(basePage.checkElementIsDisplayed(noteTabPage.notesPageContent));
    }
}
