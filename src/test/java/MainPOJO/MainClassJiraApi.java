package MainPOJO;

import static io.restassured.RestAssured.given;


import org.testng.annotations.Test;

import com.google.gson.Gson;

import Files.ReusableMethods;
import Files.payload;
import Files.resources;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class MainClassJiraApi extends Beforjiraissue
{
@Test
	public static void getallData()
	{
		String x =CreateSessionJira.Jiraapi();
		RequestSpecification req=new RequestSpecBuilder().addHeader("Content-Type", "application/json").addHeader("cookie", "JSESSIONID="+x).build();
		 ResponseSpecification resp=new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
		ResponseSpecification resp1=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		ResponseSpecification resp2=new ResponseSpecBuilder().expectStatusCode(204).expectStatusLine("HTTP/1.1 204 ").build();
		
		//Create a new issue
		RequestSpecification res=given().spec(req)
		.body(payload.datatoGetBodydata());
		Response response=res.when()
		.post(resources.createissuepost())
		.then().spec(resp)
		.extract().response();
		
		//we can grab an issue id by using jsonpath
		
		//JsonPath js=ReusableMethods.rawToJSON(response);
		//	String issueid=js.get("id");
		//System.out.println("issue id of create issue = "+issueid);
			
		//we can grab an issue id by using pojoclass
		
		String responseOutput1=response.asString();
		Gson gson1 = new Gson();
		CreateIssueResponsePojo issue= gson1.fromJson(responseOutput1, CreateIssueResponsePojo.class);
		String issueid=issue.getId();
		 System.out.println("issue id of create issue= " +issueid );

		// add comment
		
		RequestSpecification res1=given().spec(req)
		.body(payload.getdatatonewcomment());
		 Response response1= res1.when()
		.post(resources.createcommentpost(issueid))
		.then().spec(resp)
		.extract().response();
		
		//we can grab an issue id by using jsonpath
	 
		 JsonPath js1=ReusableMethods.rawToJSON(response1);
		 String commentid=js1.get("id");
		 System.out.println("updating the issue with comment = "+ commentid);

		//update my prevoiue comment
		
		RequestSpecification res2=given().spec(req)
		.body(payload.getdatatoexistingcomment());
		Response response2=res2.when()
		.put(resources.updatecommentput(issueid, commentid))
		.then().spec(resp1)
		.extract().response();
		JsonPath js2=ReusableMethods.rawToJSON(response2);
		String updatecommentid=js2.get("id");
		System.out.println("my latest commient id after upadting existing comment = "+updatecommentid);	
				
		//delete a updated comments
		
		RequestSpecification res3= given().spec(req);
		 res3.when()
		.delete(resources.deletecomment(issueid, updatecommentid))
		.then().spec(resp2)
		.extract().response();
			
		 //delete an issue what we are created
		
		 RequestSpecification res4=   given().spec(req);
		 res4.when()
		.delete(resources.deleteissue(issueid))
		.then().spec(resp2)
		.extract().response();
		}
		}
