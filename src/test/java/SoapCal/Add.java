package SoapCal;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Add 
{
	int addresult=0;
	@Test
	public void Number()
	{
	String payload="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
			+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
			+ "  <soap:Body>\r\n"
			+ "    <Add xmlns=\"http://tempuri.org/\">\r\n"
			+ "      <intA>20</intA>\r\n"
			+ "      <intB>20</intB>\r\n"
			+ "    </Add>\r\n"
			+ "  </soap:Body>\r\n"
			+ "</soap:Envelope>";
	
	Response response=RestAssured.given()
	.baseUri("http://www.dneonline.com")
	.header( "Content-Type"," text/xml; charset=utf-8")
	.body(payload)
	.log().all()
	.when()
	.post("http://www.dneonline.com/calculator.asmx?op=Add")
	.then().log().all().extract().response();
	addresult=response.xmlPath().getInt("Envelope.Body.AddResponse.AddResult");
	System.out.println(addresult);
		

	}
}
