package pages;

import core.Configuration;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By levi9Logo = By.xpath("//img[@src='/bundles/app/images/logo.png']");
    private By loginButton = By.xpath("//input[@value='Login']");
    private By passwordField = By.id("password");
    private By usernameField = By.id("username");
    public By logInFormName = By.xpath("//div[@class='panel-heading'][contains(., 'Log In')]");

    public void logIn(String userName) throws Exception {
        openUrl(Configuration.getInstance().getLogInPageUrl());
        checkElementIsDisplayed(levi9Logo);
        checkElementIsDisplayed(logInFormName);
        findElementClearAndSendKeys(usernameField, userName);
        findElementClearAndSendKeys(passwordField, Configuration.getInstance().getPassword());
        waitForElementIsClickableAndClick(loginButton);
    }
}
