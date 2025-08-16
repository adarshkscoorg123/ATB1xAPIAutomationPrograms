package ex_05_TestNG_Examples;

import org.testng.annotations.*;

public class APITesting024_TESTNG_BeforeAfterMethod {

    @BeforeMethod
    public void demo3() {
        System.out.println("Before Method1");

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
    public void chondy() {
        System.out.println("chondy");
    }

    @Test
    public void demo() {
        System.out.println("Demo");
    }

    @AfterMethod
    public void demo5() {
        System.out.println("After Method1");
    }

}
