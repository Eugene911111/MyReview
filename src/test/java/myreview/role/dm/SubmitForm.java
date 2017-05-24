package myreview.role.dm;

import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.DepartmentPage;

import java.text.SimpleDateFormat;
import java.util.Date;

import static core.Configuration.*;

public class SubmitForm extends BaseTest {
    private int numberOfAddedObjectives = 3;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String currentDate = simpleDateFormat.format(new Date());
    private Preconditions preconditions = new Preconditions();
    private DepartmentPage departmentPage = new DepartmentPage();


    @Test
    public void submitForm() throws Exception {
        preconditions.precondition(EPTESTERDM);
        SqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, "approved");
        SqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_APPRAISAL);
        SqlQueries.delete("user_form_history", "user_id", "=", EPTESTER_1_ID, "appointment_date", currentDate);

        departmentPage.submitForm();
        Assert.assertEquals(USER_FORMS_STATUS_IN_PROGRESS, SqlQueries.select("status", "user_forms", "user_id", EPTESTER_1_ID));

        preconditions.postcondition();
    }
}