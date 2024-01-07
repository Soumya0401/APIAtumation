package SoapCal;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Calculator
{
	int addresult=0;
	int subresult=0;
	int mulresult=0;
	int divideresult=0;
	
	@Test(priority=1)
		public void Add()
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
	
	@Test(priority=2)
	public void Subtract()
	{
		String payload="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <Subtract xmlns=\"http://tempuri.org/\">\r\n"
				+ "      <intA>"+addresult+"</intA>\r\n"
				+ "      <intB>10</intB>\r\n"
				+ "    </Subtract>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>";
				
				Response response=RestAssured.given()
				.baseUri("http://www.dneonline.com")
				.header( "Content-Type"," text/xml; charset=utf-8")
				.body(payload)
				.log().all()
				.when()
				.post("http://www.dneonline.com/calculator.asmx?op=Subtract")
				.then().log().all().extract().response();
				 subresult=response.xmlPath().getInt("Envelope.Body.SubtractResponse.SubtractResult");
				System.out.println( subresult);
	}
	
	@Test(priority=3)
	public void Multiply()
	{
		String payload="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <Multiply xmlns=\"http://tempuri.org/\">\r\n"
				+ "      <intA>"+subresult+"</intA>\r\n"
				+ "      <intB>10</intB>\r\n"
				+ "    </Multiply>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>";
				
				Response response=RestAssured.given()
				.baseUri("http://www.dneonline.com")				
				.header( "Content-Type"," text/xml; charset=utf-8")
				.body(payload)
				.log().all()
				.when()
				.post("http://www.dneonline.com/calculator.asmx?op=Multiply")
				.then().log().all().extract().response();
				mulresult=response.xmlPath().getInt("Envelope.Body.MultiplyResponse.MultiplyResult");
				System.out.println( mulresult);
	}
	@Test(priority=4)
	public void Divide()
	{
		String payload="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <Divide xmlns=\"http://tempuri.org/\">\r\n"
				+ "      <intA>"+mulresult+"</intA>\r\n"
				+ "      <intB>20</intB>\r\n"
				+ "    </Divide>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>";
				
				Response response=RestAssured.given()
				.baseUri("http://www.dneonline.com")				
				.header( "Content-Type"," text/xml; charset=utf-8")
				.body(payload)
				.log().all()
				.when()
				.post("http://www.dneonline.com/calculator.asmx?op=Multiply")
				.then().log().all().extract().response();
				divideresult=response.xmlPath().getInt("Envelope.Body.DivideResponse.DivideResult");
				System.out.println( divideresult);
	}
	

}
