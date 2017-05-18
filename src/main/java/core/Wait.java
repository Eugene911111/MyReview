package core;

import org.openqa.selenium.support.ui.WebDriverWait;

import static core.Configuration.TIME_OUT;
import static pages.BasePage.driver;

public class Wait {
    public static WebDriverWait WAIT = new WebDriverWait(driver, TIME_OUT);
 //   private static WebDriver driver;
}
