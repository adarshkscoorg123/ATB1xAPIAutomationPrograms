package ex_05_TestNG_Examples;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class APITesting026_TESTNG_BeforeAfterClass {

    @BeforeClass
    public void demo3() {
        System.out.println("Before Class");

    }

    @Test
    public void addy() {
        System.out.println("Addy");
    }

    @Test
    public void buddy() {
        System.out.println("buddy");
    }

    @Test
    public void chuddy() {
        System.out.println("chuddy");
    }

    @Test
    public void diddy() {
        System.out.println("Diddy");
    }

    @AfterClass
    public void demo5() {
        System.out.println("After Class");
    }

}

