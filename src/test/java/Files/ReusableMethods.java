/**
 * 
 */
package Files;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

/**
 * @author debasis panda
 *
 */
public class ReusableMethods
{
	//CONVERTING raw data into xml formate
public static XmlPath rawToXML(Response r)
{
	String response=r.asString();
	
	XmlPath x=new XmlPath(response);
	return x;
}
public static JsonPath rawToJSON(Response r)
{
	String response=r.asString();
	
	JsonPath x=new JsonPath(response);
	return x;
}

}
