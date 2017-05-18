package core;

import org.openqa.selenium.support.ui.WebDriverWait;

import static core.Configuration.TIME_OUT;
import static core.TestApi.getDriver;

public class Wait {
    // public static WebDriverWait wait = new WebDriverWait();
    public static WebDriverWait WAIT = new WebDriverWait(getDriver(), TIME_OUT);
}
