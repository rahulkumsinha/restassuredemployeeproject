package datadriventesting;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest_AddNewEmployees {
	
	@Test(dataProvider="empdataprovider")
	void postNewEmployees(String ename, String eage, String esal)
	{
		
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";

		//Request Object
		RequestSpecification httpRequest = RestAssured.given();

		//Request payload sending along with post request

		JSONObject requestParams =new JSONObject(); 

		requestParams.put("name", ename);
		requestParams.put("salary", eage);
		requestParams.put("age", esal);
		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(requestParams.toJSONString()); //attach above data to the request

		//Response Object

		Response response = httpRequest.request(Method.POST, "/create");

		//Print Response in console window

		String responseBody = response.getBody().asString();

		System.out.println("Response body is :" +responseBody);
		
		Assert.assertEquals(responseBody.contains(ename), true);
		Assert.assertEquals(responseBody.contains(eage), true);
		Assert.assertEquals(responseBody.contains(esal), true);

		//status code validation

		int statuscode = response.getStatusCode();

		System.out.println("Statuscode is :" +statuscode);

		Assert.assertEquals(statuscode, 200);
		
	}
	
	
	@DataProvider(name="empdataprovider")
	String [][] getEmpData() throws IOException
	{
		//Read Data from Excel
		String path = System.getProperty("user.dir")+"/src/test/java/datadriventesting/empdata.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String empdata[][] = new String[rownum][colcount];
		
		for (int i=1; i<=rownum; i++) {
			for(int j=0; j<colcount; j++) {
				empdata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		//String empData[][] = {{"abc123", "30000", "25"}, {"xyz123", "50000", "28"},{"pqr123", "80000", "29"}};
		return (empdata);
	}
	
	
	
	

}
