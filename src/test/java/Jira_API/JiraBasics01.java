package Jira_API;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static io.restassured.RestAssured.given;

import Files.ReusableMethods;
import Files.resources;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JiraBasics01
{
	Properties prob=new Properties();
	@BeforeMethod
	public void getdata() throws IOException
	{
		
		FileInputStream file=new FileInputStream("C:\\Users\\debasis panda\\Desktop\\Renuka\\Rest_API_Practice\\src\\test\\java\\Files\\env.properties");
		prob.load(file);
		//prob.get("HOST1");
	}
	@Test
	public void Jiraapi()
	{
		//creating a session
		RestAssured.baseURI=prob.getProperty("HOST1");
		Response res =given()
		.header("Content-Type", "application/json")
		.body("{\r\n" + 
				"	\"username\":\"renukamb\", \"password\":\"renuka1234\" \r\n" + 
				"}\r\n")
		.when()
		.post(resources.postresource())
		.then().statusCode(200)
		.extract().response()
		;
		JsonPath js=ReusableMethods.rawToJSON(res);
		String sessionvale=js.get("session.value");
		System.out.println(sessionvale);
	}
}
