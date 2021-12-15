package assignment_3;
import java.awt.Color; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;
import javax.swing.*; 
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

public class ATM_machine implements ActionListener 
{
	private int n;
	private int keypadswitch=0;
	private String usernametransfer;
	private JButton start_button;
	private JFrame start_frame;
	private JPanel start_panel;
	private JPanel second_panel;
	private JPanel third_panel;
	private Authenticator user_Authenticate;
	private String username;
	private Transaction transaction;
	/////
	private  JTextField textField;
	private JPasswordField password;
	 private  JPanel layerOne;
	 private  JPanel layerTwo;
	 private  JPanel layerThree;
	 private  JPanel layerFour;
	 private  JPanel layerFive;
	 private  JPanel layerSix;
	 private  JPanel layerSeven;
	 private  JButton one;
	 private  JButton two;
     private  JButton three;
     private  JButton four;
     private  JButton five;
     private  JButton six;
	 private  JButton seven;
	 private  JButton eight;
	 private  JButton nine;
	 private  JButton zero;
	 private  JButton okButton;
	 private  JButton clearButton;
	////
	 
	 private JButton balance;
	 private JButton deposite;
	 private JButton changePin;
	 private JButton withdraw;
	 private JButton transfer;
	 private JButton logout;
	 
	 
	 
	 private JButton ok2;
	 private JButton ok3;
	 private  JButton clearButton2;
	 private  JButton gogreen;
	 private  JButton print;
	public ATM_machine()  // the constructor
	{
		user_Authenticate= new Authenticator();
		transaction= new Transaction();
	
	}
	
	public void start_ATM() // to start the ATM machine 
	{
		Start_frame();
	}
	
