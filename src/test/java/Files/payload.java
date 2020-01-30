/**
 * 
 */
package Files;

import Jira_API.GetDatatoJiraAPI;
import MainPOJO.GetDatatoJiraAPI.GetBodydata;
import MainPOJO.GetDatatoJiraAPI.GetBodydata.dataissuetype;
import MainPOJO.GetDatatoJiraAPI.GetBodydata.dataproject;
import MainPOJO.GetDatatoJiraAPI.GetBodydata.fieldsdata;
import MainPOJO.GetDatatoJiraAPI.datatonewcomment;
import MainPOJO.GetDatatoJiraAPI.datatonewcomment.datatovisibility;

/**
 * @author debasis panda
 *
 */
public class payload 
{
public static String getPostData() 
{
	String b="{"+

		   " \"location\":{"+

	       " \"lat\" : -38.383494,"+

	       " \"lng\" : 33.427362"+
	       " },"+

	        "\"accuracy\":50,"+

	       " \"name\":\"Frontline house\","+

	        "\"phone_number\":\"(+91) 983 893 3937\","+

	        "\"address\" : \"29, side layout, cohen 09\","+

	       " \"types\": [\"shoe park\",\"shop\"],"+

	        "\"website\" : \"http://google.com\","+

	        "\"language\" : \"French-IN\""+
		"}" ;
	return b;
}
public static String AddBokk(String isbn, String aisle) 
{
	String payload="{\r\n\"name\":\"Learn Appium Automation with Java\",\r\n\"isbn\":\""+isbn+"\",\r\n\"aisle\":\""+aisle+"\",\r\n\"author\":\"John foe\"\r\n}\r\n";
	return payload;
//passing data into pojoclass(GetDatatoJiraAPI) to create session 	
}
public static GetDatatoJiraAPI getuserlogindata()
{
	GetDatatoJiraAPI A=new GetDatatoJiraAPI();
	A.setPassword("renuka1234");
	A.setUsername("renukamb");
	GetDatatoJiraAPI B=A;
	return B;
	}

//passing data in to pjoclass(GetBodydata) to create new issue 
public static dataproject getdataproject()
{
	dataproject C=new dataproject();
	C.setKey("NEW");
	dataproject D=C;
	return D;
	}
public static dataissuetype getdataissuetype()
{
	dataissuetype E=new dataissuetype();
	E.setName("Bug");
	dataissuetype F=E;
	return F;
	
			}
public static fieldsdata getfieldsdata()
{
	fieldsdata G=new fieldsdata();
	G.setSummary("new issue afternoon");
	G.setIssuetype(getdataissuetype());
	G.setProject(getdataproject());
	fieldsdata H=G;
	return H;
	}
public static GetBodydata datatoGetBodydata()
{
	GetBodydata I=new GetBodydata();
	I.setFields(getfieldsdata());
	GetBodydata J=I; 
	return J;
}
//passing data in to pojoclass (datatonewcomment)create new comment
public static datatovisibility getdatatovisibility()
{
	datatovisibility K=new datatovisibility();
	K.setType("role");
	K.setValue("Administrators");
	datatovisibility L=K;
	return L;
	
	}
public static datatonewcomment getdatatonewcomment() 
{
	datatonewcomment M=new datatonewcomment();
	M.setBody("add my comment to issue");
	M.setVisibility(getdatatovisibility());
	datatonewcomment N=M; 
	return N;
}
//passing data in to pojo class (datatoexistingcomment)create existing comment 
public static datatovisibility getdatatoexistingvisibility()
{
	datatovisibility O=new datatovisibility();
	O.setType("role");
	O.setValue("Administrators");
	datatovisibility P=O;
	return P;
	
	}
public static datatonewcomment getdatatoexistingcomment() 
{
	datatonewcomment Q=new datatonewcomment();
	Q.setBody("Upate comment to existing ");
	Q.setVisibility(getdatatovisibility());
	datatonewcomment R=Q; 
	return R;
}

}
