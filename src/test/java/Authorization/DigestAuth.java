package Authorization;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DigestAuth
{
	@Test
		public void Digest()
		{
			Response response=RestAssured.given()
			.baseUri("https://postman-echo.com")
			.auth().digest("postman","password")
			.log().all()
			.when()
			.get("/digest-auth")
			.then().log().all().extract().response();
			
			int status=response.statusCode();
			String success=response.jsonPath().getString("authenticated");
			
			Assert.assertEquals(status,200);
			Assert.assertEquals(success, "true");
			
		}

	}

