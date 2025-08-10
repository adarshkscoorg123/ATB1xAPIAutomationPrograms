package ex_02_RA_concepts;

import io.restassured.RestAssured;

public class APITesting_Lab05_Multiple_TestCase {

    public static void main(String[] args) {

        String pinCode = "110048";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pinCode)
                .when().log().all()
                .get()
                .then()
                .log().all().statusCode(200);


        pinCode = "@";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pinCode)
                .when().log().all()
                .get()
                .then()
                .log().all().statusCode(200);

        pinCode = " ";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/USA/" + pinCode)
                .when().log().all()
                .get()
                .then()
                .log().all().statusCode(200);

    }
}
