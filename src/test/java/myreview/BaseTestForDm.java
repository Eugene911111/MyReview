package myreview;

import helpers.sqlQueries;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.*;

import java.io.File;
import java.io.IOException;

import static core.Configuration.BROWSER_NAME_CHROME;
import static helpers.sqlQueries.DELETE_GOALS_BY_ID;
import static helpers.sqlQueries.DELETE_USER_BY_ID;
import static pages.LoginPage.EPTESTERDM;

public class BaseTestForDm {
    public WebDriver driver;
    public LoginPage loginPage;
    public NoteTabPage noteTabPage;
    public FormTabPage formTabPage;
    public FeedbackDialogWindowPage feedbackDialogWindowPage;
    public FeedbackAdminPage feedbacksAdminPage;
    public AboutMyReviewPage aboutMyReviewPage;
    public CommonPage commonPage;
    public FormExamplePage formExamplePage;
    protected DepartmentPage departmentPage;
    public HistoryPage historyPage;
    public sqlQueries sqlQueries;
    private static ChromeDriverService service;
    private static final String PATH_TO_CHROMEDRIVER_EXE = "C:\\Users\\y.holub\\IdeaProjects\\chromedriver\\chromedriver.exe";

    @BeforeClass
    public static void createAndStartService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(PATH_TO_CHROMEDRIVER_EXE))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @AfterClass
    public static void createAndStopService() {
        service.stop();
    }

    @Before
    public void precondition() throws InterruptedException {
        if (BROWSER_NAME_CHROME == "chrome") {
            driver = new RemoteWebDriver(service.getUrl(),
                    DesiredCapabilities.chrome());
        }
        (loginPage = new LoginPage()).setDriver(driver);
        (noteTabPage = new NoteTabPage()).setDriver(driver);
        (feedbackDialogWindowPage = new FeedbackDialogWindowPage()).setDriver(driver);
        (feedbacksAdminPage = new FeedbackAdminPage()).setDriver(driver);
        (formTabPage = new FormTabPage()).setDriver(driver);
        (aboutMyReviewPage = new AboutMyReviewPage()).setDriver(driver);
        (commonPage = new CommonPage()).setDriver(driver);
        (formExamplePage = new FormExamplePage()).setDriver(driver);
        (departmentPage = new DepartmentPage()).setDriver(driver);
        (sqlQueries = new sqlQueries()).setDriver(driver);
        (historyPage = new HistoryPage()).setDriver(driver);

        loginPage.logIn(EPTESTERDM);
    }

    @After
    public void testShutDown() throws Exception {
        sqlQueries.delete1(DELETE_USER_BY_ID);
        sqlQueries.deleteGoalById(DELETE_GOALS_BY_ID);
        noteTabPage.logOut();
        driver.close();

    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}