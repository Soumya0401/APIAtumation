package CreateUserpj;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class getcoursesusingpojo 
{
	@Test
	public void getcourses()
	{
		RestAssured.given()
		.when()
		.get("https://6e49d649-c6f7-4c5e-a395-2707499d3a71.mock.pstmn.io/getcourse")
		.then().log().all().statusCode(200);
		
	}

}
