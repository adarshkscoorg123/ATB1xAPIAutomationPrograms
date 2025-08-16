package ex_06_TestAssertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting030_TESTNG_HardAssert {

    @Test
    public void test_hardAssertExample(){
        System.out.println("Start of the program");
        Assert.assertEquals("pramod", "Pramod");
        System.out.println("End of the program");
    }
}
