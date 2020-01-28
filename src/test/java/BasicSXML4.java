import static io.restassured.RestAssured.given;


import java.io.IOException;
import java.nio.file.Files;
import Files.ReusableMethods;

import java.nio.file.Paths;

import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;


/**
 * 
 */

/**
 * @author debasis panda
 *
 */
public class BasicSXML4
{

	@Test
	public void createXmldata() throws IOException
	{
		String postdat=GenerateStringFormResource("C:\\Users\\debasis panda\\Documents\\postdata.xml");
		RestAssured.baseURI="http://216.10.245.166";
		Response res =given().
		queryParam("key","qaclick123").
		body(postdat).
		when().
		post("/maps/api/place/add/xml").
		then().assertThat().statusCode(200).and().contentType(ContentType.XML)
		//.and().
		//body("status",equalTo("OK")).and()
		.extract().response();
		XmlPath x=ReusableMethods.rawToXML(res);
		
		System.out.println(x.get("response.status"));
		

		
		
	}
public static String GenerateStringFormResource(String path) throws IOException 
	{
		return new String(Files.readAllBytes(Paths.get(path)));
	}
	
}