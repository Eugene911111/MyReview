package core;


import org.openqa.selenium.support.ui.WebDriverWait;

import static core.Configuration.TIME_OUT;
import static core.TestApi.getDriver;

public class Wait {

    public static WebDriverWait waitFor() {
        return waitFor(TIME_OUT);
    }

    public static WebDriverWait waitFor(int timeout) {
        return new WebDriverWait(getDriver(), timeout);
    }
}