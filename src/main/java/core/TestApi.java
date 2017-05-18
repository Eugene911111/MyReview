package core;

import org.openqa.selenium.WebDriver;

public class TestApi {

    public static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        TestApi.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
