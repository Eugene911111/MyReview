package myreview.role.dm;

import core.Configuration;
import core.Postcondition;
import core.PreconditionBuilder;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.DepartmentPage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SubmitForm extends BaseTest {
    private int numberOfAddedObjectives = 3;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String currentDate = simpleDateFormat.format(new Date());
    private SqlQueries sqlQueries = new SqlQueries();
    private Postcondition postcondition = new Postcondition();
    private DepartmentPage departmentPage = new DepartmentPage();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void submitForm() throws Exception {
        preconditionBuilder.loginAs(Configuration.getInstance().getEpTesterDm())
                .addNoteToSettingObjectiveDB(numberOfAddedObjectives, Configuration.getInstance().getApproved())
                .changeStatusOfUserForm(Configuration.getInstance().getAppraisal())
                .delete("user_form_history", "user_id", "=", Configuration.getInstance().getEpTester1Id(), "appointment_date", currentDate)
                .build();

        departmentPage.submitForm();
        Assert.assertEquals(Configuration.getInstance().getInProgress(), sqlQueries.select("status", "user_forms", "user_id", Configuration.getInstance().getEpTester1Id()));

        postcondition.logout();
    }
}