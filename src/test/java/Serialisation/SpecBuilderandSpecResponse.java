package Serialisation;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;


public class SpecBuilderandSpecResponse {

	public static void main(String[] args) 
	{
		AddPlace p=new AddPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setPhone_number("(+91) 983 893 3912");
		p.setWebsite("http://google.com");
		p.setName("Nsew house");
		// have to add list types of values to types
		List<String> mylist=new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");
		p.setTypes(mylist);
		AddLocation L=new AddLocation();
		L.setLat(-38.383494);
		L.setLng(33.427362);
		p.setLocation(L);
		//Spec builder 
	RequestSpecification	req=new RequestSpecBuilder().setBaseUri("http://216.10.245.166")
			.addQueryParam("key", "qaclick123")
			.setContentType(ContentType.JSON).build();
	RequestSpecification res=given().spec(req)
		.body(p);
	 ResponseSpecification resp=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	Response response=res.when()
		.post("/maps/api/place/add/json")
		.then().spec(resp)
		.extract().response();
	String responsestring=response.asString();
	System.out.println("responsestring is = "+responsestring);
	}

}
