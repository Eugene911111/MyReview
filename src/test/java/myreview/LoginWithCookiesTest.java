package myreview;


import core.Configuration;
import core.Preconditions;
import org.junit.Test;

import static core.TestApi.getDriver;

public class LoginWithCookiesTest extends BaseTest {
    private Preconditions preconditions = new Preconditions();

    @Test
    public void loginTest() throws Exception {
// log in
//      //  loginPage.logIn(loginPage.EPTESTER_1);
//       // Assert.assertTrue(noteTabPage.checkElementIsDisplayed(commonPage.levi9Logo));
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpGet httpGet = new HttpGet("http://myreview.local/app_dev.php/login");
//        httpGet.addHeader(BasicScheme.authenticate(
//                new UsernamePasswordCredentials("EPTESTER_1", "Levi9Pro"),
//                "UTF-8", false));
//
//        HttpResponse httpResponse = httpClient.execute(httpGet);
//        HttpEntity responseEntity = httpResponse.getEntity();
//
//        driver.get("http://myreview.local/app_dev.php/login");
//        Thread.sleep(5000);
//        // save cookies

//        HttpClient httpClient = new DefaultHttpClient();
//
//        CookieStore cookieStore = new BasicCookieStore();
//        BasicHttpContext localContext = new BasicHttpContext();
//
//        localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
//        HttpGet httpGet = new HttpGet("http://myreview.local/app_dev.php/login");
//
//        System.out.println("executing request " + httpGet.getURI());
//
//        HttpResponse response = httpClient.execute(httpGet, localContext);
//        HttpEntity httpEntity = response.getEntity();
//
//        System.out.println("----------------------------------------");
//        System.out.println(response.getStatusLine());
//
//        if (httpEntity != null) {
//            System.out.println("Response content length: " + httpEntity.getContentLength());
//        }
//        List<org.apache.http.cookie.Cookie> cookies = cookieStore.getCookies();
//        for (org.apache.http.cookie.Cookie cooky : cookies) {
//            System.out.println("Local cookie: " + cooky);
//        }
//        EntityUtils.consume(httpEntity);
//        System.out.println("----------------------------------------");
//        noteTabPage.logOut();
//        Thread.sleep(3000);
//        HttpPost httpPost = new HttpPost("http://myreview.local/app_dev.php/#/notes");
//        Thread.sleep(3000);
//        HttpResponse httpResponse = httpClient.execute(httpPost, localContext);
//        driver.get("http://myreview.local/app_dev.php/#/notes");
//        Thread.sleep(3000);
//        httpClient.getConnectionManager().shutdown();


















        getDriver().manage().deleteAllCookies();
        preconditions.logInAs(Configuration.getInstance().getEptester1());
       // getDriver().manage().deleteAllCookies();

     //   Set<Cookie> cookiesInstance1 = getDriver().manage().getCookies();

        boolean isempty = getDriver().manage().getCookies().isEmpty(); // true
        System.out.println("!!!!!!!!!!"+getDriver().manage().getCookieNamed("REMEMBERME"));
        boolean a = getDriver().manage().getCookieNamed("REMEMBERME") == null;
        getDriver().manage().getCookieNamed("REMEMBERME");
        //boolean isNull =  Assert.assertEquals(null,getDriver().manage().getCookieNamed("REMEMBERME"));
        if ((isempty) || (a)) {
            preconditions.logInAs(Configuration.getInstance().getEptester1());
            System.out.println("If passed. Loged in again");
        } else  {
            System.out.println("Cookies exist. Log in is not needed");
        }
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
    }


//        private SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd MMMMMM yyyy", Locale.ENGLISH);
//        private String currentDate1 = simpleDateFormat1.format(new Date());
//
//
//        departmentPage.openUrl("http://myreview.local/app_dev.php/#/history/644E3D87-E5EC-4274-8B26-EF76C5537E93");
//        String getTextFromHistory = departmentPage.getTextFromElement(By.xpath("/html/body/div/history/div[1]/div/uib-accordion/div/div[2]"));
//        String currentDate = getTextFromHistory.split(" ", 3)[2];
//        Assert.assertEquals(currentDate1, currentDate);
}
