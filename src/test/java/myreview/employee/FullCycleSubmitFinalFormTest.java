package myreview.employee;

import core.Configuration;
import core.Postcondition;
import core.PreconditionBuilder;
import helpers.SqlQueries;
import myreview.BaseTest;
import org.testng.annotations.Test;
import pages.DepartmentPage;
import pages.FormTabPage;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.testng.Assert.assertEquals;


public class FullCycleSubmitFinalFormTest extends BaseTest {
    private SqlQueries sqlQueries = new SqlQueries();
    private FormTabPage formTabPage = new FormTabPage();
    private Postcondition postcondition = new Postcondition();
    private DepartmentPage departmentPage = new DepartmentPage();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String currentDate = simpleDateFormat.format(new Date());
    private PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    @Test
    public void fullCycleSubmitFinalFormTest() throws Exception {
        preconditionBuilder.loginAs(Configuration.getInstance().getATester1())
                .delete("user_form_history", "user_id", "=", Configuration.getInstance().getATester1Id(), "appointment_date", currentDate).build();

        formTabPage.sendFormToManagerManualy();
        assertEquals(Configuration.getInstance().getCommitted(), sqlQueries.select("status", "user_forms", "user_id", Configuration.getInstance().getATester1Id()));

        postcondition.logout();
        preconditionBuilder.justLogIn(Configuration.getInstance().getATesterDm());

        departmentPage.approveFormManually();
        assertEquals(Configuration.getInstance().getApproved(), sqlQueries.select("status", "user_forms", "user_id", Configuration.getInstance().getATester1Id()));

        departmentPage.clickElementSetPageIndexCheckElementIsDisplayed(departmentPage.startMeetingButton, 2, departmentPage.evaluationByEmployee);
        departmentPage.submitFormManually();
        assertEquals(Configuration.getInstance().getInProgress(), sqlQueries.select("status", "user_forms", "user_id", Configuration.getInstance().getATester1Id()));
    }
}
