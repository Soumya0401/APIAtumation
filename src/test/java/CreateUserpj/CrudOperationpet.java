package CreateUserpj;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class CrudOperationpet
{
	Mainpojo payload;
	@BeforeClass
	public void dataSet()
	{
		PetCategory category= new PetCategory();
		category.setPetId(1);
		category.setName("animal");
		PetTags tag=new PetTags();
		tag.setTagId(1);
		tag.setTagName("petAnimal");
		
		payload=new Mainpojo();
		payload.setId(1);
		payload.setName("doggie");
		payload.setCate(category);	
		
	}
	
	
	public void CreatePet()
	{
		RestAssured.given()
		.body(payload)
		.when()
		.then();
	}

}
