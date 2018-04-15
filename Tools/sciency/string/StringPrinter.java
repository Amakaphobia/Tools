package string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.Consumer;

/**
 * Class used to simply build a Printwriter and write to file without doing all the ceremony around it
 * @author Dave
 *
 */
public class StringPrinter
{
	/**Holding the Printwriter used to write*/
	private PrintWriter PW;
	
	/**
	 * Constructor
	 * @param target the target filepath
	 */
	public StringPrinter(String target) 
	{
		try 
		{
			File F = new File(target);
			if(!F.exists())
				F.createNewFile();
			this.PW = new PrintWriter(new BufferedWriter(new FileWriter(F)));
		} 		
		catch (IOException e) {e.printStackTrace();}
	}
	
	/**
	 * used to access  the consumer function
	 * @return the consumer
	 */
	public Consumer<String> getLogger()
	{
		return this::write;
	}
	
	/**
	 * Method used to write to File
	 * @param s the string to write
	 */
	public void write(String s)
	{
		this.PW.write(s);
	}
	
	/**Method used to close it*/
	public void close()
	{
		this.PW.close();
	}
	
	
}
