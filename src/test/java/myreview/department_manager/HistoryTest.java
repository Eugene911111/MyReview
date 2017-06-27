package myreview.department_manager;

import core.Configuration;
import core.Postcondition;
import core.PreconditionBuilder;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

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
    private BasePage basePage = new BasePage();
    private CommonPage commonPage = new CommonPage();
    private LoginPage loginPage = new LoginPage();
    private HistoryPage historyPage = new HistoryPage();

    @Test
    public void history() throws Exception {
        preconditionBuilder
                .loginAs(Configuration.getInstance().getATesterDm())
                .addNoteToSettingObjectiveDB(numberOfAddedObjectives, Configuration.getInstance().getApproved())
                .changeStatusOfUserForm(Configuration.getInstance().getAppraisal())
                .delete("user_form_history", "user_id", "=", Configuration.getInstance().getATester1Id(), "appointment_date", currentDate);

        departmentPage.submitForm();
        Assert.assertEquals(currentDate, sqlQueries.select(appointment_date));
        postcondition.logout();

        loginPage.logIn(Configuration.getInstance().getATester1());
        basePage.waitForElementIsClickableAndClick(commonPage.historyButton);
//TODO
        historyPage.checkThatItISPossibleToOpenAndCloseInformationAboutMeeting();
        Assert.assertTrue(basePage.checkElementIsDisplayed(By.xpath("//div[@aria-expanded='true']//div[@class='previewReviewThin'][contains(., 'Overall')]")));
    }
}