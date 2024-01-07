package ReqresAPI;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerCreateUser 
{
	@Test
	public void CreateUser()
	{
		Faker faker=new Faker();
		HashMap<String,Object>payload=new HashMap<String,Object>();
		payload .put("name", faker.name().firstName());
		payload.put("job", "SQA");
		payload.put("email", faker.internet().emailAddress());
		
		given()
		.header("Content-Type","application/json")
		.body(payload)
		.log().all()
		.when()
		.post("https://reqres.in/api/users")
		.then().log().all();
		
	}

}
