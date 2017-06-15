package myreview.employee;

import core.Configuration;
import core.Postcondition;
import core.PreconditionBuilder;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.FormTabPage;

public class SendFormToManagerTest extends BaseTest {

    private int numberOfAddedObjectives = 3;
    private SqlQueries sqlQueries = new SqlQueries();
    private FormTabPage formTabPage = new FormTabPage();
    private Postcondition postcondition = new Postcondition();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void sendFormToManager() throws Exception {
        preconditionBuilder
                .loginAs(Configuration.getInstance().getATester1())
                .addNoteToSettingObjectiveDB(numberOfAddedObjectives, Configuration.getInstance().getCommitted())
                .addEmployeeComment()
                .build();

        formTabPage.sendFormToManager();
        Assert.assertEquals(Configuration.getInstance().getCommitted(), sqlQueries.select("status", "user_forms", "user_id", Configuration.getInstance().getATester1Id()));

       // postcondition.logout();
    }
}