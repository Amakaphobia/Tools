package math;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Static shit w/ numbers
 * @author Dave
 *
 */
public class Mathekram 
{
	/**
	 * checks if a number is evenly Divisible by another number
	 * @param 	a 	the number to check
	 * @param 	b 	the number to be divided through
	 * @return 		true if evenly divisible
	 */
	public static boolean isEvenlyDivisible(int a, int b)
	{
		return a % b == 0;
	}	
	
	/**
	 * Überprüft ob zwei Zahlen befreundet sind. Zwei Zahlen a und b sind befreundet wenn gilt
	 * <code>
	 * Summe aller echten Teiler von a = b UND
	 * Summe aller echten Teiler von b = a
	 * </code>
	 *  
	 * @param a Die erste Zahl
	 * @param b Die zweite Zahl
	 * @return <code>true</code> wenn sie befreundet sind
	 * 		   <code>false</code> wenn nicht.
	 */
	public static boolean sindBefreundete(int a, int b) {
		return b == getTeilerSum(a) && a == getTeilerSum(b);
	
	}
	
	/**
	 * Recursive Method to calculate the Faculty of a given Input.
	 * <code>Faculty(4) = 4*3*2*1 = 24</code>
	 * @since V0.14
	 * 
	 * @param input An Integer greater or equal to 1
	 * @return The Faculty of the Input
	 */
	public static int facultyRecursive(int input) {
		if(input < 1) throw new IllegalArgumentException("Faculty of Numbers smaller 1 is not defined");
		return input == 1 ?
					1 :
					input * facultyRecursive(input -1);
	}
	
	/**
	 * Method to calculate the Faculty of a given Input. This Method is used if the output is too big to ebe contained in an integer
	 * <code>Faculty(4) = 4*3*2*1 = 24</code>
	 * @since V0.14
	 * 
	 * @param input A Long greater or equal to 1
	 * @return The Faculty of the Input in a BigInteger
	 */
	public static BigInteger facultyBig(long input) {
		return LongStream.rangeClosed(1, input)
					.mapToObj(BigInteger::valueOf)
					.reduce(BigInteger.ONE, (carry, ele) -> carry.multiply(ele))
					;
	}
	
	/**
	 * Method to calculate the Faculty of a given Input. This Method is used if the output is too big to ebe contained in an integer
	 * <code>Faculty(4) = 4*3*2*1 = 24</code>
	 * @since V0.14
	 * 
	 * @param input A BigInteger greater or equal to 1
	 * @return The Faculty of the Input in a BigInteger
	 */
	public static BigInteger facultyBig(BigInteger input) {
		if(input.compareTo(BigInteger.ZERO) < 1) throw new IllegalArgumentException("Faculty of Numbers smaller 1 is not defined");
		
		return facultyBig(input.longValueExact());		
	}
	
	/**
	 * Method to calculate the Faculty of a given Input.
	 * <code>Faculty(4) = 4*3*2*1 = 24</code>
	 * @since V0.14
	 * 
	 * @param input An Integer greater or equal to 1
	 * @return The Faculty of the Input
	 */
	public static int faculty(int input) {
		if(input < 1) throw new IllegalArgumentException("Faculty of Numbers smaller 1 is not defined");
		
		return IntStream.rangeClosed(1, input)
					.reduce(1, (carry, ele) -> carry *= ele);
	}
	
	/**
	 * Überprüft ob eine Zahl a eine Vollkomme Zahl ist. Eine Zahl gilt als vollkommen wenn:
	 * <code>Die Summe aller ihrer echten Teiler die Zahl selber ergibt</code>
	 * @param i die zahl die zu überprüfen ist.
	 * @return <code>true</code> wenn sie vollkommen ist
	 * 		   <code>false</code> wenn nicht.
	 */
	public static boolean istVollkommene(int i) {
		return getTeilerSum(i) == i;
	}
	
	/**
	 * Methode die alle echten Teiler einer Zahl findet und sie summiert.
	 * @param i die Zahl die zu teilen ist
	 * @return die Summe ihrer Teiler
	 */
	public static int getTeilerSum(int i){
		return IntStream.rangeClosed(1, i/2)
			.filter(zahl -> Mathekram.isEvenlyDivisible(i,zahl))
			.sum();		
	}
}
