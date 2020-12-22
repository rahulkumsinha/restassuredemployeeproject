package com.restapi.testCases;

	import org.testng.Assert;
import org.testng.annotations.Test;

	import io.restassured.RestAssured;
	import io.restassured.http.Method;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;

	public class TC003_GET_Request {
		
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
			
			//Capture details of header from response
			
			String  contentType = response.header("Content-Type");
			
			System.out.println("Content type is :" +contentType);
			
			Assert.assertEquals(contentType, "application/json");
			
		}
		

	}


