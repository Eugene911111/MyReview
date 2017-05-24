package myreview.role.dm;

import core.Preconditions;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.DepartmentPage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static core.Configuration.*;

public class HistoryTest extends BaseTest {
    private DepartmentPage departmentPage = new DepartmentPage();
    private SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd MMMMMM yyyy", Locale.ENGLISH);
    private String currentDate1 = simpleDateFormat1.format(new Date());
    private int numberOfAddedObjectives = 3;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String currentDate = simpleDateFormat.format(new Date());
    private String appointment_date = "appointment_date";
    private Preconditions preconditions = new Preconditions();
    @Test
    public void history() throws Exception {
        preconditions.precondition(EPTESTERDM);

        SqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, "approved");
        SqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_APPRAISAL);
        SqlQueries.delete("user_form_history", "user_id", "=", EPTESTER_1_ID, "appointment_date", currentDate);

        departmentPage.submitForm();
        Assert.assertEquals(currentDate, SqlQueries.sewewewewlecewrwewewewewewt(appointment_date));

        preconditions.postcondition();
    }
}