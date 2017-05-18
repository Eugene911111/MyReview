package myreview;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static helpers.sqlQueries.EPTESTER_1_ID;
import static helpers.sqlQueries.USER_FORMS_STATUS_APPRAISAL;
import static helpers.sqlQueries.USER_FORMS_STATUS_IN_PROGRESS;

public class HistoryTest extends BaseTestForDm {
    private SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd MMMMMM yyyy", Locale.ENGLISH);
    private String currentDate1 = simpleDateFormat1.format(new Date());
    private int numberOfAddedObjectives = 3;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String currentDate = simpleDateFormat.format(new Date());

    @Test
    public void history() throws Exception {
        sqlQueries.addNoteToSettingObjectiveDB(numberOfAddedObjectives, "approved");
        sqlQueries.changeStatusOfUserForm1(USER_FORMS_STATUS_APPRAISAL);
        sqlQueries.delete("user_form_history", "user_id", "=", EPTESTER_1_ID, "appointment_date", currentDate);

        departmentPage.submitForm();
        Assert.assertEquals(currentDate, sqlQueries.select("appointment_date", "user_form_history", "user_id", EPTESTER_1_ID));
        sqlQueries.changeStatusOfUserForm(USER_FORMS_STATUS_IN_PROGRESS);


//        departmentPage.openUrl("http://myreview.local/app_dev.php/#/history/644E3D87-E5EC-4274-8B26-EF76C5537E93");
//        Thread.sleep(2000);
//        String getextFromHistory = departmentPage.getTextFromElement(By.xpath("/html/body/div/history/div[1]/div/uib-accordion/div/div[2]"));
//        String currentDate = getextFromHistory.split(" ", 3)[2];
//        Assert.assertEquals(currentDate1, currentDate);
    }
}