package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    static By logInFormName = By.xpath("//div[@class=\"panel-heading\"][contains(., 'Log In')]");
    private By levi9Logo = By.xpath("//img[@src=\"/bundles/app/images/logo.png\"]");
    private By loginButton = By.xpath("//div[@class=\"form-group form-group-logon\"]//input[@value=\"Login\"]");
    private String loginPageUrl = "http://myreview.local/app_dev.php/login";
    private String password = "Levi9Pro";

    public void logIn(String userName) throws InterruptedException {
        openUrl(loginPageUrl);
        checkElementIsDisplayed(levi9Logo);
        checkElementIsDisplayed(logInFormName);
        findElementAndSendKeys(usernameField, userName);
        findElementAndSendKeys(passwordField, password);
        waitForElementIsClickableAndClick(loginButton);
    }
}
