package ex_05_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting018_TESTNG_DependsOnMethod {

    @Test
    public void serverStartedOk(){
        System.out.println("I will run first");
        Assert.assertTrue(true);
    }

    @Test
    public void webServicesStartedOk(){
        System.out.println("I will run second");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void test1(){
        System.out.println("Method1");
        Assert.assertTrue(true);
    }

    @Test (dependsOnMethods = "webServicesStartedOk")
    public void test2(){
        System.out.println("Method2");
        Assert.assertTrue(true);
    }




}
