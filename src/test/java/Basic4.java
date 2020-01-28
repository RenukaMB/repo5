import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import Files.resources;
import Files.payload;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * 
 */

/**
 * @author debasis panda
 *
 */
public class Basic4
{
	Properties prob=new Properties();
	@BeforeMethod
	public void getdata() throws IOException
	{
		
		FileInputStream file=new FileInputStream("C:\\Users\\debasis panda\\Desktop\\Renuka\\Rest_API_Practice\\src\\test\\java\\Files\\env.properties");
		prob.load(file);
		prob.get("HOST");
	}
	@Test
	public void test3()
	{ //task -1 grab the response
	
		RestAssured.baseURI=prob.getProperty("HOST");
		Response res =given().
		queryParam("key", "qaclick123")
		.body(payload.getPostData())
		.when()
		.post(resources.placePostdata()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
		.body("status",equalTo("OK"))
		.extract().response();
		String Responsestring=res.asString();
		System.out.println("Responsestring is : "+Responsestring);
		
		//task-2, grab the place id from the response
		JsonPath js=new JsonPath(Responsestring);
		String PlaceID = js.get("place_id");
		System.out.println("PlaceID : "+PlaceID);
		//grabe place id and delete in subsequent 
		given().queryParam("key", "qaclick123")
		.body("{"+
		   " \"place_id\":\""+PlaceID+"\""+          //(This value comes from Add place response)
		"}").when().post("/maps/api/place/delete/json")
		.then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
		.body("status",equalTo("OK"));

}}
