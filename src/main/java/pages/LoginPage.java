package pages;

import org.openqa.selenium.By;

import static core.Configuration.PASSWORD;
import static pages.CommonPage.loginPageUrl;

public class LoginPage extends BasePage {
    private By emailField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//div[@class=\"form-group form-group-logon\"]//input[@value=\"Login\"]");
    public static By logInFormName = By.xpath("//div[@class=\"panel-heading\"][contains(., 'Log In')]");
    private By levi9Logo = By.xpath("//img[@src=\"/bundles/app/images/logo.png\"]");

    public void logIn(String userName) throws InterruptedException {
        openUrl(loginPageUrl);
        checkElementIsDisplayed(levi9Logo);
        checkElementIsDisplayed(logInFormName);
        findElementAndSendKeys(emailField, userName);
        findElementAndSendKeys(passwordField, PASSWORD);
        waitForElementIsClickableAndClick(loginButton);
    }
}
