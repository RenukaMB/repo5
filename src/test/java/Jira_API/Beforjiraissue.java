package Jira_API;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class Beforjiraissue 
{
	   Properties prob=new Properties();
		@BeforeMethod
		public void getdata() throws IOException
		{
			
			FileInputStream file=new FileInputStream("C:\\Users\\debasis panda\\Desktop\\Renuka\\Rest_API_Practice\\src\\test\\java\\Files\\env.properties");
			prob.load(file);
			RestAssured.baseURI=prob.getProperty("BaseURI");
		}
		
}
