import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.equalTo;



import org.testng.annotations.Test;

import Files.ReusableMethods;

import static io.restassured.RestAssured.given;

/**
 * 
 */

/**
 * @author debasis panda
 *
 */
public class Basics_5 {

	/**
	 * @param args
	 */
	@Test
	public  void Restapi()
	{
		RestAssured.baseURI="https://maps.googleapis.com";
		Response res=given().
		param("location", "-33.8670522,151.1957362").
		param("radius","1500").param("type","restaurant").
		param("keyword","cruise").param("key","AIzaSyAQHU4ezpRsoloX8MAxJHEdzswGmUFs1Hw").log().all().//it will log all the details
		when().get("/maps/api/place/nearbysearch/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
		//.body("results[0].geometry.location.lat",equalTo("-33.8585416"));
		.body("results[0].name",equalTo("Cruise Bar")).and()
		.body("results[0].place_id", equalTo("ChIJi6C1MxquEmsR9-c-3O48ykI"))
		.and().header("Server", "scaffolding on HTTPServer2").log().all()
		.extract().response();
		JsonPath js=ReusableMethods.rawToJSON(res);
	int count=js.get("results.size()");
	
		for(int i=0;i<count;i++)
		
			{
			 
			System.out.println(js.get("results["+i+"].name"));
			
		}
		System.out.println(count);

	}
	
}
