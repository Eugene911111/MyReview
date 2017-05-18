package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;

import static core.Configuration.TIME_OUT;

@Data
public class BasePage {

    public static WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String currentDate;

    public String returnCurrentDate() throws InterruptedException {
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh.mm.ss a");
        currentDate = ft.format(new Date());
        return currentDate;
    }

    public void openUrl(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    public boolean checkElementIsDisplayed(By element) throws InterruptedException {
        WebDriverWait WAIT4 = new WebDriverWait(driver, TIME_OUT);
        WebElement element1 = WAIT4.until(ExpectedConditions.visibilityOfElementLocated(element));
        return element1 != null;
    }

    public void checkElementIsNotDisplayed(By element) throws InterruptedException {
        WebDriverWait WAIT4 = new WebDriverWait(driver, TIME_OUT);
        WAIT4.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public void highlightElementAndSendKeys(By element, String keys) throws InterruptedException {
        WebDriverWait WAIT4 = new WebDriverWait(driver, TIME_OUT);
        WebElement element1 = WAIT4.until(ExpectedConditions.presenceOfElementLocated(element));
        WebElement toClear = element1.findElement(element);
        toClear.sendKeys(Keys.CONTROL + "a");
        element1.findElement(element).sendKeys(keys);
    }

    public void findElementAndSendKeys(By element, String keys) throws InterruptedException {
        WebDriverWait WAIT4 = new WebDriverWait(driver, TIME_OUT);
        waiter(element, WebElement::isDisplayed, ExpectedConditions::visibilityOfElementLocated, TIME_OUT);
        WebElement element1 = WAIT4.until(ExpectedConditions.presenceOfElementLocated(element));
        element1.findElement(element).sendKeys(keys);
    }

    public void findElementClearAndSendKeys(By element, String keys) throws InterruptedException {
        WebDriverWait WAIT4 = new WebDriverWait(driver, TIME_OUT);
        waiter(element, WebElement::clear, ExpectedConditions::visibilityOfElementLocated, TIME_OUT);
        WebElement element1 = WAIT4.until(ExpectedConditions.presenceOfElementLocated(element));
        element1.findElement(element).sendKeys(keys);
    }

    public void waiter(By selector, Consumer<WebElement> consumer, Function<By, ExpectedCondition<WebElement>> function, long seconds) throws InterruptedException {
        WebDriverWait WAIT4 = new WebDriverWait(driver, TIME_OUT);
        WebElement element = WAIT4.until(function.apply(selector));
        consumer.accept(element);
    }

    public void waitForElementIsClickableAndClick(By byElement) throws InterruptedException {
        waiter(byElement, WebElement::click, ExpectedConditions::elementToBeClickable, TIME_OUT);
    }

    public void changeFocusToPage(int pageIndex) throws InterruptedException {
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs.get(pageIndex));
    }

    public void waitForElementIsPresentAndClick(By byElement) throws InterruptedException {
        waiter(byElement, WebElement::click, ExpectedConditions::visibilityOfElementLocated, TIME_OUT);
    }

    public String getTextFromElement(By element) throws InterruptedException {
        waiter(element, WebElement::isDisplayed, ExpectedConditions::presenceOfElementLocated, TIME_OUT);
        return driver.findElement(element).getText();
    }

    // for textarea and input elements
    public void waitForPresenceOfTextInElement(By element, String text) throws InterruptedException {
        WebDriverWait WAIT4 = new WebDriverWait(driver, TIME_OUT);
        WAIT4.until(ExpectedConditions.textToBePresentInElementValue(element, text));
    }

    // for div elements
    public void waitForPresenceOfTextInElement1(By element, String text) throws InterruptedException {
        WebDriverWait WAIT4 = new WebDriverWait(driver, TIME_OUT);
        WAIT4.until(ExpectedConditions.textToBe(element, text));
    }
}

