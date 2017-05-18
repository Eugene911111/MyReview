package myreview.employeeTests.checkPresenceOfElement;

import myreview.BaseTestForEmployee;
import org.junit.Assert;
import org.junit.Test;

public class FormExampleTestForEmployee extends BaseTestForEmployee {

    @Test
    public void checkFormExample() throws Exception {
        commonPage.openFormExamplePage();
        Assert.assertTrue(noteTabPage.checkElementIsDisplayed(noteTabPage.formExampleImg));
    }
}