package ex_05_TestNG_Examples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting015_BeforeTest {

    // PUT Request
    //1. getToken
    //2. getBookingId
    //3. test_put(which will use the above 2 methods)
    //4. Close all things

    @BeforeTest
    public void getToken(){
        System.out.println("Before get token");
    }

    @AfterTest
    public void closeAllThings(){
        System.out.println("Close");
    }

    @AfterTest
    public void closeAllThings_2() {
        System.out.println("Close_2");
    }

    @Test
    public void test_Put(){
        System.out.println("PUT Request");
    }

    @BeforeTest
    public void getBookingID(){
        System.out.println("Before get booking");
    }



}
