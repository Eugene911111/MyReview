package pages;

import core.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;

import static core.TestApi.getDriver;
import static core.Wait.waitFor;

public class BasePage {

    public Logger log = LoggerFactory.getLogger(this.getClass());
    public static String currentDate;

    static String returnCurrentDate() throws InterruptedException {
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh.mm.ss a");
        currentDate = ft.format(new Date());
        return currentDate;
    }

    public static void openUrl(String url) {
        getDriver().manage().window().maximize();
        getDriver().get(url);
    }

    public static boolean checkElementIsDisplayed(By element) throws InterruptedException {
        return waitFor().until(ExpectedConditions.visibilityOfElementLocated(element)) != null;
    }

    static void checkElementIsNotDisplayed(By element) throws InterruptedException {
        waitFor().until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    static void highlightElementAndSendKeys(By element, String keys) throws InterruptedException {
        WebElement element1 = waitFor().until(ExpectedConditions.presenceOfElementLocated(element));
        WebElement toClear = element1.findElement(element);
        toClear.sendKeys(Keys.CONTROL + "a");
        element1.findElement(element).sendKeys(keys);
    }

    static void findElementAndSendKeys(By element, String keys) throws InterruptedException {
        WebElement element1 = waitFor().until(ExpectedConditions.presenceOfElementLocated(element));
        element1.findElement(element).sendKeys(keys);
    }

    static void findElementClearAndSendKeys(By element, String keys) throws InterruptedException {
        waiter(element, WebElement::clear, ExpectedConditions::visibilityOfElementLocated, Configuration.getInstance().getTimeOut());
        WebElement element1 = waitFor().until(ExpectedConditions.presenceOfElementLocated(element));
        element1.findElement(element).sendKeys(keys);
    }

    private static void waiter(By selector, Consumer<WebElement> consumer, Function<By, ExpectedCondition<WebElement>> function, long seconds) throws InterruptedException {
        WebElement element = waitFor().until(function.apply(selector));
        consumer.accept(element);
    }

    public static void waitForElementIsClickableAndClick(By byElement) throws InterruptedException {
        waiter(byElement, WebElement::click, ExpectedConditions::elementToBeClickable, Configuration.getInstance().getTimeOut());
    }

    static void changeFocusToPage(int pageIndex) throws InterruptedException {
        ArrayList tabs = new ArrayList(getDriver().getWindowHandles());
        getDriver().switchTo().window((String) tabs.get(pageIndex));
    }

    static void waitForElementIsPresentAndClick(By byElement) throws InterruptedException {
        waiter(byElement, WebElement::click, ExpectedConditions::visibilityOfElementLocated, Configuration.getInstance().getTimeOut());
    }

    public static String getTextFromElement(By element) throws InterruptedException {
        waiter(element, WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, Configuration.getInstance().getTimeOut());
        return getDriver().findElement(element).getText();
    }

    /**
     * for textarea and input elements
     */
    static void waitForPresenceOfTextInTextAreaInputElement(By element, String text) throws InterruptedException {
        waitFor().until(ExpectedConditions.textToBePresentInElementValue(element, text));
    }

    /**
     * for div elements
     */
    static void waitForPresenceOfTextInDivElement(By element, String text) throws InterruptedException {
        waitFor().until(ExpectedConditions.textToBe(element, text));
    }
}

