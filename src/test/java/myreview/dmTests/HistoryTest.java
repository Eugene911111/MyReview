package myreview.dmTests;

import myreview.BaseTestForDm;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static core.Configuration.EPTESTER_1_ID;
import static core.Configuration.USER_FORMS_STATUS_APPRAISAL;
import static core.Configuration.USER_FORMS_STATUS_IN_PROGRESS;


public class HistoryTest extends BaseTestForDm {
    private SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd MMMMMM yyyy", Locale.ENGLISH);
    private String currentDate1 = simpleDateFormat1.format(new Date());
    private int numberOfAddedObjectives = 3;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String currentDate = simpleDateFormat.format(new Date());
    private String appointment_date = "appointment_date";

    @Test
    public void history() throws Exception {
        sqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, "approved");
        sqlQueries.changeStatusOfUserForm1(USER_FORMS_STATUS_APPRAISAL);
        sqlQueries.delete("user_form_history", "user_id", "=", EPTESTER_1_ID, "appointment_date", currentDate);

        departmentPage.submitForm();
        Assert.assertEquals(currentDate, sqlQueries.sewewewewlecewrwewewewewewt(appointment_date));

        sqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_IN_PROGRESS);
    }
}