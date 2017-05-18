package myreview.dmTests.tabsCheck;

import myreview.BaseTestForDm;
import org.junit.Test;

public class NotesTabTest extends BaseTestForDm {

    @Test
    public void notesTabTest() throws InterruptedException{
        commonPage.waitForElementIsClickableAndClick(commonPage.notesButton);
        noteTabPage.checkElementIsDisplayed(noteTabPage.notesPageContent);
    }
}
