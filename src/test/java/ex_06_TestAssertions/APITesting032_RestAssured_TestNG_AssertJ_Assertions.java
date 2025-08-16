package ex_06_TestAssertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class APITesting032_RestAssured_TestNG_AssertJ_Assertions {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingId;

    @Test
    public void test_createBooking_POST() {
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

        //RestAssured -> import org.hamcrest.Matchers; 4 to 5%
        // Matchers.equalTo();


        validatableResponse.body("bookingid", Matchers.notNullValue());
        validatableResponse.body("booking.firstname",Matchers.equalTo("Adarsh"));
        validatableResponse.body("booking.lastname",Matchers.equalTo("Brown"));
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(true));


        // Extract the details of the firstName, bookingID, lastName

        bookingId = response.then().extract().path("bookingid");
        String firstName = response.then().extract().path("booking.firstname");
        String lastName = response.then().extract().path("booking.lastname");

        // TESTNG Assertions - 75 %
        // Soft Assertions- 5 %
        // Hard Assertions- 90% , because we want to stop the execution whenver there is->
        // -> a failure in the test case

        //TESTNG Assertions
        Assert.assertEquals(firstName, "Adarsh");
        Assert.assertEquals(lastName,"Allen");
        Assert.assertNotNull(bookingId);

        // AssertJ(3rd lib to Assertions) - 20%

        assertThat(bookingId).isNotZero().isNotNull().isPositive();
        assertThat(firstName).isNotBlank().isNotNull().isNotEmpty().isEqualTo("Adarsh");


    }


    }
