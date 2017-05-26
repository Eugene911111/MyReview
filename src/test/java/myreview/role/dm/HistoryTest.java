package myreview.role.dm;

import core.Configuration;
import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.DepartmentPage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoryTest extends BaseTest {
    private int numberOfAddedObjectives = 3;
    private DepartmentPage departmentPage = new DepartmentPage();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String currentDate = simpleDateFormat.format(new Date());
    private String appointment_date = "appointment_date";
    private Preconditions preconditions = new Preconditions();
    private SqlQueries sqlQueries = new SqlQueries();
    @Test
    public void history() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptesterdm());

        SqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, "approved");
        SqlQueries.changeStatusOfUserForm(Configuration.getInstance().getAppraisal());
        SqlQueries.delete("user_form_history", "user_id", "=", Configuration.getInstance().getEpTester1Id(), "appointment_date", currentDate);

        departmentPage.submitForm();
        Assert.assertEquals(currentDate, SqlQueries.sewewewewlecewrwewewewewewt(appointment_date));
        preconditions.postcondition();
    }
}