package ex_01_RA_Basics;

import io.restassured.RestAssured;

import java.util.Scanner;

public class APITesting_Lab02_RA {

    public static void main(String[] args) {

        // Gherkins Syntax
        // Given()  -> Pre-requisites- URL's, Headers, Auth, Body...
        // When()   -> HTTP Methods  - GET/POST/PUT/PATCH/DELETE
        // Then()   -> Validation -> 200 ok, firstName == PRAMOD

        // Full URL- https://api.zippopotam.us/IN/400084
        // Base URI- https://api.zippopotam.us
        // Base Path-/IN/400084

        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter the pin code");
        String pinCode = sc.next();

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pinCode)
                .when().log().all()
                .get()
                .then().log().all().statusCode(200);
    }
}
