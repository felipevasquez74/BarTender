package com.example.demo.bartender.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

class BartenderControllerTest {
	
	@Test
	void controllerGetMethodTest() {
		RestAssured.given().log().all().and().accept(ContentType.JSON).when()
				.get("http://localhost:8080/bartender/iterations=5/stackId=4")
				.then()
				.log()
				.all()
				.statusCode(HttpStatus.OK.value());
	}

}
