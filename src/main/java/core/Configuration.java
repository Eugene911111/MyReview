package core;

import pages.BasePage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private BasePage basePage = new BasePage();
    private String password;
    private String epadmin;
    private String eptester1;
    private String eptesterdm;
    private String epdelivery1;
    private String myreviewdburl;
    private String epTester1Id;
    private String myReviewDbUserName;
    private String myReviewDbUserPassword;
    private String approved;
    private String appraisal;
    private String committed;
    private String inProgress;
    private int timeOut;

    private Configuration() {
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
            this.password = prop.getProperty("PASSWORD");
            this.epadmin = prop.getProperty("EP_ADMIN");
            this.eptester1 = prop.getProperty("EP_TESTER_1");
            this.eptesterdm = prop.getProperty("EP_TESTER_DM");
            this.epdelivery1 = prop.getProperty("EP_DELIVERY_1");
            this.myreviewdburl = prop.getProperty("MY_REVIEW_DB_URL");
            this.epTester1Id = prop.getProperty("EP_TESTER_1_ID");
            this.myReviewDbUserName = prop.getProperty("DB_USERNAME");
            this.myReviewDbUserPassword = prop.getProperty("DB_USER_PASSWORD");
            this.approved = prop.getProperty("APPROVED");
            this.appraisal = prop.getProperty("APPRAISAL");
            this.committed = prop.getProperty("COMMITTED");
            this.inProgress = prop.getProperty("IN_PROGRESS");
            this.timeOut = Integer.parseInt(prop.getProperty("TIME_OUT"));
        } catch (IOException ex) {
            basePage.log.error("Error. Can't read property file. " + ex.toString());
        }
    }

    public int getTimeOut() {
        return timeOut;
    }

    public String getPassword() {
        return password;
    }

    public String getEpadmin() {
        return epadmin;
    }

    public String getEptester1() {
        return eptester1;
    }

    public String getEptesterdm() {
        return eptesterdm;
    }

    public String getEpdelivery1() {
        return epdelivery1;
    }

    public String getMyreviewdburl() {
        return myreviewdburl;
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
}