package ex_04_RestAssured_HTTPMethods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting011_PUT_NonBDDStyle {

    // put

    // token, bookingID- Authorization or Authentication

    //public void get_token(){}

    //public void get_booking_id(){}

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_put_nonBDD(){

        String bookingID = "202";
        String token = "ebf9a93c84da157";

        String payLoad = "{\n" +
                "    \"firstname\" : \"james\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 4000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2025-07-01\",\n" +
                "        \"checkout\" : \"2025-07-27\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingID);
        r.contentType(ContentType.JSON);
        //r.header("Cookie", "token="+token);
        r.cookie("token", token);
        r.body(payLoad).log().all();


        response = r.when().log().all().put();
        vr = response.then().log().all();
        vr.statusCode(200);
    }
}
