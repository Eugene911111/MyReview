package core;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class TestApi {

    private static Map<Thread, WebDriver> drivers = new HashMap<>();

    public static void setDrivers(WebDriver driver) {
        drivers.put(Thread.currentThread(), driver);
    }

    public static WebDriver getDrivers() {
        return drivers.get(Thread.currentThread());
    }
}