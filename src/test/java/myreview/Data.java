package myreview;

import core.Configuration;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class Data extends BaseTest {
    String atester1 = Configuration.getInstance().getATester1();
    String atesterDm = Configuration.getInstance().getATesterDm();
    String adelivery1 = Configuration.getInstance().getADelivery1();
    String ahr = Configuration.getInstance().getAhr();
    String ahrdm = Configuration.getInstance().getAhrDm();
    String asm = Configuration.getInstance().getAsm();

    @DataProvider(name = "all_users")
    public Object[][] getData(Method name) {
        Object[][] obj = new Object[6][1];
        obj[0][0] = atester1;
        obj[1][0] = atesterDm;
        obj[2][0] = adelivery1;
        obj[3][0] = ahr;
        obj[4][0] = ahrdm;
        obj[5][0] = asm;
        return obj;
    }

    @DataProvider(name = "department_managers")
    public Object[][] getData() {
        Object[][] obj = new Object[5][1];
        obj[0][0] = atesterDm;
        obj[1][0] = asm;
        obj[2][0] = adelivery1;
        obj[3][0] = ahrdm;
        obj[4][0] = ahr;
        return obj;
    }
}