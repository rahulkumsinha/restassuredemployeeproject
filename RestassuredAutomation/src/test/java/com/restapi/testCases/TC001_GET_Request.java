package com.restapi.testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	
	@Test
	void getemployeesDetails() {
		
		//Specify base URI
		
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		
		Response response = httpRequest.request(Method.GET, "/employees");
		
		//Print Response in console window
		
		String responseBody = response.getBody().asString();
		
		System.out.println("Response body is :" +responseBody);
		
		//status code validation
		
		int statuscode = response.getStatusCode();
		
		System.out.println("Statuscode is :" +statuscode);
		
		Assert.assertEquals(statuscode, 200);
		
		//Status line verification
		
		String statusline = response.getStatusLine();
		
		System.out.println("statusline is : "+statusline);
		
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}
	

}
