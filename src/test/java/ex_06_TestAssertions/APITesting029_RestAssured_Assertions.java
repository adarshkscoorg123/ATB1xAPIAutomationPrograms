package ex_06_TestAssertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class APITesting029_RestAssured_Assertions {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingId;

    @Test
    public void test_createBooking_POST(){
        // Payload
        //given-setting up the body, url, base path
        //when-making the request
        //then-extraction

        String request_payLoad = "{\n" +
                "    \"firstname\": \"Adarsh\",\n" +
                "    \"lastname\": \"Allen\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-01-01\",\n" +
                "        \"checkout\": \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"super bowls\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");

        // Header Information

        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(request_payLoad).log().all();

        response = requestSpecification.when().log().all().post();

        // Get validatable response to perform validation

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //Booking ID !=null , FirstName == Pramod
        //Extract the response body and do it

        //System.out.println(response.asString());

        validatableResponse.body("bookingid", Matchers.notNullValue());
        validatableResponse.body("booking.firstname",Matchers.equalTo("Adarsh"));
        validatableResponse.body("booking.lastname",Matchers.equalTo("Brown"));
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(true));
        validatableResponse.body("booking.bookingdates.checkin",Matchers.equalTo("2018-01-01"));







    }
}
