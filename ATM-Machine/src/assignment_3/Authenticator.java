package assignment_3;

import java.io.BufferedReader;
import java.io.FileReader;

public class Authenticator {
	
	private AccountFile users;
	//private boolean user_is_locked=false;
	public Authenticator()
	{
		users= new AccountFile();
	}
	public boolean AuthenticatUser(String username, String userpin) // iterate the file to see the users and authenticate if the user excisted or not
	{
		try (BufferedReader br = new BufferedReader(new FileReader("AccountInfo.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) 
		    {
		        String[] values = line.split(",");
		        if(username.equalsIgnoreCase(values[1]))
		        {
		        	if(!userpin.equalsIgnoreCase(values[3]))
		        	{
		        		
		        		users.WrongPassword(username);
		        		return false;
		        	}
		        	else 
		        	{
		        		if(users.checkifuserislocked(username)==false)
		        		return true;
		        		else
		        		{
		        			//user_is_locked=true;
		        			return false;
		        		}
		        	}
		        }
		        
		    }
		}
		catch (Exception e)
		{
			e.printStackTrace(System.out);
		}
		
		return false;
	}
	public boolean AuthenticatUser(String username) // iterate the file to see the users and authenticate if the user excisted or not
	{
		try (BufferedReader br = new BufferedReader(new FileReader("AccountInfo.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) 
		    {
		        String[] values = line.split(",");
		        if(username.equalsIgnoreCase(values[1]))
		        {
		        		return true;        	
		        }
		        
		    }
		}
		catch (Exception e)
		{
			e.printStackTrace(System.out);
		}
		
		return false;
	}
	public boolean getuserislocked(String username)
	{
		return users.checkifuserislocked(username);
	}

}
