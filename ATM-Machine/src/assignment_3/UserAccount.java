package assignment_3;

import java.math.BigDecimal;

public class UserAccount {
	private BigDecimal availableBalance; 
	private String Accountname;
	private int AccountNumber;
	private int UserPin;
	private int logInAttempts=3;
	private boolean userislocked=false;
public UserAccount()
{
	
}
public BigDecimal getBalance()	
{
	return this.availableBalance;
}

public int getAccountNumber()
{
	return this.AccountNumber;
}
public int getUserPin()
{
	return this.UserPin;
}
public String getAccountName()
{
	return this.Accountname;
}
public void setBalance(BigDecimal balance)
{
	this.availableBalance=balance;
}
public void setAccoutnNumber(int accountnumber)
{
	this.AccountNumber=accountnumber;
}
public void setUserPin(int userpin)
{
	this.UserPin=userpin;
}
public void setAccountName(String accountName)
{
	this.Accountname= accountName;
}
public int getLogInAttempts()
{
	return this.logInAttempts;
}
public void DecrementLoginAttempts()
{
	if(this.logInAttempts>0)
	this.logInAttempts--;
}
public void setLogInAttempts(int n)
{
	this.logInAttempts=n;
}
public void setuserislocked(boolean n)
{
	this.userislocked=n;
}
public boolean getuserislocked()
{
	return this.userislocked;
}

}
