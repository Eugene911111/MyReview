package helpers;

import core.Configuration;
import core.Preconditions;
import org.openqa.selenium.Cookie;

import java.util.Set;

import static core.TestApi.getDriver;

public class GetCookies {
    private static Preconditions preconditions = new Preconditions();

    public static void isItNesseseryToLogIn() throws Exception {

        getDriver().get("http://myreview.local/app_dev.php/#/notes");
     //   Thread.sleep(2000);
        Set<Cookie> cookiesInstance1 = getDriver().manage().getCookies();
        System.out.println("getDriver().manage().getCookies():  "+getDriver().manage().getCookies());

        for (Cookie cookie : cookiesInstance1) {
            getDriver().manage().addCookie(cookie);
        }
       // Thread.sleep(2000);
        getDriver().get("http://myreview.local/app_dev.php/#/notes");
        System.out.println("cookiesInstance1" + cookiesInstance1);
        boolean isEmpty = getDriver().manage().getCookies().isEmpty();
        System.out.println("is empty?  -  " + isEmpty);
        boolean a = getDriver().manage().getCookieNamed("REMEMBERME") == null;
        if ((isEmpty)) {
            preconditions.logInAs(Configuration.getInstance().getEptester1());
            System.out.println("If passed. Loged in again");
        } else {
            System.out.println("Cookies exist. Log in is not needed");
        }
    }
}
