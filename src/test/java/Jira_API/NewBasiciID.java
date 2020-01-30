package Jira_API;

import static io.restassured.RestAssured.given;


import Files.ReusableMethods;
import Files.resources;



import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class NewBasiciID {
	
//@Test
		public  static String Jiraapi()
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
			
		     given()
			.header("Content-Type", "application/json")
			.header("cookie", "JSESSIONID="+sessionvale)
			.body("{\r\n" + 
					"\"fields\": {\r\n" + 
					"        \"project\": {\r\n" + 
					"            \"key\": \"NEW\"\r\n" + 
					"        },\r\n" + 
					"        \"summary\": \"jira new issue adding to a project \",\r\n" + 
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
			JsonPath js1=ReusableMethods.rawToJSON(res);
			String issueid=js1.get("id");
			String issuekey=js1.get("key");
			System.out.println(issueid);
			System.out.println(issuekey);
			return issueid;
		
			
		}
		}




