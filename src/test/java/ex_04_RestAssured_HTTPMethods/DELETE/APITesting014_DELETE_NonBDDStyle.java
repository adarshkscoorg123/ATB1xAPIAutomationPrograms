package ex_04_RestAssured_HTTPMethods.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting014_DELETE_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_delete_nonBDD(){

        String bookingID = "202";
        String token = "ebf9a93c84da157";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingID);
        r.contentType(ContentType.JSON);
        //r.header("Cookie", "token="+token);
        r.cookie("token", token);

        response = r.when().log().all().delete();
        vr = response.then().log().all();
        vr.statusCode(200);
    }
}
