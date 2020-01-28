import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.ReusableMethods;
import Files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DynamicJson 
{

	@Test(dataProvider="BooksData")
	public void addBokk(String isbn,String aisle) throws IOException
	{
		RestAssured.baseURI="http://216.10.245.166";
		Response res =given().
				header("Content-Type","application/json")
	.body(payload.AddBokk(isbn,aisle)).
				
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
	@DataProvider(name="BooksData")
	public Object[][] getdata()
	{
		//array=collection of elements,
		//multidimensional array=collection of array 
		return new Object[][] {{"addsa","1231"},{"addsb","1232"},{"addsc","1233"},};
	}
}
