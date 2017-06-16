package myreview.employee;

import core.Configuration;
import core.PreconditionBuilder;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormTabPage;

public class ClearButtonTest extends BaseTest {
    private String EpTester1 = Configuration.getInstance().getATester1();
    private SqlQueries sqlQueries = new SqlQueries();
    private FormTabPage formTabPage = new FormTabPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void checkClearButtonTest() throws Exception {
        preconditionBuilder
                .loginAs(EpTester1)
                .build();

        formTabPage.clearEvaluationByEmployee();
        Assert.assertEquals(null, sqlQueries.selectSelfRating());
    }
}