	private void Start_frame()
	{
		start_frame= new JFrame("ATM machine");
		start_panel= new JPanel();
		start_button= new JButton("Weclome to Java ATM");
		start_button.addActionListener(this);
		start_button.setVisible(true);
		start_panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,10));
		start_panel.add(start_button);
		start_frame.add(start_panel);
		start_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start_frame.pack();
		start_frame.setLocation(250,250);
		start_frame.setVisible(true);
	}
	private void keypadaction()
	{
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		seven.addActionListener(this);
		eight.addActionListener(this);
		nine.addActionListener(this);
		zero.addActionListener(this);
		okButton.addActionListener(this);
		clearButton.addActionListener(this);
	}
	private void thirdlevelaction()
	{
		balance.addActionListener(this);
		logout.addActionListener(this);
		withdraw.addActionListener(this);
		transfer.addActionListener(this);
		deposite.addActionListener(this);
		changePin.addActionListener(this);
	}
	
	private void third_frame()
	{
		third_panel= new JPanel();
		layerOne=new JPanel();
		layerTwo=new JPanel();
		deposite = new JButton("Deposite");
		balance = new JButton("Balance");
		changePin = new JButton("Change Pin");
		withdraw = new JButton("WithDraw");
		transfer = new JButton("transfer");
		logout= new JButton("Log Out");
		layerOne.add(balance);
		layerOne.add(deposite);
		layerOne.add(changePin);
		layerTwo.add(withdraw);
		layerTwo.add(transfer);
		layerTwo.add(logout);
		third_panel.add(layerOne);
		third_panel.add(layerTwo);
		start_frame.add(third_panel);
		start_frame.setSize(300,200);
		thirdlevelaction();
		//start_frame.pack();
		
		
	}
	private void second_frame() throws ParseException
	{
		
		
		second_panel=new JPanel();
		layerOne = new JPanel();
        layerTwo = new JPanel();
        layerThree = new JPanel();
        layerFour = new JPanel();
        layerFive = new JPanel();
        layerSix = new JPanel();
        layerSeven = new JPanel();
     // Add layer one
        textField = new JTextField(10);
        JLabel label1= new JLabel("user_name:");
        textField.setEditable(true);
        layerOne.add(label1);
        layerOne.add(textField);
    // Add layer two
        password = new JPasswordField(10);
        password.setEditable(false);
        JLabel label2= new JLabel("Password:");
        layerTwo.add(label2);
        layerTwo.add(password);
        // Add layer three
        one = new JButton(String.valueOf(1));
        two = new JButton(String.valueOf(2));
        three = new JButton(String.valueOf(3));
        layerThree.add(one);
        layerThree.add(two);
        layerThree.add(three);

        // Add layer four
        four = new JButton(String.valueOf(4));
        five = new JButton(String.valueOf(5));
        six = new JButton(String.valueOf(6));
        layerFour.add(four);
        layerFour.add(five);
        layerFour.add(six);

        // Add layer five
        seven = new JButton(String.valueOf(7));
        eight = new JButton(String.valueOf(8));
        nine = new JButton(String.valueOf(9));
        layerFive.add(seven);
        layerFive.add(eight);
        layerFive.add(nine);

        // Add layer six
        zero = new JButton(String.valueOf(0));
        layerSix.add(zero);

        // Add layer seven
        okButton = new JButton("OK");
        okButton.setBackground(Color.blue);
        okButton.setOpaque(true);
        clearButton = new JButton("Clear");
        clearButton.setBackground(Color.white);
        clearButton.setOpaque(true);
        layerSeven.add(okButton);
        layerSeven.add(clearButton);
        
        
        
        second_panel.add(layerOne);
		second_panel.add(layerTwo);
		second_panel.add(layerThree);
		second_panel.add(layerFour);
		second_panel.add(layerFive);
		second_panel.add(layerSix);
		second_panel.add(layerSeven);
		start_frame.add(second_panel);
		start_frame.pack();
		start_frame.setSize(190,350);
		keypadaction();
	}
	private void clearButtonFunc()
	{
		textField.setText(null);
		password.setText(null);
	}
	private void clearButton2Func()
	{
		textField.setText(null);
	}
	private void setpasswordfield(int temp) // this function update the password field by the values that were pressed from the keypad
	{
		char[] prev = password.getPassword(); // getting the already typed password
		String prev_2= new String(prev); // converting the password from array of characters to string
		if(prev_2.length()<6) // this condition to limit the password field to only 6 digit
		{
			switch(temp) // switch to put the value according to which key has been pressed
			{
			case 1:
				password.setText(prev_2 + 1);
				break;
			case 2:
				password.setText(prev_2 + 2);
				break;
			case 3:
				password.setText(prev_2 + 3);
				break;
			case 4:
				password.setText(prev_2 + 4);
				break;
			case 5:
				password.setText(prev_2 + 5);
				break;
			case 6:
				password.setText(prev_2 + 6);
				break;
			case 7:
				password.setText(prev_2 + 7);
				break;
			case 8:
				password.setText(prev_2 + 8);
				break;
			case 9:
				password.setText(prev_2 + 9);
				break;
			default:
				password.setText(prev_2 + 0);
				break;
			}
		}
	}
	
	
	
	private void set_Withdraw_field(int temp)
	{
		String prev = textField.getText(); // getting the already typed password
		 

			switch(temp) // switch to put the value according to which key has been pressed
			{
			case 1:
				textField.setText(prev + 1);
				break;
			case 2:
				textField.setText(prev + 2);
				break;
			case 3:
				textField.setText(prev + 3);
				break;
			case 4:
				textField.setText(prev + 4);
				break;
			case 5:
				textField.setText(prev + 5);
				break;
			case 6:
				textField.setText(prev + 6);
				break;
			case 7:
				textField.setText(prev + 7);
				break;
			case 8:
				textField.setText(prev + 8);
				break;
			case 9:
				textField.setText(prev + 9);
				break;
			default:
				textField.setText(prev + 0);
				break;
			}
		
	}
	private void set_changepin_field(int temp)
	{
		String prev = textField.getText(); // getting the already typed password
		 
			if(prev.length()<6)
			switch(temp) // switch to put the value according to which key has been pressed
			{
			case 1:
				textField.setText(prev + 1);
				break;
			case 2:
				textField.setText(prev + 2);
				break;
			case 3:
				textField.setText(prev + 3);
				break;
			case 4:
				textField.setText(prev + 4);
				break;
			case 5:
				textField.setText(prev + 5);
				break;
			case 6:
				textField.setText(prev + 6);
				break;
			case 7:
				textField.setText(prev + 7);
				break;
			case 8:
				textField.setText(prev + 8);
				break;
			case 9:
				textField.setText(prev + 9);
				break;
			default:
				textField.setText(prev + 0);
				break;
			}
		
	}
	private void withdraw_keypadfunc()
	{
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		seven.addActionListener(this);
		eight.addActionListener(this);
		nine.addActionListener(this);
		zero.addActionListener(this);
		ok3.addActionListener(this);
		clearButton2.addActionListener(this);
		
	}
	
	private void deposite_withdraw_transfer_panel()
	{
		String temp;
		if (n==0)
			temp="Deposit value: ";
		else if (n==1)
			temp="WithDraw value: ";
		else if(n==2)
			temp="Transfer value: ";
		else
		{
			temp="New password";
		}
		third_panel=new JPanel();
		layerOne = new JPanel();
        layerTwo = new JPanel();
        layerThree = new JPanel();
        layerFour = new JPanel();
        layerFive = new JPanel();
        layerSix = new JPanel();
        layerSeven = new JPanel();
     // Add layer one
        textField = new JTextField(10);
        JLabel label1= new JLabel(temp);
        textField.setEditable(false);
        layerOne.add(label1);
        layerOne.add(textField);
        // Add layer three
        one = new JButton(String.valueOf(1));
        two = new JButton(String.valueOf(2));
        three = new JButton(String.valueOf(3));
        layerThree.add(one);
        layerThree.add(two);
        layerThree.add(three);

        // Add layer four
        four = new JButton(String.valueOf(4));
        five = new JButton(String.valueOf(5));
        six = new JButton(String.valueOf(6));
        layerFour.add(four);
        layerFour.add(five);
        layerFour.add(six);

        // Add layer five
        seven = new JButton(String.valueOf(7));
        eight = new JButton(String.valueOf(8));
        nine = new JButton(String.valueOf(9));
        layerFive.add(seven);
        layerFive.add(eight);
        layerFive.add(nine);

        // Add layer six
        zero = new JButton(String.valueOf(0));
        layerSix.add(zero);

        // Add layer seven
        ok3 = new JButton("OK");
        clearButton2 = new JButton("Clear");
        layerSeven.add(ok3);
        layerSeven.add(clearButton2);
        
        
        
        third_panel.add(layerOne);
        third_panel.add(layerTwo);
        third_panel.add(layerThree);
        third_panel.add(layerFour);
        third_panel.add(layerFive);
        third_panel.add(layerSix);
        third_panel.add(layerSeven);
		start_frame.add(third_panel);
		start_frame.pack();
		start_frame.setSize(220,350);
		
		
		withdraw_keypadfunc();
	}
	
	private void okButtonfunc()
	{
		String username= textField.getText();
		char[] prev = password.getPassword(); 
		String prev_2= new String(prev);
		if(username.isEmpty()&&prev_2.length()!=6)
			pop_up_message_enter_credintials();
		else
		{
			if(this.user_Authenticate.AuthenticatUser(username, prev_2) && this.user_Authenticate.getuserislocked(username)==false)
			{
				this.username=username;
				
				
				try {
					start_frame.remove(second_panel);
					third_frame();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else // wrong credintials or the user is locked
			{
				if(this.user_Authenticate.getuserislocked(username)==false)
				{
				pop_up_message_wrong_credintials();
				password.setText(null);
				}
				else
				{
					pop_Up_Message_User_is_blocked();
				}
			}
		}
	}
	private void pop_Up_Message_User_is_blocked() // if the user did a failed log in attempt more than 3 times
	{
		JFrame f;  
		f=new JFrame();  
		JOptionPane.showMessageDialog(f,"to many wrong log in attempts, this user is blocked"); 	
	}
	private void pop_up_message_enter_credintials() // if the user just clicked ok without entering both the username and password
	{
		JFrame f;  
		f=new JFrame();  
		JOptionPane.showMessageDialog(f,"please enter a username and a 6 digit password");  
	}
	private void pop_up_message_wrong_credintials() // if the username and password are not found
	{
		JFrame f;  
		f=new JFrame();  
		JOptionPane.showMessageDialog(f,"wrong combination of username and password");  
	}
	private void pop_up_message_not_enough() // if the username and password are not found
	{
		JFrame f;  
		f=new JFrame();  
		JOptionPane.showMessageDialog(f,"not enough money available in ur balance");  
	}
	private void pop_up_message_user_not_found() // if the username and password are not found
	{
		JFrame f;  
		f=new JFrame();  
		JOptionPane.showMessageDialog(f,"user not found");  
	}
	private void logoutfunc() // clear everything and return to the main page of login 
	{
		start_frame.remove(third_panel);
		username=null;
		keypadswitch=0;
		try {
			second_frame();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	private void balancefunc()
	{
		start_frame.remove(third_panel);
		third_panel= new JPanel();
		layerOne=new JPanel();
		layerTwo=new JPanel();
		layerThree=new JPanel();
	    textField = new JTextField(10);
	    JLabel label1= new JLabel("your balance is:");
	    textField.setEditable(false);
	    textField.setText(transaction.CheckBalance(username).toString());
	    layerOne.add(label1);
	    layerOne.add(textField);
		gogreen = new JButton("Go Green");
		gogreen.setBackground(Color.green);
		gogreen.setOpaque(true);
		layerTwo.add(gogreen);
		third_panel.add(layerOne);
		third_panel.add(layerTwo);
		start_frame.add(third_panel);
		start_frame.setSize(250,200);

		gogreen.addActionListener(this);
		
	}
	private void depositefunc()
	{
		transaction.updatebalance(n, new BigDecimal(textField.getText()), username,usernametransfer);
	}
	private boolean withdrawfunc()
	{
		if(transaction.checkwithdraw(new BigDecimal(textField.getText()), username))
		{
			transaction.updatebalance(n, new BigDecimal(textField.getText()), username,usernametransfer);
			return true;
		}
		else
		{
			pop_up_message_not_enough();
			return false;
		}
	}
	private boolean transferfunfunc()
	{
		if(transaction.checkwithdraw(new BigDecimal(textField.getText()), username))
		{
			transaction.updatebalance(n, new BigDecimal(textField.getText()), username,usernametransfer);
			return true;
		}
		else
		{
			pop_up_message_not_enough();
			return false;
		}
	}
	private void changepinfunc()
	{
		transaction.changepin(Integer.parseInt(textField.getText()), username);
	}
	private void depositepanel()
	{
		start_frame.remove(third_panel);
		third_panel= new JPanel();
		layerOne=new JPanel();
		layerTwo=new JPanel();
	    textField = new JTextField(10);
	    JLabel label1= new JLabel("your deposite is successfull, your balance is:");
	    textField.setEditable(false);
	    textField.setText(transaction.CheckBalance(username).toString());
	    layerOne.add(label1);
	    layerOne.add(textField);
		gogreen = new JButton("Go Green");
		gogreen.setBackground(Color.green);
		gogreen.setOpaque(true);
		print = new JButton("Print");
		print.setBackground(Color.red);
		print.setOpaque(true);
		layerTwo.add(gogreen);
		layerTwo.add(print);
		third_panel.add(layerOne);
		third_panel.add(layerTwo);
		start_frame.add(third_panel);
		//start_frame.setSize(300,200);
		start_frame.pack();
		gogreen.addActionListener(this);
		print.addActionListener(this);
		
	}
	private void withdrawpanel()
	{
		start_frame.remove(third_panel);
		third_panel= new JPanel();
		layerOne=new JPanel();
		layerTwo=new JPanel();
	    textField = new JTextField(10);
	    JLabel label1= new JLabel("your withdraw is successfull, your balance is:");
	    textField.setEditable(false);
	    textField.setText(transaction.CheckBalance(username).toString());
	    layerOne.add(label1);
	    layerOne.add(textField);
		gogreen = new JButton("Go Green");
		gogreen.setBackground(Color.green);
		gogreen.setOpaque(true);
		print = new JButton("Print");
		print.setBackground(Color.red);
		print.setOpaque(true);
		layerTwo.add(gogreen);
		layerTwo.add(print);
		third_panel.add(layerOne);
		third_panel.add(layerTwo);
		start_frame.add(third_panel);
		//start_frame.setSize(300,200);
		start_frame.pack();
		gogreen.addActionListener(this);
		print.addActionListener(this);
		
	}
	private void transferpanel()
	{
		start_frame.remove(third_panel);
		third_panel= new JPanel();
		layerOne=new JPanel();
		layerTwo=new JPanel();
	    textField = new JTextField(10);
	    JLabel label1= new JLabel("your transfer is successfull, your balance is:");
	    textField.setEditable(false);
	    textField.setText(transaction.CheckBalance(username).toString());
	    layerOne.add(label1);
	    layerOne.add(textField);
		gogreen = new JButton("Go Green");
		gogreen.setBackground(Color.green);
		gogreen.setOpaque(true);
		print = new JButton("Print");
		print.setBackground(Color.red);
		print.setOpaque(true);
		layerTwo.add(gogreen);
		layerTwo.add(print);
		third_panel.add(layerOne);
		third_panel.add(layerTwo);
		start_frame.add(third_panel);
		//start_frame.setSize(300,200);
		start_frame.pack();
		gogreen.addActionListener(this);
		print.addActionListener(this);
		
	}
	private void searchforuserpanel()
	{
		third_panel=new JPanel();
		layerOne = new JPanel();
        layerSeven = new JPanel();
        textField = new JTextField(10);
        JLabel label1= new JLabel("tranfer to user");
        textField.setEditable(true);
        layerOne.add(label1);
        layerOne.add(textField);;

        // Add layer seven
        ok2 = new JButton("OK");
        clearButton2 = new JButton("Clear");
        layerSeven.add(ok2);
        layerSeven.add(clearButton2);
        ok2.addActionListener(this);
        clearButton2.addActionListener(this);
        
        third_panel.add(layerOne);
        third_panel.add(layerSeven);
		start_frame.add(third_panel);
		start_frame.pack();
		
	}
	private void changepinpanel()
	{
		start_frame.remove(third_panel);
		third_panel= new JPanel();
		layerOne=new JPanel();
		layerTwo=new JPanel();
	    JLabel label1= new JLabel("you changed your pin");
	    layerOne.add(label1);
		gogreen = new JButton("Go Green");
		gogreen.setBackground(Color.green);
		gogreen.setOpaque(true);
		layerTwo.add(gogreen);
		third_panel.add(layerOne);
		third_panel.add(layerTwo);
		start_frame.add(third_panel);
		start_frame.pack();
		gogreen.addActionListener(this);
		
	}
	
	private void printfunc()
	{
		String temp="";
		if (n==0)
			temp="transaction:Deposit";
		else if (n==1)
			temp="transaction: WithDraw";
		else if(n==2)
			temp="Transaction:Transfer";
		JFrame f;  
		f=new JFrame();  
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		JOptionPane.showMessageDialog(f,"Recit\n"+temp+"\n"+dtf.format(now)+"\n"+"username: "+ username
				+"\n"+ "balance:" +transaction.CheckBalance(username).toString());
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==start_button)
		{
			
			start_frame.remove(start_panel);
			try {
				second_frame();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
		else if (e.getSource()==one)
		{
			if(keypadswitch==0)
			setpasswordfield(1);
			else if(keypadswitch==1)
				set_Withdraw_field(1);
			else
				set_changepin_field(1);
			
		}
		else if (e.getSource()==two)
		{

			if(keypadswitch==0)
			setpasswordfield(2);
			else if(keypadswitch==1)
				set_Withdraw_field(2);
			else
				set_changepin_field(2);
			
		}
		else if (e.getSource()==three)
		{
			if(keypadswitch==0)
			setpasswordfield(3);
			else if(keypadswitch==1)
				set_Withdraw_field(3);
			else
				set_changepin_field(3);
			
		}
		else if (e.getSource()==four)
		{
			if(keypadswitch==0)
			setpasswordfield(4);
			else if(keypadswitch==1)
				set_Withdraw_field(4);
			else
				set_changepin_field(4);
			
		}
		else if (e.getSource()==five)
		{
			if(keypadswitch==0)
			setpasswordfield(5);
			else if(keypadswitch==1)
				set_Withdraw_field(5);
			else
				set_changepin_field(5);
			
		}
		else if (e.getSource()==six)
		{
			if(keypadswitch==0)
			setpasswordfield(6);
			else if(keypadswitch==1)
				set_Withdraw_field(6);
			else
				set_changepin_field(6);
			
		}
		else if (e.getSource()==seven)
		{
			if(keypadswitch==0)
			setpasswordfield(7);
			else if(keypadswitch==1)
				set_Withdraw_field(7);
			else
				set_changepin_field(7);
			
		}
		else if (e.getSource()==eight)
		{
			if(keypadswitch==0)
			setpasswordfield(8);
			else if(keypadswitch==1)
				set_Withdraw_field(8);
			else
				set_changepin_field(8);
			
		}
		else if (e.getSource()==nine)
		{
			if(keypadswitch==0)
			setpasswordfield(9);
			else if(keypadswitch==1)
				set_Withdraw_field(9);
			else
				set_changepin_field(9);
		}
		else if (e.getSource()==zero)
		{
			if(keypadswitch==0)
			setpasswordfield(0);
			else if(keypadswitch==1)
				set_Withdraw_field(0);
			else
				set_changepin_field(0);
			
		}
		else if(e.getSource()==okButton)
		{
			okButtonfunc();
		}
		else if(e.getSource()==clearButton)
		{
			clearButtonFunc();
		}
		else if(e.getSource()==logout)
		{
			logoutfunc();
		}
		else if (e.getSource()==balance)
		{
			balancefunc();
		}
		else if (e.getSource()==ok2)
		{
			if(this.user_Authenticate.AuthenticatUser(textField.getText()))
			{
				usernametransfer=textField.getText();
				start_frame.remove(third_panel);
				deposite_withdraw_transfer_panel();
			}
			else
			{
				pop_up_message_user_not_found();	
			}
		}
		else if(e.getSource()==deposite)
		{
			n=0;
			keypadswitch=1;
			start_frame.remove(third_panel);
			deposite_withdraw_transfer_panel();
			
		}
		else if(e.getSource()==transfer)
		{
			n=2;
			keypadswitch=1;
			start_frame.remove(third_panel);
			searchforuserpanel();
			
		}
		else if (e.getSource()==withdraw)
		{
			n=1;
			keypadswitch=1;
			start_frame.remove(third_panel);
			deposite_withdraw_transfer_panel();
		}
		else if (e.getSource()==clearButton2)
		{
			clearButton2Func();
		}
		else if(e.getSource()==ok3)
		{
			if(n==0) // deposite
			{
				depositefunc();
				depositepanel();
			}
			else if(n==1) // withdraw
			{
				if(withdrawfunc())
				withdrawpanel();	
			}
			else if(n==2) // transfer
			{
				if(transferfunfunc())
					transferpanel();
					
			}
			else // change pin
			{
				changepinfunc();
				changepinpanel();
			}
		}
		else if(e.getSource()==gogreen)
		{
			start_frame.remove(third_panel);
			third_frame();
		}
		else if (e.getSource()==changePin)
		{
			n=3;
			keypadswitch=2;
			start_frame.remove(third_panel);
			deposite_withdraw_transfer_panel();
		}
		else if(e.getSource()==print)
		{
			printfunc();
			start_frame.remove(third_panel);
			third_frame();
		}
	}
	
	
  	
	
}
