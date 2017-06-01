package core;

import pages.BasePage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private BasePage basePage = new BasePage();
    private String departmentTabUrl;
    private String appraisal;
    private String approved;
    private String committed;
    private String epAdmin;
    private String epTester1;
    private String epTesterDm;
    private String epTester1Id;
    private String epDelivery1;
    private String inProgress;
    private String logInPageUrl;
    private String myreviewDbUrl;
    private String myReviewDbUserName;
    private String myReviewDbUserPassword;
    private String password;
    private String formTabUrl;
    private String notesTabUrl;
    private String reviewMeetingUrl;
    private int timeOut;

    public Configuration() {
        readFromPropertyFile();
    }

    private static class SingletonHelper {

        private static final Configuration INSTANCE = new Configuration();

    }

    public static Configuration getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private void readFromPropertyFile() {
        try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            this.appraisal = prop.getProperty("APPRAISAL");
            this.approved = prop.getProperty("APPROVED");
            this.committed = prop.getProperty("COMMITTED");
            this.departmentTabUrl = prop.getProperty("DEPARTMENT_TAB_URL");
            this.epTester1 = prop.getProperty("EP_TESTER_1");
            this.epTesterDm = prop.getProperty("EP_TESTER_DM");
            this.epAdmin = prop.getProperty("EP_ADMIN");
            this.epTester1Id = prop.getProperty("EP_TESTER_1_ID");
            this.epDelivery1 = prop.getProperty("EP_DELIVERY_1");
            this.formTabUrl = prop.getProperty("FORM_TAB_URL");
            this.inProgress = prop.getProperty("IN_PROGRESS");
            this.logInPageUrl = prop.getProperty("LOGIN_PAGE_URL");
            this.myreviewDbUrl = prop.getProperty("MY_REVIEW_DB_URL");
            this.myReviewDbUserName = prop.getProperty("DB_USERNAME");
            this.myReviewDbUserPassword = prop.getProperty("DB_USER_PASSWORD");
            this.password = prop.getProperty("PASSWORD");
            this.timeOut = Integer.parseInt(prop.getProperty("TIME_OUT"));
            this.reviewMeetingUrl = prop.getProperty("REVIEW_MEETING_URL");
            this.notesTabUrl = prop.getProperty("NOTES_TAB_URL");
        } catch (IOException ex) {
            basePage.log.error("Error. Can't read property file. " + ex.toString());
        }
    }

    public String getNotesTabUrl() {
        return notesTabUrl;
    }

    public String getReviewMeetingUrl() {
        return reviewMeetingUrl;
    }

    public String getFormTabUrl() {
        return formTabUrl;
    }

    public String getLogInPageUrl() {
        return logInPageUrl;
    }

    public String getDepartmentTabUrl() {
        return departmentTabUrl;
    }

    public String getPassword() {
        return password;
    }

    public String getEpAdmin() {
        return epAdmin;
    }

    public String getEpTester1() {
        return epTester1;
    }

    public String getEpTesterDm() {
        return epTesterDm;
    }

    public String getEpDelivery1() {
        return epDelivery1;
    }

    public String getMyreviewDbUrl() {
        return myreviewDbUrl;
    }

    public String getEpTester1Id() {
        return epTester1Id;
    }

    public String getMyReviewDbUserName() {
        return myReviewDbUserName;
    }

    public String getMyReviewDbUserPassword() {
        return myReviewDbUserPassword;
    }

    public String getApproved() {
        return approved;
    }

    public String getAppraisal() {
        return appraisal;
    }

    public String getCommitted() {
        return committed;
    }

    public String getInProgress() {
        return inProgress;
    }

    public int getTimeOut() {
        return timeOut;
    }
}