package CreateUserpj;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Pet 
{
	private int id;
	private String name;
	private List<String> photoUrls;
	private String  tags[];
	private String status;
	PetCategory petcat;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String[] getTags()
	{
		return tags;	
	}
	public void setTags(String[] tags)
	{
		this.tags=tags;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status=status;
	}
	@Test
	public void PetTags() 
	{
		
		PetTags payload=new PetTags ();
		payload.setid(1);
		payload.tagName("Dog");
		
		  RestAssured.given()
		  .contentType(ContentType . JSON)
		  .body(payload)
		  .log().all()
		  .when()
		  .post("https://petstore.swagger.io/#/pet/addPet").then().log().all();
		}
	}

