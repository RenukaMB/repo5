package Jira_API;

import static io.restassured.RestAssured.given;


import org.testng.annotations.Test;

import Files.ReusableMethods;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Getall extends Beforjiraissue
{
@Test
	public static void getallData()
	{
		String x =JiraBasics02getkey.Jiraapi();
		Response res=given()
		.header("Content-Type", "application/json")
		.header("cookie", "JSESSIONID="+x)
		.body("{\r\n" + 
				"\"fields\": {\r\n" + 
				"        \"project\": {\r\n" + 
				"            \"key\": \"NEW\"\r\n" + 
				"        },\r\n" + 
				"        \"summary\": \"create a issue\",\r\n" + 
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
				"	\"body\": \"add my comments to new task\",\r\n" + 
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
		System.out.println("updating the issue with comment = "+ commentid);
		
		
		//update my prevoiue comment
		
		    Response res2=given()
				.header("Content-Type", "application/json")
				.header("cookie", "JSESSIONID="+x)
				.body("{\r\n" + 
						"	\"body\": \"update a comment to task\",\r\n" + 
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
				System.out.println("my latest commient id after upadting existing comment = "+updatecommentid);	
				
				//delete a updated comments
				Response res3=given()
						.header("Content-Type", "application/json")
						.header("cookie", "JSESSIONID="+x)
						.when()
						.delete("/rest/api/2/issue/"+issueid+"/comment/"+updatecommentid+"")
						.then().assertThat().statusCode(204).statusLine("HTTP/1.1 204 ")
						.extract().response();
				

                //delete an issue what we are created
//				         given()
//						.header("Content-Type", "application/json")
//						.header("cookie", "JSESSIONID="+x)
//						.when()
//						.delete("/rest/api/2/issue/"+issueid+"")
//						.then().assertThat().statusCode(204).statusLine("HTTP/1.1 204 ");
//						
//				
	
	}
}
