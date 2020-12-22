package com.restapi.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_ExtractValuesOfEachNodeInJSON {

	@Test
	void getemployeesDetails() {

		//Specify base URI

		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";

		//Request Object
		RequestSpecification httpRequest = RestAssured.given();

		//Response Object
		
		Response response = httpRequest.request(Method.GET, "/employees");
		
		response.prettyPrint();

		JsonPath jsonpath = response.jsonPath();
		
		System.out.println(jsonpath.get("status"));
		
		System.out.println(jsonpath.get("data"));
		
		Assert.assertEquals(jsonpath.get("status"), "success");
		


	}


}



