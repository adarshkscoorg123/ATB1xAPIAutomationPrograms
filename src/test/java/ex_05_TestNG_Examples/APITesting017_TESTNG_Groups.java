package ex_05_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting017_TESTNG_Groups {

    // for ex: Sanity-all the test cases should run
    // Regression-1 test case should run
    // Smoke-1 test case should run

    @Test (groups = {"reg","sanity"})
    public void test_Sanity_run(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
        System.out.println("---------");
    }

    @Test (groups = {"reg"})
    public void test_Regression_run(){
        System.out.println("Regression");
        Assert.assertTrue(false);
    }

    @Test (groups = {"reg", "smoke"})
    public void test_Smoke_run(){
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }

}
