package ex_05_TestNG_Examples;

import org.testng.annotations.*;

public class APITesting027_TESTNG_TEST1 {


    @BeforeTest
    public void demo3(){
        System.out.println("Before Test");

    }

    @Test
    public void addy(){
        System.out.println("Addy");
    }

    @Test
    public void buddy(){
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

    @AfterTest
    public void demo5() {
        System.out.println("After Test");
    }
}
