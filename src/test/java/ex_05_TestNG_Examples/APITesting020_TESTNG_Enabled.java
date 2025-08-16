package ex_05_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting020_TESTNG_Enabled {

    @Test
    public void test01(){
        Assert.assertTrue(true);
        System.out.println("testcase1");
    }

    @Test (enabled = false)
    public void test02(){
        Assert.assertTrue(true);
        System.out.println("testcase2");
    }

    @Test
    public void test03(){
        Assert.assertTrue(true);
        System.out.println("testcase3");
    }

}