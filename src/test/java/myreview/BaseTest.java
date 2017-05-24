package myreview;

import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import static core.TestApi.getDriver;
import static core.TestApi.setDriver;

public class BaseTest {

    @BeforeClass
    public static void setUp() {
        setDriver(new ChromeDriver());
    }

    @AfterClass
    public static void tearDown() {
        getDriver().quit();
    }
}