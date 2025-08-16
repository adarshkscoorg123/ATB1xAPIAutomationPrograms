package ex_05_TestNG_Examples;

import org.testng.annotations.Test;

public class APITesting022_TESTNG_InvocationCount {

    @Test (invocationCount = 2)
    public void test01(){
        System.out.println("Hi");
    }

    @Test (invocationCount = 3)
    public void test02(){
        System.out.println("Bye");
    }

}
