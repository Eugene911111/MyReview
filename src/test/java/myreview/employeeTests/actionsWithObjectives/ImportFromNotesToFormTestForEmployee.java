package myreview.employeeTests.actionsWithObjectives;

import myreview.BaseTestForEmployee;
import org.junit.Assert;
import org.junit.Test;

public class ImportFromNotesToFormTestForEmployee extends BaseTestForEmployee {
    private int numberOfNotedToAdd = 1;
    private String expectedTitle = "autoTestTitle";

    @Test
    public void importFromNotesToFormTest() throws Exception {
        sqlQueries.insert(numberOfNotedToAdd);

        commonPage.openUrl(noteTabPage.formTabUrl);
        formTabPage.pressImportFromNotesButton();
        Assert.assertEquals(expectedTitle, noteTabPage.getTextFromElement(noteTabPage.lastObjectiveTitleInList));
    }
}