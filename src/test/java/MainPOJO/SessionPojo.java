package MainPOJO;

public class SessionPojo 
{
	private Session session;

    private LoginInfo loginInfo;

    public Session getSession ()
    {
        return session;
    }

    public void setSession (Session session)
    {
        this.session = session;
    }

    public LoginInfo getLoginInfo ()
    {
        return loginInfo;
    }

    public void setLoginInfo (LoginInfo loginInfo)
    {
        this.loginInfo = loginInfo;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [session = "+session+", loginInfo = "+loginInfo+"]";
    }
    public  static class LoginInfo
    {
        private String failedLoginCount;

        private String lastFailedLoginTime;

        private String loginCount;

        private String previousLoginTime;

        public String getFailedLoginCount ()
        {
            return failedLoginCount;
        }

        public void setFailedLoginCount (String failedLoginCount)
        {
            this.failedLoginCount = failedLoginCount;
        }

        public String getLastFailedLoginTime ()
        {
            return lastFailedLoginTime;
        }

        public void setLastFailedLoginTime (String lastFailedLoginTime)
        {
            this.lastFailedLoginTime = lastFailedLoginTime;
        }

        public String getLoginCount ()
        {
            return loginCount;
        }

        public void setLoginCount (String loginCount)
        {
            this.loginCount = loginCount;
        }

        public String getPreviousLoginTime ()
        {
            return previousLoginTime;
        }

        public void setPreviousLoginTime (String previousLoginTime)
        {
            this.previousLoginTime = previousLoginTime;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [failedLoginCount = "+failedLoginCount+", lastFailedLoginTime = "+lastFailedLoginTime+", loginCount = "+loginCount+", previousLoginTime = "+previousLoginTime+"]";
        }
    }
    			
    public class Session
    {
        private String name;

        private String value;

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String getValue ()
        {
            return value;
        }

        public void setValue (String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [name = "+name+", value = "+value+"]";
        }
    }
    		
}
