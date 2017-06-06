package myreview;


import core.Configuration;
import core.PreconditionBuilder;
import org.openqa.selenium.Cookie;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import static core.TestApi.getDriver;
import static myreview.A.as;

class A {

    static String PHPSESSID;
    static String as = "a";

    //  String cookiesInstance3;
    static void setCookkkeeses(String value) {
        PHPSESSID = value;
    }
}

public class LoginWithCookiesTest extends BaseTest {
    PreconditionBuilder preconditionBuilder = new PreconditionBuilder();

    public void checkIfLoggedIn() throws Exception {

        A.PHPSESSID = as;
// open
        preconditionBuilder.justLogIn(Configuration.getInstance().getEpTester1());
        // getDriver().navigate().to(Configuration.getInstance().getFormTabUrl());
        Set<Cookie> cookiesInstanc999 = getDriver().manage().getCookies();
        System.out.println("cookiesInstance999" + cookiesInstanc999);
// delete
        getDriver().manage().deleteCookieNamed("PHPSESSID");
// add
        Cookie name = new Cookie("PHPSESSID", "2oql0v33ut4tqdcem16cg5a562", "/");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy hh.mm.ss zzz");
        String forCooki = simpleDateFormat.format(new Date());
        System.out.println("dataFormat for cookies " + forCooki);

        // 01 черв. 2018 03:22:35 EEST
       //  01 черв. 2017 03.26.41 EEST
        //                  "01 черв. 2018 02:31:31 EEST"
       // Cookie name1 = new Cookie("REMEMBERME", "QXBwQnVuZGxlXEVudGl0eVxVc2VyOlpYQWdkR1Z6ZEdWeU1RPT06MTUyNzg1MjY5MTplNWU5ZWI3MjAzYmI5YWUwZTY4YTA3Mjc1ZmNjYjRhZTc0OWZhYTJiMDk2NTcxOTQwNjkzYjVmZTliYWVlMDYz", "myreview.local", "/", "01 черв. 2018 02:31:31 EEST");
        getDriver().manage().addCookie(name);

        Set<Cookie> cookiesInstanc2 = getDriver().manage().getCookies();
        System.out.println("cookiesInstance2" + cookiesInstanc2);
        getDriver().navigate().to(Configuration.getInstance().getFormTabUrl());

        if (Objects.equals(Configuration.getInstance().getFormTabUrl(), getDriver().getCurrentUrl())) {
            System.out.println("LogIn is not needed. Continue test without logging");
            // System.out.println("PHPSESSID: " + PHPSESSID);
        } else {
            preconditionBuilder.justLogIn(Configuration.getInstance().getEpTester1());
            String cookiesInstance3 = String.valueOf(getDriver().manage().getCookieNamed("PHPSESSID"));

            A.PHPSESSID = cookiesInstance3;

            System.out.println("cookiesInstance3" + cookiesInstance3);
            System.out.println("I think cookies are set");

        }
    }
}
// delete
// Cookie name1 = new Cookie("REMEMBERME", "QXBwQnVuZGxlXEVudGl0eVxVc2VyOlpYQWdkR1Z6ZEdWeU1RPT06MTUyNzc2MDIyOTozYjE5MmU2MDM5NTAyY2QwMTA0MjdhNGU5OWU0NGEyNWZiNmVjZjM4MTg0YWVlZjEyYzk3Njg4MTg0NWRiMTg0");
// driverForCookies.manage().addCookie(name1);
// System.out.println("cookie: " + cookiesInstance1);

//        Thread.sleep(1000);
//        getDriver().navigate().to(Configuration.getInstance().getFormTabUrl());
//        Thread.sleep(6000);
//        getDriver().navigate().to(Configuration.getInstance().getFormTabUrl());
//        Thread.sleep(6000);
//        boolean isempty = getDriver().manage().getCookies().isEmpty(); // true
//        System.out.println("!!!!!!!!!!" + getDriver().manage().getCookieNamed("PHPSESSID"));
//        boolean a = getDriver().manage().getCookieNamed("PHPSESSID") == null;
//        getDriver().manage().getCookieNamed("PHPSESSID");
//        //boolean isNull =  Assert.assertEquals(null,driverForCookies().manage().getCookieNamed("REMEMBERME"));
//        if ((isempty) || (a)) {
//            preconditionBuilder.loginAs(Configuration.getInstance().getEpTester1());
//            System.out.println("If passed. Loged in again");
//        } else {
//            System.out.println("Cookies exist. Log in is not needed");
//            basePage.openUrl(Configuration.getInstance().getFormTabUrl());
//        }
// postcondition.logout();


//  System.out.println(isempty);
// System.out.println("REMEMBERME: " + getDriver().manage().getCookieNamed("REMEMBERME"));
// Assert.assertEquals(null, getDriver().manage().getCookieNamed("REMEMBERME"));


//        for (Cookie cookie : cookiesInstance1) {
//            getDriver().manage().addCookie(cookie);
//        }
//        Set<Cookie> cookiesInstance2 = getDriver().manage().getCookies();
//        System.out.println("cookiesInstance1 = " + cookiesInstance1);
//        System.out.println("cookiesInstance2 = " + cookiesInstance2);
//
//        Assert.assertEquals(cookiesInstance1, cookiesInstance2);