package assignment_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Vector;
public class AccountFile {

	private Vector<UserAccount> users= new Vector<UserAccount>();
	private Vector<String> trial= new Vector<String>();
	//private boolean user_locked=false;
	public AccountFile()
	{
		try (BufferedReader br = new BufferedReader(new FileReader("AccountInfo.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) 
		    {
		       String[] values = line.split(",");
		       setUserAccount(values);
		    }
		    br.close();
		}
		catch (Exception e)
		{
			e.printStackTrace(System.out);
		}
	}
	
	public String SearchAccountNumber(String username)
	{
		try (BufferedReader br = new BufferedReader(new FileReader("AccountInfo.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) 
		    {
		       String[] values = line.split(",");
		       if(values[1].equalsIgnoreCase(username))
		    	   return values[2];
		    }
		    br.close();
		}
		catch (Exception e)
		{
			e.printStackTrace(System.out);
		}
		return "";
	}
	
	private void setUserAccount(String [] line)
	{
		
		if (!line[0].equalsIgnoreCase("Index"))
		{
			UserAccount temp_User= new UserAccount();	
			temp_User.setAccountName(line[1]);
			temp_User.setAccoutnNumber(Integer.parseInt(line[2]));
			temp_User.setUserPin(Integer.parseInt(line[3]));
			temp_User.setBalance(new BigDecimal(line[4]));
			users.add(temp_User);
		}
	}
	public void PrintUsers()
	{
		for(int i=0; i<users.size();i++) 
		{
			System.out.println(users.get(i).getAccountName());
			System.out.println(users.get(i).getAccountNumber());
			System.out.println(users.get(i).getUserPin());
			System.out.println(users.get(i).getBalance());
		}
	}
	
	public void WrongPassword(String username)
	{
		for(int i=0; i<users.size();i++) 
		{
			if(username.equalsIgnoreCase(users.get(i).getAccountName()))
			{
				if(users.get(i).getLogInAttempts()>0)
				users.get(i).DecrementLoginAttempts();
				else
				{
					users.get(i).setuserislocked(true);
				}
			}
		}
	}
	
	
	public boolean checkifuserislocked(String username)
	{
		for(int i=0; i<users.size();i++) 
		{
			if(username.equalsIgnoreCase(users.get(i).getAccountName()))
			{
				return users.get(i).getuserislocked();
			}
		}
		return false;
	}
	
	public BigDecimal checkbalance(String username)
	{
		for(int i=0; i<users.size();i++) 
		{
			if(username.equalsIgnoreCase(users.get(i).getAccountName()))
			{
				return users.get(i).getBalance();
			}
		}
		return new BigDecimal (0);
	}
	public void depositbalance(String username, BigDecimal amount)
	{
	    FileWriter csvWriter = null;
	    trial.removeAllElements();
		for(int i=0; i<users.size();i++) 
		{
			if(username.equalsIgnoreCase(users.get(i).getAccountName()))
			{
				users.get(i).setBalance(users.get(i).getBalance().add(amount));
				
			
			
			
			try (BufferedReader br = new BufferedReader(new FileReader("AccountInfo.csv"))) 
			{
				

			    String line;
			    while ((line = br.readLine()) != null) 
			    {
			       String[] values = line.split(",");

			       if(values[1].equalsIgnoreCase(username))
			       {
			    	   values[4]=users.get(i).getBalance().toString();
			    	   line="";
			    	   for (int j=0;j<values.length;j++)
			    	   {
			    		 line=line+values[j]+",";
			    	   }
			       }
			       	   line=line+"\n";
			       	   trial.add(line);
			    	   //csvWriter.append(line);

			    }
			    br.close();
			}
			catch (Exception e)
			{
				e.printStackTrace(System.out);
			
			
			}
			
			try {
				csvWriter = new FileWriter("AccountInfo.csv");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	    	   try {
	    		   for (int k=0;k<trial.size();k++)
	    			   csvWriter.append(trial.get(k));
				csvWriter.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	   try {
				csvWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
	}
	}
	public boolean checkifpossible(BigDecimal amount, String username)
	{
		for(int i=0; i<users.size();i++) 
		{
			if(username.equalsIgnoreCase(users.get(i).getAccountName()))
			{
				
				BigDecimal temp=users.get(i).getBalance().subtract(amount);
				
				if(temp.signum()>=0)
					return true;
				else
					return false;
			}
	
		}
		return false;
	}
	public void withdrawbalance(String username, BigDecimal amount)
	{
		trial.removeAllElements();
	    FileWriter csvWriter = null;

		for(int i=0; i<users.size();i++) 
		{
			if(username.equalsIgnoreCase(users.get(i).getAccountName()))
			{
				
				
				if(checkifpossible(amount,username))
				{
				users.get(i).setBalance(users.get(i).getBalance().subtract(amount));
				}
			
			
			
			try (BufferedReader br = new BufferedReader(new FileReader("AccountInfo.csv"))) 
			{
			    String line;
			    while ((line = br.readLine()) != null) 
			    {
			       String[] values = line.split(",");

			       if(values[1].equalsIgnoreCase(username))
			       {
			    	   values[4]=users.get(i).getBalance().toString();
			    	   line="";
			    	   for (int j=0;j<values.length;j++)
			    	   {
			    		 line=line+values[j]+",";
			    	   }
			       }
			       	   line=line+"\n";
			        	trial.add(line);
			    	   //csvWriter.append(line);

			    }
			    br.close();
			}
			catch (Exception e)
			{
				e.printStackTrace(System.out);
			
			
			}
			try {
				csvWriter = new FileWriter("AccountInfo.csv");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	   try {
	    		   for (int k=0;k<trial.size();k++)
	    			   csvWriter.append(trial.get(k));
				csvWriter.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	   try {
				csvWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
	}
	}
public void changepin(int newpin, String username)
{
    FileWriter csvWriter = null;
    trial.removeAllElements();

	for(int i=0; i<users.size();i++) 
	{
		if(username.equalsIgnoreCase(users.get(i).getAccountName()))
		{
			
			
			users.get(i).setUserPin(newpin);;
		
		
		
		try (BufferedReader br = new BufferedReader(new FileReader("AccountInfo.csv"))) 
		{
		    String line;
		    while ((line = br.readLine()) != null) 
		    {
		       String[] values = line.split(",");

		       if(values[1].equalsIgnoreCase(username))
		       {
		    	   values[3]=Integer.toString(users.get(i).getUserPin());
		    	   line="";
		    	   for (int j=0;j<values.length;j++)
		    	   {
		    		 line=line+values[j]+",";
		    	   }
		       }
		       	   line=line+"\n";
		       	   trial.add(line);
		    	   //csvWriter.append(line);

		    }
		    br.close();
		}
		catch (Exception e)
		{
			e.printStackTrace(System.out);
		
		
		}
		try {
			csvWriter = new FileWriter("AccountInfo.csv");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	   try {
    		   for (int k=0;k<trial.size();k++)
    			   csvWriter.append(trial.get(k));
			csvWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   try {
			csvWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
}
}
public void transgerbalance(String username, BigDecimal amount, String transferusername)
{
    FileWriter csvWriter = null;
    trial.removeAllElements();

	for(int i=0; i<users.size();i++) 
	{
		if(username.equalsIgnoreCase(users.get(i).getAccountName()))
		{
			
			
			if(checkifpossible(amount,username))
			{
			users.get(i).setBalance(users.get(i).getBalance().subtract(amount));
			}
		
		
		
		try (BufferedReader br = new BufferedReader(new FileReader("AccountInfo.csv"))) 
		{
		    String line;
		    while ((line = br.readLine()) != null) 
		    {
		       String[] values = line.split(",");

		       if(values[1].equalsIgnoreCase(username))
		       {
		    	   values[4]=users.get(i).getBalance().toString();
		    	   line="";
		    	   for (int j=0;j<values.length;j++)
		    	   {
		    		 line=line+values[j]+",";
		    	   }
		       }
		       else if(values[1].equalsIgnoreCase(transferusername))
		       {
		    	   BigDecimal temp_bid= new BigDecimal (values[4]);
		    	   temp_bid=temp_bid.add(amount);
		    	   values[4]=temp_bid.toString();
		    	   for (int j=0;j<values.length;j++)
		    	   {
		    		 line=line+values[j]+",";
		    	   }
		       }
		       	   line=line+"\n";
		       	trial.add(line);
		    	  // csvWriter.append(line);

		    }
		    br.close();
		}
		catch (Exception e)
		{
			e.printStackTrace(System.out);
		
		
		}
		try {
			csvWriter = new FileWriter("AccountInfo.csv");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	   try {
    		   for (int k=0;k<trial.size();k++)
    			   csvWriter.append(trial.get(k));
			csvWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   try {
			csvWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
}
}
	
}
