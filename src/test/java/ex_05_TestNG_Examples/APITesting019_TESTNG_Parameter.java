package ex_05_TestNG_Examples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting019_TESTNG_Parameter {


    @Parameters("browser")
    @Test
    public void demo1(String value){
        System.out.println("Hi I am demo");
        System.out.println("You are running this param");

        if(value.equalsIgnoreCase("firefox")){
            System.out.println("Start the firefox");
        }

        if(value.equalsIgnoreCase("chrome")){
            System.out.println("Start the Chrome");
        }
    }
}
