package pages;

import core.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j
        .Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;

import static core.TestApi.getDrivers;
import static core.Wait.waitFor;

public class BasePage {
    WebDriver driver1 = getDrivers();
    private String dateFormat = "E yyyy.MM.dd 'at' hh.mm.ss a";
    public Logger log = LoggerFactory.getLogger(this.getClass());
    public String currentDate;

    public String returnCurrentDate() throws InterruptedException {
        SimpleDateFormat ft = new SimpleDateFormat(dateFormat);
        currentDate = ft.format(new Date());
        return currentDate;
    }

    public void openUrl(String url) {
        getDrivers().manage().window().maximize();
        getDrivers().get(url);
    }

    public boolean checkElementIsDisplayed(By element) throws InterruptedException {
        return waitFor().until(ExpectedConditions.visibilityOfElementLocated(element)) != null;
    }

    public void checkElementIsNotDisplayed(By element) throws InterruptedException {
        waitFor().until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public void findElementClearAndSendKeys(By element, String keys) throws InterruptedException {
        waiter(element, WebElement::clear, ExpectedConditions::visibilityOfElementLocated, Configuration.getInstance().getTimeOut());
        WebElement element1 = waitFor().until(ExpectedConditions.presenceOfElementLocated(element));
        element1.findElement(element).sendKeys(keys);
    }

    private void waiter(By selector, Consumer<WebElement> consumer, Function<By, ExpectedCondition<WebElement>> function, long seconds) throws InterruptedException {
        WebElement element = waitFor().until(function.apply(selector));
        consumer.accept(element);
    }

    public void waitForElementIsClickableAndClick(By byElement) throws InterruptedException {
        waiter(byElement, WebElement::click, ExpectedConditions::elementToBeClickable, Configuration.getInstance().getTimeOut());
    }

    public void changeFocusToPage(int pageIndex) throws InterruptedException {
        ArrayList tabs = new ArrayList(getDrivers().getWindowHandles());
        getDrivers().switchTo().window((String) tabs.get(pageIndex));
    }

    public String getTextFromElement(By element) throws InterruptedException {
        waiter(element, WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, Configuration.getInstance().getTimeOut());
        return getDrivers().findElement(element).getText();
    }

    /**
     * for textarea and input elements
     */
    public void waitForPresenceOfTextInTextAreaInputElement(By element, String text) throws InterruptedException {
        waitFor().until(ExpectedConditions.textToBePresentInElementValue(element, text));
    }

    /**
     * for div elements
     */
    public void waitForPresenceOfTextInDivElement(By element, String text) throws InterruptedException {
        waitFor().until(ExpectedConditions.textToBe(element, text));
    }
}

