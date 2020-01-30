package MainPOJO;

import MainPOJO.GetDatatoJiraAPI.datatonewcomment.datatovisibility;
//get all body data to create an issue
//creating pojo class to pass credentials to create session id 
public class GetDatatoJiraAPI
{
	private String  password;
private String	username;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
//creating pojo class to create new issue
public static class GetBodydata
{
	private fieldsdata fields;

	public fieldsdata getFields() {
		return fields;
	}

	public void setFields(fieldsdata fields) {
		this.fields = fields;
	}

public static class fieldsdata
{
private	dataproject project;
private	String summary;
private	dataissuetype issuetype;
public dataproject getProject() {
	return project;
}
public void setProject(dataproject project) {
	this.project = project;
}
public String getSummary() {
	return summary;
}
public void setSummary(String summary) {
	this.summary = summary;
}
public dataissuetype getIssuetype() {
	return issuetype;
}
public void setIssuetype(dataissuetype issuetype) {
	this.issuetype = issuetype;
}

	}

public static class dataproject
{
private	String key;

public String getKey() {
	return key;
}

public void setKey(String key) {
	this.key = key;
}
	}
public static class dataissuetype
{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	}

}
//Adding pojo class to create new comment
public static class datatonewcomment
{
	private String body;
	private datatovisibility visibility;
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public datatovisibility getVisibility() {
		return visibility;
	}
	public void setVisibility(datatovisibility visibility) {
		this.visibility = visibility;
	}
	public static class datatovisibility
	{
		private String type;
		private String value;
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		
	}
	}
//Adding pojo class to update existing comments 
public static class datatoexistingcomment
{
	private String body;
	private datatovisibility visibility;
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public datatovisibility getVisibility() {
		return visibility;
	}
	public void setVisibility(datatovisibility visibility) {
		this.visibility = visibility;
	}
	public static class datatoexistingvisibility
	{
		private String type;
		private String value;
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		
	}
	}
}
