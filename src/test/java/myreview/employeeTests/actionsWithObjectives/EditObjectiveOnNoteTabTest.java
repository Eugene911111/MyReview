package myreview.employeeTests.actionsWithObjectives;

import myreview.BaseTestForEmployee;
import org.junit.Assert;
import org.junit.Test;

public class EditObjectiveOnNoteTabTest extends BaseTestForEmployee {
    private int numberOfNotesToAdd = 1;

    @Test
    public void checkEditOfTheObjective() throws Exception {
        sqlQueries.insert(numberOfNotesToAdd);

        noteTabPage.editObjective(noteTabPage.titleAfterEdit, noteTabPage.commentAfterEdit);
        // UI check
        Assert.assertEquals(noteTabPage.getTextFromElement(noteTabPage.lastTitleInList), noteTabPage.titleAfterEdit);
        // DB check
        Assert.assertEquals((sqlQueries.select("goals", "title", noteTabPage.titleAfterEdit)), noteTabPage.titleAfterEdit);
    }
}