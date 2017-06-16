package myreview.department_manager;

import core.Configuration;
import core.Postcondition;
import core.PreconditionBuilder;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CommonPage;
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
    private BasePage basePage = new BasePage();
    private CommonPage commonPage = new CommonPage();

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

        preconditionBuilder
                .justLogIn(Configuration.getInstance().getATester1());
        basePage.waitForElementIsClickableAndClick(commonPage.historyButton);
//TODO
        basePage.waitForElementIsClickableAndClick(By.xpath("//div[@class=\"paneHeader ng-scope\"]"));
        basePage.checkElementIsDisplayed(By.xpath("//*[@id=\"accordiongroup-137-8999-panel\"]/div/div[2]"));
        System.out.println("+ is pressed");
    }
}