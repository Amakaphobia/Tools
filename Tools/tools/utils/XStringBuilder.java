package utils;

/**
 * This class is used as an extension to the Stringbuilder
 * @author Dave
 *
 */
public class XStringBuilder
{
	/**Holds the used Stringbuilder*/
	private StringBuilder strb;
	
	/**
	 * constructor
	 */
	public XStringBuilder() {
		this.strb = new StringBuilder();
	}
	
	/**
	 * Constructor
	 * @param s first part of string
	 */
	public XStringBuilder(String s){
		this.strb = new StringBuilder(s);
	}
	
	/**
	 * appends an object
	 * @param o the object
	 * @return this for chain building
	 * @param <T> type of Object to append
	 */
	public <T> XStringBuilder append(T o){
		strb.append(o.toString());
		return this;
	}
	
	/**
	 * empties out thhe string
	 */
	public void clear()
	{
		this.strb.delete(0, strb.length());
	}
	
	/**
	 * gets the string and clears the string
	 * @return the string
	 */
	public String pop(){
		String s = this.strb.toString();
		clear();
		return s;
	}
	/**
	 * appends lineseperator
	 * @return this for chainbuilding 
	 */
	public XStringBuilder linesep(){
		this.strb.append(System.lineSeparator());
		return this;
	}
	/**
	 * returns the string
	 */
	public String toString()
	{
		return this.strb.toString();
	}
}
