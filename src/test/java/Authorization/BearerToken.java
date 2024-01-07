package Authorization;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BearerToken 
{
	@Test
	public void Bearer()
	{
				Response response=RestAssured.given()
				.baseUri("https://gorest.co.in/public/v2")
				.header(null)
				.log().all()
				.when()
				.get("/users")
				.then().log().all().extract().response();
				
				int status=response.statusCode();
				String success=response.jsonPath().getString("authenticated");
				
				Assert.assertEquals(status,200);
				Assert.assertEquals(success, "true");
				
			}	
	}
