package pages;

import core.Configuration;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By levi9Logo = By.xpath("//img[@src=\"/bundles/app/images/logo.png\"]");
    private By loginButton = By.xpath("//div[@class=\"form-group form-group-logon\"]//input[@value=\"Login\"]");
    private By passwordField = By.id("password");
    private By usernameField = By.id("username");
    private String loginPageUrl = "http://myreview.local/app_dev.php/login";
    static By logInFormName = By.xpath("//div[@class=\"panel-heading\"][contains(., 'Log In')]");

    public void logIn(String userName) throws Exception {
        openUrl(loginPageUrl);
        checkElementIsDisplayed(levi9Logo);
        checkElementIsDisplayed(logInFormName);
        findElementAndSendKeys(usernameField, userName);
        findElementAndSendKeys(passwordField, Configuration.getInstance().getPassword());
        waitForElementIsClickableAndClick(loginButton);
    }
}
