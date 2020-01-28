package Jira_API;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Getall 
{
@Test
	public static void getallData()
	{
		String x =JiraBasics02getkey.Jiraapi();
		//RestAssured.baseURI=prob.getProperty("HOST1");
	RestAssured.baseURI="http://localhost:8010";
		Response res=given()
		.header("Content-Type", "application/json")
		.header("cookie", "JSESSIONID="+x)
		.body("{\r\n" + 
				"\"fields\": {\r\n" + 
				"        \"project\": {\r\n" + 
				"            \"key\": \"NEW\"\r\n" + 
				"        },\r\n" + 
				"        \"summary\": \"my isue task\",\r\n" + 
				"        \"issuetype\": {\r\n" + 
				"            \"name\": \"Task\"\r\n" + 
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
		System.out.println("issue id of create issue = "+issueid);
		
		
		
		// add comment
		//RestAssured.baseURI="http://localhost:8010";
		Response res1=given()
		.header("Content-Type", "application/json")
		.header("cookie", "JSESSIONID="+x)
		.body("{\r\n" + 
				"	\"body\": \"update my commet with new\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}")
		.when()
		.post("/rest/api/2/issue/"+issueid+"/comment")
		.then()
		.extract().response();
		JsonPath js1=ReusableMethods.rawToJSON(res1);
		String commentid=js1.get("id");
		System.out.println("updating the issue with comment"+ commentid);
		
		
		//update my prevoiue comment
		
		    Response res2=given()
				.header("Content-Type", "application/json")
				.header("cookie", "JSESSIONID="+x)
				.body("{\r\n" + 
						"	\"body\": \"my latest comment is get updated\",\r\n" + 
						"    \"visibility\": {\r\n" + 
						"        \"type\": \"role\",\r\n" + 
						"        \"value\": \"Administrators\"\r\n" + 
						"    }\r\n" + 
						"}")
				.when()
				.put("/rest/api/2/issue/"+issueid+"/comment/"+commentid+"")
				.then()
				.extract().response();
				JsonPath js2=ReusableMethods.rawToJSON(res2);
				String updatecommentid=js2.get("id");
				System.out.println("my latest commient id i"+updatecommentid);	
		
				
	
	}
}
