package assignment_3;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {
		ATM_machine atm = new ATM_machine();
		atm.start_ATM();
		//AccountFile file=new AccountFile();
		//file.PrintUsers();
		/*try (BufferedReader br = new BufferedReader(new FileReader("AccountInfo.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) 
		    {
		       String[] values = line.split(",");
		       for (int i=0;i<values.length;i++)
		    	   System.out.println(values[i]);
		    }
		}
		catch (Exception e)
		{
			e.printStackTrace(System.out);
		}*/
	}

}
