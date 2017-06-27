package myreview;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static core.TestApi.getDrivers;
import static core.TestApi.setDrivers;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public static void setUp() {
        setDrivers(new ChromeDriver());
    }

    @AfterMethod(alwaysRun = true)
    public static void tearDown() {
        getDrivers().quit();
    }
}