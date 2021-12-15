package assignment_3;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

	private AccountFile users;
	private TransactionLog logger;
	public Transaction()
	{
		users= new AccountFile();
		logger= new TransactionLog();
	}
	public BigDecimal CheckBalance(String username )
	{
		return users.checkbalance(username);
	}
	
	public void updatebalance(int n, BigDecimal amount, String username, String usernametransger)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		if (n==0) // deposite
		{
			users.depositbalance(username, amount);
			logger.editfile("username: " +username.substring(0,3) + " transaction:deposit amount: " + amount.toString() +" Date:" +dtf.format(now)+ " AccountNumber: "+ users.SearchAccountNumber(username).substring(users.SearchAccountNumber(username).length()-3,users.SearchAccountNumber(username).length()));
		}
		else if(n==1)
		{
		users.withdrawbalance(username, amount);
		logger.editfile("username :" +username.substring(0,3) + " transaction:withdraw amount: " + amount.toString()+" Date:" +dtf.format(now)+ " AccountNumber: "+ users.SearchAccountNumber(username).substring(users.SearchAccountNumber(username).length()-3,users.SearchAccountNumber(username).length()));
		}
		else if(n==2)
		{
			users.transgerbalance(username, amount, usernametransger);
			logger.editfile("username: " +username.substring(0,3) + " transaction:transfer amount: " + amount.toString()+ "to user: " + usernametransger +" Date:" +dtf.format(now)+ " AccountNumber: "+ users.SearchAccountNumber(username).substring(users.SearchAccountNumber(username).length()-3,users.SearchAccountNumber(username).length()));
		}
	}
	public boolean checkwithdraw(BigDecimal amount, String username)
	{
		return users.checkifpossible(amount, username);
	}
	
	public void changepin(int newpin, String username)
	{
		users.changepin(newpin, username);
	}
	
}
