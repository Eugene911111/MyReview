package myreview;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static core.TestApi.getDrivers;
import static core.TestApi.setDrivers;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public static void setUp() {
        /**
         For Firefox
         */
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//        capabilities.setCapability("marionette", true);
//        setDrivers(new FirefoxDriver(capabilities));

        /**
         * For Chrome
         */
      setDrivers(new ChromeDriver());
    }

    @AfterMethod(alwaysRun = true)
    public static void tearDown() {
        getDrivers().quit();
    }
}