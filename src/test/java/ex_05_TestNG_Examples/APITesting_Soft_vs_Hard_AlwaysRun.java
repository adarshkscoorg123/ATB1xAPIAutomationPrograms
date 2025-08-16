package ex_05_TestNG_Examples;

import org.testng.annotations.Test;

public class APITesting_Soft_vs_Hard_AlwaysRun {


    @Test
    public void login(){
      // might fail
    }

    @Test (dependsOnMethods = "login") // Hard dependency
    public void placeOrder(){
     // runs only if login is passed
    }

    @Test (dependsOnMethods = "login", alwaysRun = true) // Soft dependency
    public void closeBrowser(){
        // runs even if login is failed
    }
}
