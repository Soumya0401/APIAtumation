package PetSwaggerUI;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;


public class FakerDemo
{
	Faker faker;
	@Test
	public void Create_User()
	{
		HashMap<String,Object> payload=new HashMap<String,Object>();
		payload.put("id", faker.number());
		payload.put("username", faker.name());
		payload.put("firstName", faker.name().firstName());
		payload.put("lastName", faker.name().lastName());
		payload.put("email", faker.internet().emailAddress());
		payload.put("password", faker.internet().password());
		payload.put("phone", faker.phoneNumber().phoneNumber());
		payload.put("userStatus", 0);
		
		RestAssured .given()
		.baseUri("https://petstore.swagger.io/v2/")
		.header("Content-Type","application/json")
		.body("payload")
		.log().all()
		.when()
		.post("/user")
		.then()
		.log().all().statusCode(200);
	}
		}


