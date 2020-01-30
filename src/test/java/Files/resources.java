/**
 * 
 */
package Files;

/**
 * @author debasis panda
 *
 */
public class resources 
{
	public static String placePostdata()
	{
		String res="/maps/api/place/add/json" ;
		return res;
	}
public static String postresource()
{
	String res="/rest/auth/1/session";
	return res;
			}
public static String createissuepost()
{
	String post="/rest/api/2/issue";
	return post;
	}
public static String createcommentpost(String issueid)
{
	String post="/rest/api/2/issue/"+issueid+"/comment";
	return post;
	}
public static String updatecommentput(String issueid, String commentid )
{
	String put="/rest/api/2/issue/"+issueid+"/comment/"+commentid+"";
	return put;
	}
public static String deletecomment(String issueid, String updatecommentid)
{
	String delete="/rest/api/2/issue/"+issueid+"/comment/"+updatecommentid+"";
	return delete;
	}
public static String deleteissue(String issueid)
{
	String delete="/rest/api/2/issue/"+issueid+"";
	return delete;
	}
}
