package myreview.testSuits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        DmTestSuite.class,
        EmployeeTestSuite.class
})

public class RunAll {
}