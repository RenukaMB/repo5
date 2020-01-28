package OAuth_2;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Pojo.Api;
import Pojo.GetCourses;
import Pojo.WebAutomation;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;


public class Oauthtest {

	public static void main(String[] args) 
	{
		String[] CourseTitles= {"Selenium Webdriver Java","Cypress","Protractor"};
		String AccessTokenResponse=given()
		.queryParams("code","4%2FvwFb46FjvxzT56BszieJ3YoopGp5CIPkaKQhQNqLWjI9qhwblj4lh5hlBbOvX4nr4uUE_O6NKZ30NCcEuf5cVKU")// get a code from browser by doing ui auto
		.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type","authorization_code")
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath js=new JsonPath(AccessTokenResponse);
		System.out.println(AccessTokenResponse);
		String accestoken=js.getString("access_token");
		System.out.println("accesstoken i found= "+accestoken);
		
		
		
		
		
		
		
		
		GetCourses getcourse=given().queryParam("access_token","ya29.ImC7B1BHf2sgHYqoAvOLla3kSMaMjuK87_1FzjewUv6QUK87tUby-ZIXRYSXDk3Iuv1m61HeQS7PM9f2XKhT8DP0BSf2kqkaIaSOk-HNQd9fVT0J2rBZVD5YDybXxMFcxFY").expect().defaultParser(Parser.JSON)
		.when()
		.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourses.class);
		System.out.println(getcourse.getExpertise());
		System.out.println(getcourse.getLinkedIn());
		System.out.println(getcourse.getCourses().getMobile().get(0).getPrice());
	List<Api>	apicourses=getcourse.getCourses().getApi();
	for(int i=0;i<apicourses.size();i++)
	{
		if(apicourses.get(i).getCourseTitle().equalsIgnoreCase("Rest Assured Automation using Java"))
		{
			System.out.println(apicourses.get(i).getPrice());
		}
	}
	ArrayList<String> a=new ArrayList<String>();
    		List<WebAutomation>	W=getcourse.getCourses().getWebAutomation();
    		for(int j=0;j<W.size();j++)
    		{
    		a.add(W.get(j).getCourseTitle());
    		}
    		List<String> expectedlist=Arrays.asList(CourseTitles);
    		assertTrue(a.equals(expectedlist));
		
	}

}
