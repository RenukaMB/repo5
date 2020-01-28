import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import org.testng.annotations.Test;

import Files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Staticjsonaddnewbook 
{

	@Test
	public void addBokk() throws IOException  
	{
		RestAssured.baseURI="http://216.10.245.166";
		Response res =given().
				header("Content-Type","application/json")
	    .body(GenerateStringFormResource("C:\\Users\\debasis panda\\Desktop\\Renuka\\dataofbooks.json")).
				
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
	public static String GenerateStringFormResource(String path) throws IOException 
	{
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}
