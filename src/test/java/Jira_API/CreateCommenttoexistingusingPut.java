package Jira_API;

import static io.restassured.RestAssured.given;
import Jira_API.CreateCommenttoIssue;


import org.testng.annotations.Test;

import Files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateCommenttoexistingusingPut 
{
	public static String x =JiraBasics02getkey.Jiraapi();
	public static String y=Createissue.Createnewissue();
	public static String z=CreateCommenttoIssue.Createnewcomments();

	
@Test
public void Createnewissue()
{

	RestAssured.baseURI="http://localhost:8010";
		
		
		
		Response res=given()
		.header("Content-Type", "application/json")
		.header("cookie", "JSESSIONID="+x)
		.body("{\r\n" + 
				"	\"body\": \"udate comment to existing \",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}")
		.when()
		.put("/rest/api/2/issue/"+y+"/comment/"+z+"")
		.then()
		.extract().response();
		JsonPath js=ReusableMethods.rawToJSON(res);
		String updatedcommentid=js.get("id");
		System.out.println("my commented updtaed in jira"+updatedcommentid);		
		}

}
