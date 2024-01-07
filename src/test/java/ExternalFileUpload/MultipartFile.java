package ExternalFileUpload;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class MultipartFile 
{
	@Test
	public void FileAdd()
	{
	RestAssured.given()
	multipart(new File("C:\\Users\\rajso\\Desktop//Gmail Test Case.xls"))
	.baseUri("https://postman-echo.com/")
	.log().all()
	.when()
	
	
	}
}
