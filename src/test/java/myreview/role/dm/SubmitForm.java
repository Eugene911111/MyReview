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

public class SubmitForm extends BaseTest {
    private int numberOfAddedObjectives = 3;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String currentDate = simpleDateFormat.format(new Date());
    private Preconditions preconditions = new Preconditions();
    private DepartmentPage departmentPage = new DepartmentPage();


    @Test
    public void submitForm() throws Exception {
        preconditions.logInAs(Configuration.getInstance().getEptesterdm());
        SqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, "approved");
        SqlQueries.changeStatusOfUserForm(Configuration.getInstance().getAppraisal());
        SqlQueries.delete("user_form_history", "user_id", "=", Configuration.getInstance().getEpTester1Id(), "appointment_date", currentDate);

        departmentPage.submitForm();
        Assert.assertEquals(Configuration.getInstance().getInProgress(), SqlQueries.select("status", "user_forms", "user_id", Configuration.getInstance().getEpTester1Id()));

        preconditions.postcondition();
    }
}