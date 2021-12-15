package assignment_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class TransactionLog {

	
	
	public TransactionLog() {
		
	}
	public void editfile( String text)
	{
		 FileWriter csvWriter = null;
		 Vector<String> trial= new Vector<String>();
				try (BufferedReader br = new BufferedReader(new FileReader("logfile.txt"))) 
				{
				    String line;
				    
				    while ((line = br.readLine()) != null) 
				    {
				       	   line=line+"\n";
				       	   trial.add(line);
				    	   //csvWriter.append(line);

				    }
				}
				catch (Exception e)
				{
					e.printStackTrace(System.out);
				
				
				}
				try {
					csvWriter = new FileWriter("logfile.txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
		    	   try {
		    		 trial.add(text);
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
