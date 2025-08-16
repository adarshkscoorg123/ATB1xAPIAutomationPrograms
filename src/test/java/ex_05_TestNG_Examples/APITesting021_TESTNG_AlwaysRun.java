package ex_05_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting021_TESTNG_AlwaysRun {


    @Test (enabled = false)
    public void test_A_new_register(){
        Assert.assertTrue(true);
    }

    @Test (alwaysRun = true)
    public void test_loginPage(){
        Assert.assertTrue(true);
    }

    @Test
    public void test_normal(){
        Assert.assertTrue(true);
    }


}
