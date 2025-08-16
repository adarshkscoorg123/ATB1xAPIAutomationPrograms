package ex_06_TestAssertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting031_TESTNG_SoftAssert {

    @Test
    public void test_softAssertExample(){

        SoftAssert softAssert = new SoftAssert();
        System.out.println("Start of the program");
        softAssert.assertEquals("pramod", "Pramod");
        System.out.println("End of program");
        softAssert.assertAll();
    }
}