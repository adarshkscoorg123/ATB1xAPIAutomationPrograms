package ex_07_Payload_Management.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;


public class APITesting034_RestAssured_Payload_Map {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingId;

    //HashMap -> key and value pair
    //Parent HashMap->key and value, child HashMap

    @Test
    public void test_POST() {
        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap<String, Object>();
        jsonBodyUsingMap.put("firstname", "Adarsh");
        jsonBodyUsingMap.put("lastname", "Allen");
        jsonBodyUsingMap.put("totalprice", 111);
        jsonBodyUsingMap.put("depositpaid", true);

        Map<String, Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin","2025-08-10" );
        bookingDatesMap.put("checkout","2025-08-10");

        jsonBodyUsingMap.put("bookingdates", bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds","super bowls");
        System.out.println(jsonBodyUsingMap);


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();

        response = requestSpecification.when().log().all().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        validatableResponse.body("bookingid", Matchers.notNullValue());
        validatableResponse.body("booking.firstname",Matchers.equalTo("Adarsh"));
        validatableResponse.body("booking.lastname",Matchers.equalTo("Allen"));
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(true));












    }
}