package myreview.employee;

import core.Configuration;
import core.Postcondition;
import core.PreconditionBuilder;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.FormTabPage;

public class ClearButtonTest extends BaseTest {
    private String EpTester1 = Configuration.getInstance().getATester1();
    private SqlQueries sqlQueries = new SqlQueries();
    private FormTabPage formTabPage = new FormTabPage();
    private Postcondition postcondition = new Postcondition();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void checkClearButtonTest() throws Exception {
        preconditionBuilder
                .loginAs(EpTester1)
                .build();

        formTabPage.clearEvaluationByEmployee();
        Assert.assertEquals(null, sqlQueries.selectSelfRating());

       // postcondition.logout();
    }
}
