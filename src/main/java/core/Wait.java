package core;

import org.openqa.selenium.support.ui.WebDriverWait;

import static core.TestApi.getDrivers;

public class Wait {

    public static WebDriverWait waitFor() {
        return waitFor(Configuration.getInstance().getTimeOut());
    }

    public static WebDriverWait waitFor(int timeout) {
        return new WebDriverWait(getDrivers(), timeout);
    }
}