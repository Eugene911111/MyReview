package pages;

import org.openqa.selenium.By;

import static core.Configuration.PASSWORD;

public class LoginPage extends BasePage {
    private final By emailLogInField = By.id("username");
    private final By passwordLogInField = By.id("password");
    private final By loginButton = By.xpath("//div[@class=\"form-group form-group-logon\"]//input[@value=\"Login\"]");
    public static String loginPageUrl = "http://myreview.local/app_dev.php/login";
    // public String loginPageUrl = "http://ep-ubuntu-test.levi9.com/app_dev.php/login";
    public final By logInFormName = By.xpath("//div[@class=\"panel-heading\"][contains(., 'Log In')]");
    public final By levi9Logo = By.xpath("//img[@src=\"/bundles/app/images/logo.png\"]");

    public void logIn(String userName) throws InterruptedException {
        openUrl(loginPageUrl);
        checkElementIsDisplayed(levi9Logo);
        checkElementIsDisplayed(logInFormName);
        findElementAndSendKeys(emailLogInField, userName);
        findElementAndSendKeys(passwordLogInField, PASSWORD);
        waitForElementIsClickableAndClick(loginButton);
    }
}
