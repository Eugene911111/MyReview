package pages;

import org.openqa.selenium.By;

public class CommonPage extends BasePage {
    public final By userImgDropdown = By.xpath("//li[@class=\"btn-group dropdown\"]/a");
    public final By aboutMyReviewButton = By.xpath("//a[@ui-sref=\"about\"]");
    public final By formExampleButton = By.xpath("//a[@ui-sref=\"example\"]");
    public  By sendYourFeedbackButton = By.xpath("//ul[@class=\"dropdown-menu\"]//li[contains(.,\"Send your feedback\")]");
    private final By logOutButton = By.xpath("//ul[@class=\"dropdown-menu\"]//a[@ng-click=\"vm.logOut()\"]");
    public final By levi9Logo = By.xpath("//img[@class=\"logo\"]");
    public final By notesButton = By.xpath("//a[@href=\"#/notes\"]");
    public final By formButton = By.xpath("//a[@href=\"#/form\"]");
    public final By historyButton = By.xpath("//ul[@class=\"nav navbar-nav navbar-right ng-scope\"]//a[contains(., \"History\")]");
    public String formTabUrl = "http://myreview.local/app_dev.php/#/form";
    public final By departmentButton = By.xpath("//a[@href=\"#/department\"]");

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