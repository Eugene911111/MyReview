package myreview.testSuits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        DmTestSuite.class,
        EmployeeTestSuite.class,
        AdminTestSuite.class
})

public class RunAll {
}