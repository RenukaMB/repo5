package Jira_API;

import static io.restassured.RestAssured.given;


import org.testng.annotations.Test;

import Files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Createissue 
{
//public static String x =JiraBasics02getkey.Jiraapi();

@Test
public static String Createnewissue()
{
	
		//RestAssured.baseURI=prob.getProperty("HOST1");
	RestAssured.baseURI="http://localhost:8010";
		Response res=given()
		.header("Content-Type", "application/json")
		.header("cookie", "JSESSIONID="+CreateCommenttoexistingusingPut.x)
		.body("{\r\n" + 
				"\"fields\": {\r\n" + 
				"        \"project\": {\r\n" + 
				"            \"key\": \"NEW\"\r\n" + 
				"        },\r\n" + 
				"        \"summary\": \"add issue to jira \",\r\n" + 
				"        \"issuetype\": {\r\n" + 
				"            \"name\": \"Bug\"\r\n" + 
				"        }\r\n" + 
				"        \r\n" + 
				"}\r\n" + 
				"}")
		.when()
		.post("/rest/api/2/issue")
		.then().statusCode(201)
		.extract().response();
		JsonPath js=ReusableMethods.rawToJSON(res);
		String issueid=js.get("id");
		System.out.println("CREATING THE NEW ISSUE ID"+issueid);
		return issueid;
	
		
		}

}
