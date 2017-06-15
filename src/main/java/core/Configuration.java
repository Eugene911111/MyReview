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
    private String aAdmin;
    private String aTester1;
    private String aTesterDm;
    private String aTester1Id;
    private String aDelivery1;
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
            this.aTester1 = prop.getProperty("A_TESTER_1");
            this.aTesterDm = prop.getProperty("A_TESTER_DM");
            this.aAdmin = prop.getProperty("EP_ADMIN");
            this.aTester1Id = prop.getProperty("A_TESTER_1_ID");
            this.aDelivery1 = prop.getProperty("A_DELIVERY_1");
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
        return aAdmin;
    }

    public String getATester1() {
        return aTester1;
    }

    public String getATesterDm() {
        return aTesterDm;
    }

    public String getADelivery1() {
        return aDelivery1;
    }

    public String getMyreviewDbUrl() {
        return myreviewDbUrl;
    }

    public String getATester1Id() {
        return aTester1Id;
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