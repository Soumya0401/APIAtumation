package ExternalFileUpload;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured

public class FileUpload 
{
	@Test
	public void ExternalFile()
	{
		File payload= new File("C:\\Users\\rajso\\Desktop.json");
		Response response=RestAssured.given();
		.header("Content-Type","application/json");
		.body(payload)
		.log().all()
		.when()
		.post("")
		.then().extract().response()
		
		
	}

}
