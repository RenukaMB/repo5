import static io.restassured.RestAssured.given;


import java.io.IOException;

import Files.ReusableMethods;



import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


/**
 * 
 */

/**
 * @author debasis panda
 *
 */
public class excelDriven
{

	@Test
	public void addBokk() throws IOException
	{
		RestAssured.baseURI="http://216.10.245.166";
		Response res =given().
				header("Content-Type","application/json").
		body("{\r\n\"name\":\"Learn Appium Automation with Java\",\r\n\"isbn\":\"bcdbcdcd\",\r\n\"aisle\":\"2272\",\r\n\"author\":\"John foe\"\r\n}\r\n").
		when().
		post("/Library/Addbook.php").
		then().assertThat().statusCode(200).
		//.and().
		//body("status",equalTo("OK")).and()
		extract().response();
	
		JsonPath js=ReusableMethods.rawToJSON(res);
		String id=js.get("ID");
		System.out.println(id);
}
}