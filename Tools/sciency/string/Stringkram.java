package string;

/**
 * Class for fun static methods that work with strings
 * @author Dave
 *
 */
public class Stringkram 
{
	/**
	 * checks if a string reads the same both ways
	 * @param input the string thats to be checked
	 * @return true if its a palindrom
	 */
	public static boolean checkPalindrom(String input)
	{
		StringBuilder part1 = new StringBuilder();
		StringBuilder part2 = new StringBuilder();
		
		while(input.length() > 1)
		{
			part1.append(input.charAt(0));
			part2.append(input.charAt(input.length()-1));
			input = input.substring(1,input.length()-1);
		}
		
		return part1.toString().equalsIgnoreCase(part2.toString());
	}
}
