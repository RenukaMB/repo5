package Jira_API;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import Files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateCommenttoIssue 
{
@Test
public static String Createnewcomments()
{
		
		RestAssured.baseURI="http://localhost:8010";
		Response res=given()
		.header("Content-Type", "application/json")
		.header("cookie", "JSESSIONID="+CreateCommenttoexistingusingPut.x)
		.body("{\r\n" + 
				"	\"body\": \"add comment to jira issue\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}")
		.when()
		.post("/rest/api/2/issue/"+CreateCommenttoexistingusingPut.y+"/comment")
		.then()
		.extract().response();
		JsonPath js=ReusableMethods.rawToJSON(res);
		String commentid=js.get("id");
		System.out.println("my comment is created"+commentid);
		return commentid;
			
		}

}
