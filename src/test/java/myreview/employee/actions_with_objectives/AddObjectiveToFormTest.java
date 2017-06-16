package myreview.employee.actions_with_objectives;

import core.Configuration;
import core.PreconditionBuilder;
import myreview.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.NoteTabPage;

public class AddObjectiveToFormTest extends BaseTest {

    private int numberOfNotesToAdd = 1;
    private String expectedTitle = "autoTestTitle";
    private CommonPage commonPage = new CommonPage();
    private NoteTabPage noteTabPage = new NoteTabPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();


    @Test
    public void addToFormTest() throws Exception {
        preconditionBuilder
                .loginAs(Configuration.getInstance().getATester1())
                .insert(numberOfNotesToAdd)
                .build();

        noteTabPage.addToForm();
        commonPage.openFormTab();
        Assert.assertEquals(expectedTitle, noteTabPage.getTextFromElement(noteTabPage.lastObjectiveTitleInList));
    }
}