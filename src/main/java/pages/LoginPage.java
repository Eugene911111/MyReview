package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By emailLogInField = By.id("username");
    private final By passwordLogInField = By.id("password");
    private final By loginButton = By.xpath("//div[@class=\"form-group form-group-logon\"]//input[@value=\"Login\"]");
    public static String loginPageUrl = "http://myreview.local/app_dev.php/login";
    // public String loginPageUrl = "http://ep-ubuntu-test.levi9.com/app_dev.php/login";
    public final By logInFormName = By.xpath("//div[@class=\"panel-heading\"][contains(., 'Log In')]");
    public final By levi9Logo = By.xpath("//img[@src=\"/bundles/app/images/logo.png\"]");
    public static final String EPTESTER_1 = "eptester1";
    public static final String EPTESTERDM = "eptesterdm";
    public static final String EP_ADMIN = "ep-admin";
    public String epdelivery1 = "epdelivery1";
    public static final String PASSWORD = "Levi9Pro";

    public void logIn(String userName) throws InterruptedException {
        openUrl(loginPageUrl);
        checkElementIsDisplayed(levi9Logo);
        checkElementIsDisplayed(logInFormName);
        findElementAndSendKeys(emailLogInField, userName);
        findElementAndSendKeys(passwordLogInField, PASSWORD);
        waitForElementIsClickableAndClick(loginButton);
    }
}
