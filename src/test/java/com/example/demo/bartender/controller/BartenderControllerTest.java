package com.example.demo.bartender.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BartenderControllerTest {

	@LocalServerPort
	private int port;

	@Test
	void controllerGetMethodTest() {
		RestAssured.given().log().all().and().accept(ContentType.JSON).port(port).when()
				.get("/bartender/iterations=5/stackId=4").then().log().all()
				.statusCode(HttpStatus.OK.value());
	}

}
