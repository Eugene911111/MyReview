package pages;

import org.openqa.selenium.By;

import static core.Configuration.PASSWORD;

public class LoginPage extends BasePage {
    private By emailLogInField = By.id("username");
    private By passwordLogInField = By.id("password");
    private By loginButton = By.xpath("//div[@class=\"form-group form-group-logon\"]//input[@value=\"Login\"]");
    public static String loginPageUrl = "http://myreview.local/app_dev.php/login";
    public By logInFormName = By.xpath("//div[@class=\"panel-heading\"][contains(., 'Log In')]");
    public By levi9Logo = By.xpath("//img[@src=\"/bundles/app/images/logo.png\"]");

    public void logIn(String userName) throws InterruptedException {
        openUrl(loginPageUrl);
        checkElementIsDisplayed(levi9Logo);
        checkElementIsDisplayed(logInFormName);
        findElementAndSendKeys(emailLogInField, userName);
        findElementAndSendKeys(passwordLogInField, PASSWORD);
        waitForElementIsClickableAndClick(loginButton);
    }
}
