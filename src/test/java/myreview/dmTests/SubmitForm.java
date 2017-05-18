package myreview.dmTests;

import myreview.BaseTestForDm;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static core.Configuration.*;

public class SubmitForm extends BaseTestForDm {
    private int numberOfAddedObjectives = 3;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String currentDate = simpleDateFormat.format(new Date());

    @Test
    public void subDmitForm() throws Exception {
        sqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, "approved");
        sqlQueries.changeStatusOfUserForm1(USER_FORMS_STATUS_APPRAISAL);
        sqlQueries.delete("user_form_history", "user_id", "=", EPTESTER_1_ID, "appointment_date", currentDate);

        departmentPage.submitForm();
        Assert.assertEquals(USER_FORMS_STATUS_IN_PROGRESS, sqlQueries.select("status", "user_forms", "user_id", EPTESTER_1_ID));
        sqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_IN_PROGRESS);
    }
}