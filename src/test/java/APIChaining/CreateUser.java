package APIChaining;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CreateUser 
{
	int id;
	@Test(priority=1)
	public void Create()
	{
		HashMap<String,Object> payload=new HashMap<String,Object>();
		payload.put("name","Soumya");
		payload.put("job", "QA");
		
		Response response=RestAssured.given()
		.baseUri("https://reqres.in")
		.header("Content-Type","application/json")
		body(payload)
		log().all()
		.when()
		.post("api/users")
		.then().log().all().extract().response();
		id=response.jsonPath().getInt("id");
	}
	@Test(priority=2)
	public void UpdateUser()

}
