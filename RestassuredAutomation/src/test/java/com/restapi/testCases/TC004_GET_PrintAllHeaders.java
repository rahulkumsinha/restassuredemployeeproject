package com.restapi.testCases;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_PrintAllHeaders {

	@Test
	void getSingleemployeesDetail() {

		//Specify base URI

		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";

		//Request Object
		RequestSpecification httpRequest = RestAssured.given();

		//Response Object

		Response response = httpRequest.request(Method.GET, "/employee/1");

		//Print Response in console window

		String responseBody = response.getBody().asString();

		System.out.println("Response body is :" +responseBody);

		//Capture all headers from response

		Headers allheaders = response.headers();

		for(Header header : allheaders)
		{
			System.out.println(header.getName()+"      "+header.getValue());
		}

	}


}


