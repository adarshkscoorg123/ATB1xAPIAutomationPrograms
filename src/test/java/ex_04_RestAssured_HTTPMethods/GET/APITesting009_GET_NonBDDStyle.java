package ex_04_RestAssured_HTTPMethods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_GET_NonBDDStyle {

    RequestSpecification r; // pre-request - Given part
    Response response;  //making the request - When part
    ValidatableResponse vr; // post-request- Then part
    String pinCode;

    @Test
    public void get_NonBDDStyle() {
        pinCode = "560048";

        // Given Part
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pinCode);

        // When part
        response = r.when().log().all().get();

        // Then part
        vr = response.then().log().all();
        vr.statusCode(200);
    }

    @Test
    public void get_NonBDDStyle_Negative() {

        pinCode = "@";

        // Given Part
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pinCode);

        // When part
        response = r.when().log().all().get();

        // Then part
        vr = response.then().log().all();
        vr.statusCode(404);
    }
}
