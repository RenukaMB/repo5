package MainPOJO;

public class CreateIssueResponsePojo 
{
	
	    private String self;

	    private String id;

	    private String key;

	    public String getSelf ()
	    {
	        return self;
	    }

	    public void setSelf (String self)
	    {
	        this.self = self;
	    }

	    public String getId ()
	    {
	        return id;
	    }

	    public void setId (String id)
	    {
	        this.id = id;
	    }

	    public String getKey ()
	    {
	        return key;
	    }

	    public void setKey (String key)
	    {
	        this.key = key;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [self = "+self+", id = "+id+", key = "+key+"]";
	    }
	}
				

