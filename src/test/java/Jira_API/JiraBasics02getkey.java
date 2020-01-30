package Jira_API;

import static io.restassured.RestAssured.given;

import Files.ReusableMethods;
import Files.payload;
import Files.resources;



import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JiraBasics02getkey extends Beforjiraissue 
{
	//@Test
	public static String Jiraapi()
	{
		//creating a session
		
		Response res =given()
		.header("Content-Type", "application/json")
		.body(payload.getuserlogindata())
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

