package myreview.role.employee;

import core.Configuration;
import core.Preconditions;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.FormTabPage;

import static helpers.SqlQueries.selectSelfRating;

public class CheckClearButtonTest extends BaseTest {
    private Preconditions preconditions = new Preconditions();
    private FormTabPage formTabPage = new FormTabPage();

    @Test
    public void checkClearButtonTest() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptester1());

        formTabPage.clearEvaluationByEmployee();
        Assert.assertEquals(null, selectSelfRating());

        preconditions.postcondition();
    }
}
