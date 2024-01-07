package RequestResponseSpec;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Reqrescrudop 
{
	int id;
	RequestSpecification request= new RequestSpecBuilder().setBaseUri("https://reqres.in/").setContentType(ContentType.JSON).build();
	ResponseSpecification resSpec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	@Test(priority=1)
	public void CreateUser()
	{
		HashMap<String,Object>payload=new HashMap<String,Object>();
		payload.put("name", "Soumya");
		payload.put("job", "QA");
		
		RequestSpecification res=given().spec(request)
		.body(payload);
		res.when().post("/api/users")
		.then().spec(resSpec);
	}
	
	@Test(priority=2)
	public void UpdateUser()
	{
		String payload="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
				Rest Assured
		
		RequestSpecification res=given().spec(request)
		.body(payload);
		
		ResponseSpecification 
		res.when().post("/api/users")
		.then().spec(resSpec);
	}
	
	
}

