package PetSwagger;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PetCRUDOperation 
{
	MainPojo payload;

	@BeforeTest
	public void data()
	{
		 payload=new MainPojo();
		 payload.setId(1);
		 Category category=new Category();
		 category.setId(23);
		 category.setName("Animal");
		 payload.setCategory(category);
		 payload.setName("doggie");
		 String[] url= {"http://photourl"};
		 payload.setPhotoUrls(url);
		 Tags tag=new Tags();
		 tag.setId(23);
		 tag.setName("petAnimal");
		 List<Tags>tags =new ArrayList<Tags>();
		 tags.add(tag);
		 payload.setTags(tags);
		 payload.setStatus(0); 
	}
	
	@Test
	public void CreatePet()
	{
		RestAssured.given()
		.header("Content-Type","application/json")
		.body(payload)
		.when()
		.post("https://petstore.swagger.io/v2/pet")
		.then();
	}
}
