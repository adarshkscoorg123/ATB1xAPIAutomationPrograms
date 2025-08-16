package ex_05_TestNG_Examples;

import org.testng.annotations.Test;

public class APITesting016_TESTNG_WithPriority {

    // Default priority is 0
    // priority -3 runs before priority -1
    // Same priority -> alphabetic order

    @Test (priority = 1)
    public void test_t1(){
        System.out.println("1");
    }

    @Test (priority = 3)
    public void test_t2(){
        System.out.println("3");
    }

    @Test (priority = 2)
    public void test_t3(){
        System.out.println("2");
    }

    @Test (priority = 4)
    public void test_t4(){
        System.out.println("4");
    }

}
