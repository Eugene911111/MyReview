package myreview;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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