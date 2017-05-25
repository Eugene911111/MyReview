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
    private String EPTESTER_1_ID;
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
            this.password = prop.getProperty("password");
            this.epadmin = prop.getProperty("ep-admin");
            this.eptester1 = prop.getProperty("eptester1");
            this.eptesterdm = prop.getProperty("eptesterdm");
            this.epdelivery1 = prop.getProperty("epdelivery1");
            this.myreviewdburl = prop.getProperty("myreviewdburl");
            this.EPTESTER_1_ID = prop.getProperty("EPTESTER_1_ID");
            this.myReviewDbUserName = prop.getProperty("myReviewDbUserName");
            this.myReviewDbUserPassword = prop.getProperty("myReviewDbUserPassword");
            this.approved = prop.getProperty("approved");
            this.appraisal = prop.getProperty("appraisal");
            this.committed = prop.getProperty("committed");
            this.inProgress = prop.getProperty("in_progress");
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

    public String getEPTESTER_1_ID() {
        return EPTESTER_1_ID;
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