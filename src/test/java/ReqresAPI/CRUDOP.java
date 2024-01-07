package ReqresAPI;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class CRUDOP 
{
	@Test(priority=1)
	public void getUser()
	{
		given()
		.baseUri("https://reqres.in/")
		.log().all()
		.when()
		.get("api/users?page=2")
		.then()
		.log().all()
		.statusCode(200);
	}
	
	@Test(priority=2)
	public void createUser()
	{
		String payload="{\r\n" 
					+ "		\"name\":\"Soumya\",\r\n"
					+"		\"job\":\"Team Lead\"\r\n"
					+"}";
		given()
		.baseUri("https://reqres.in/")
		.headers("Content-Type","application/json")
		.body(payload)
		.log().all()
		.post("api/users")
		.then()
		.log().all()
		.statusCode(201);
		
	}
	@Test(priority=3)
	public void UpdateUser()
	{
		String payload="{\r\n" 
				+ "		\"name\":\"Soumya Raj\",\r\n"
				+"		\"job\":\"Team Leader\"\r\n"
				+"}";
				given()
				.baseUri("https://reqres.in/")
				.headers("Content-Type","application/json")
				.body(payload)
				.log().all()
				.patch("api/users/2")
				.then()
				.log().all()
				.statusCode(200);
		
	}
	
	@Test(priority=4 , enabled=false)
	public void DeleteUser()
	{
		given()
		.baseUri("https://reqres.in/")
		.log().all()
		.when()
		.delete("api/users/2")
		.then()
		.log().all()
		.statusCode(200);		
	}
}
