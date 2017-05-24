package pages;

import org.openqa.selenium.By;

import static pages.LoginPage.logInFormName;

public class CommonPage extends BasePage {
    public String departmentURL = "http://myreview.local/app_dev.php/#/department";
    public static String formTabUrl = "http://myreview.local/app_dev.php/#/form";
    static String reviewMeetingUrl = "http://myreview.local/app_dev.php/#/department/review-meeting/";
    public String loginPageUrl = "http://myreview.local/app_dev.php/login";
    private By userImgDropdown = By.xpath("//li[@class=\"btn-group dropdown\"]/a");
    private By aboutMyReviewButton = By.xpath("//a[@ui-sref=\"about\"]");
    private By formExampleButton = By.xpath("//a[@ui-sref=\"example\"]");
    private By sendYourFeedbackButton = By.xpath("//ul[@class=\"dropdown-menu\"]//li[contains(.,\"Send your feedback\")]");
    private By logOutButton = By.xpath("//ul[@class=\"dropdown-menu\"]//a[@ng-click=\"vm.logOut()\"]");
    private By levi9Logo = By.xpath("//img[@class=\"logo\"]");
    public By notesButton = By.xpath("//a[@href=\"#/notes\"]");
    public By formButton = By.xpath("//a[@href=\"#/form\"]");
    public By historyButton = By.xpath("//ul[@class=\"nav navbar-nav navbar-right ng-scope\"]//a[contains(., \"History\")]");
    public By departmentButton = By.xpath("//a[@href=\"#/department\"]");

    public void logOut() throws Exception {
        pressLogoutButton();
        checkElementIsDisplayed(levi9Logo);
        checkElementIsDisplayed(logInFormName);
    }

    public void openAboutMyReviewPage() throws InterruptedException {
        waitForElementIsClickableAndClick(userImgDropdown);
        waitForElementIsClickableAndClick(aboutMyReviewButton);
    }

    public void openFormExamplePage() throws InterruptedException {
        waitForElementIsClickableAndClick(userImgDropdown);
        waitForElementIsClickableAndClick(formExampleButton);
    }

    public void pressLogoutButton() throws InterruptedException {
        waitForElementIsClickableAndClick(userImgDropdown);
        waitForElementIsClickableAndClick(logOutButton);
    }

    public void openFormTab() throws InterruptedException {
        openUrl(formTabUrl);
    }

    public void openFeedbackDialogWindow() throws InterruptedException {
        waitForElementIsClickableAndClick(userImgDropdown);
        waitForElementIsClickableAndClick(sendYourFeedbackButton);
    }
}