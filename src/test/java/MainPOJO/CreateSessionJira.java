package MainPOJO;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import com.google.gson.Gson;

import Files.ReusableMethods;
import Files.payload;
import Files.resources;
import MainPOJO.SessionPojo.LoginInfo;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateSessionJira extends Beforjiraissue 
{
	//@Test
	public static String Jiraapi()
	{
		//creating a session
		
		Response res=given()
		.header("Content-Type", "application/json")
		.body(payload.getuserlogindata())
		.when()
		.post(resources.postresource())
		
		.then().statusCode(200)
		.extract().response();
		JsonPath js=ReusableMethods.rawToJSON(res);
		String sessionvale=js.get("session.value");
		System.out.println(sessionvale);
		
		
		String responseOutput=res.asString();
		Gson gson = new Gson();
		 SessionPojo session = gson.fromJson(responseOutput, SessionPojo.class);
	
		 
			 System.out.println("Sessiong login Info...." + session.getSession().getName());
			 
				 LoginInfo login = session.getLoginInfo();

				 String lastFailedTime = login.getLastFailedLoginTime();

				 String expectedTime = "2020-01-22T12:44:03.543+0530";

				 Assert.assertEquals(expectedTime, lastFailedTime, "Both the times are not same");
				// System.out.println(session.toString());
			//	System.out.println(login.toString());
				 return sessionvale;
	}
}

