package myreview;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;

import static core.TestApi.getDriver;
import static core.TestApi.setDriver;

public class BaseTest {

    @BeforeClass
    public void setUp() {
        setDriver(new ChromeDriver());
    }

    @AfterClass
    public void tearDown() {
        getDriver().quit();
    }
}
