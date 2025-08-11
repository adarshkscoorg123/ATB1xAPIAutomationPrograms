package ex_04_RestAssured_HTTPMethods.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting012_PATCH_NonBDDStyle {


    // put

    // token, bookingID- Authorization or Authentication

    //public void get_token(){}

    //public void get_booking_id(){}

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_patch_nonBDD(){

        String bookingID = "202";
        String token = "ebf9a93c84da157";

        String payLoad = "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Dutta\",\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingID);
        r.contentType(ContentType.JSON);
        //r.header("Cookie", "token="+token);
        r.cookie("token", token);
        r.body(payLoad).log().all();


        response = r.when().log().all().patch();
        vr = response.then().log().all();
        vr.statusCode(200);
    }
}
