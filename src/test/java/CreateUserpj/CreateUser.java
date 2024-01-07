package CreateUserpj;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateUser
{
	@Test
	public void Create()
	{
	GETSET payload=new GETSET ();
	payload.setid(1);
	payload.setfirstName("Soumya");
	payload.setlastName("Raj");
	payload.setemail("soumya@123.com");
	payload.setpassword("Light@12345");
	payload.setphone("887775544");
	
	  RestAssured.given()
	  .contentType(ContentType . JSON)
	  .body(payload)
	  .log().all()
	  .when()
	  .post("https://petstore.swagger.io/#/user/createUser").then().log().all();
	}
}
