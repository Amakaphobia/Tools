package utils;

import java.util.LinkedList;

/**
 * This class has stuff that can do things with strings
 * @author Dave
 *
 */
public class TextBuilder 
{
	/**
	 * Prints aa list
	 * @param liste to print
	 */
	public static void printList(LinkedList<?> liste)
	{
		liste.forEach(e -> System.out.println(e.toString()));
	}
}
