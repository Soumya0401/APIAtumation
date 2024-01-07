package Authorization;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class BasicAuth 
{
	@Test
	public void Basic()
	{
		Response response=RestAssured.given()
		.baseUri("https://postman-echo.com")
		.auth().basic("postman","password")
		.log().all()
		.when()
		.get("/basic-auth")
		.then().log().all().extract().response();
		
		int status=response.statusCode();
		String success=response.jsonPath().getString("authenticated");
		
		Assert.assertEquals(status,200);
		Assert.assertEquals(success, "true");
		
	}

}
