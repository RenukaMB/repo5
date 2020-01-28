package Jira_API;

import static io.restassured.RestAssured.given;

import Files.ReusableMethods;
import Files.resources;



import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JiraBasics02getkey
{
	//@Test
	public static String Jiraapi()
	{
		//creating a session
		RestAssured.baseURI="http://localhost:8010";
		Response res =given()
		.header("Content-Type", "application/json")
		.body("{\r\n" + 
				"	\"username\":\"renukamb\", \"password\":\"renuka1234\" \r\n" + 
				"}\r\n")
		.when()
		.post(resources.postresource())
		.then().statusCode(200)
		.extract().response();
		JsonPath js=ReusableMethods.rawToJSON(res);
		String sessionvale=js.get("session.value");
		System.out.println(sessionvale);
		return sessionvale;
	}
}

