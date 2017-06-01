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

public class HistoryTest extends BaseTest {
    private int numberOfAddedObjectives = 3;
    private String appointment_date = "appointment_date";
    private SqlQueries sqlQueries = new SqlQueries();
    private DepartmentPage departmentPage = new DepartmentPage();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String currentDate = simpleDateFormat.format(new Date());
    private Postcondition postcondition = new Postcondition();
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void history() throws Exception {
        preconditionBuilder
                .loginAs(Configuration.getInstance().getEpTesterDm())
                .addNoteToSettingObjectiveDB(numberOfAddedObjectives, Configuration.getInstance().getApproved())
                .changeStatusOfUserForm(Configuration.getInstance().getAppraisal())
                .delete("user_form_history", "user_id", "=", Configuration.getInstance().getEpTester1Id(), "appointment_date", currentDate);

        departmentPage.submitForm();
        Assert.assertEquals(currentDate, sqlQueries.select(appointment_date));

        postcondition.logout();
    }
}