package ex_03_TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting_Lab06_TestCase {

    // Valid PinCode->110001

    String pinCode;

    @Test
    public void test_tc1_PinCode_valid(){
        System.out.println("This is a TestNG test case");
        pinCode = "110048";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pinCode)
                .when().log().all()
                .get()
                .then()
                .log().all().statusCode(200);
    }
    // #,$,%,@ - any special input=PinCode
    @Test
    public void test_tc2_PinCode_invalid(){
        System.out.println("This is a second test case");
        pinCode = "@";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pinCode)
                .when().log().all()
                .get()
                .then()
                .log().all().statusCode(200);
    }
    // ' ' = blank , PinCode
    @Test
    public void test_tc3_PinCode_invalid(){
        System.out.println("Third TestCase");
        pinCode = " ";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pinCode)
                .when().log().all()
                .get()
                .then()
                .log().all().statusCode(200);
    }
}
