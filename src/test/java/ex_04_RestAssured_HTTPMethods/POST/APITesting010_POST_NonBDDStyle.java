package ex_04_RestAssured_HTTPMethods.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting010_POST_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_POST_NonBDDStyle_Create_Token(){
        // URL  https://restful-booker.herokuapp.com/auth
        // PAYLOAD - {
        //    "username" : "admin",
        //    "password" : "password123"
        //}
        // HEADER- Content-Type : application/json
        // Auth ?- NA
        // Cookie ?- NA
        // validate - 200 Ok
        // Body response - Token is generated or not

        String payLoad = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        System.out.println("------------Part1-----------");

        // Part1 - Pre-condition - Preparing request - URl, headers, Auth
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON );
        //r.header("Content-length", "1000");
        //r.auth().basic("admin", "password123");
        //r.auth().oauth2("ey38923edrr");
        r.body(payLoad).log().all();

        System.out.println("-----------Part2-----------");
        // Making HTTP request
        response = r.when().log().all().post();

        System.out.println("-----------Part3-----------");
        // Validation the response
        vr = response.then().log().all();
        vr.statusCode(201);
    }

}
