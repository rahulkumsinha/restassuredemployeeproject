package com.restapi.testCases;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {

	@Test
	void createNewRecord() {

		//Specify base URI

		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";

		//Request Object
		RequestSpecification httpRequest = RestAssured.given();

		//Request payload sending along with post request

		JSONObject requestParams =new JSONObject(); 

		requestParams.put("name", "test");
		requestParams.put("salary", "123456");
		requestParams.put("age", "24");
		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(requestParams.toJSONString()); //attach above data to the request

		//Response Object

		Response response = httpRequest.request(Method.POST, "/create");

		//Print Response in console window

		String responseBody = response.getBody().asString();

		System.out.println("Response body is :" +responseBody);

		//status code validation

		int statuscode = response.getStatusCode();

		System.out.println("Statuscode is :" +statuscode);

		Assert.assertEquals(statuscode, 200);

		//status message verification

		String status = response.jsonPath().get("status");
		Assert.assertEquals(status, "success");

	}


}



