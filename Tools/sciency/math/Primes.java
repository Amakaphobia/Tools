package math;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;

/**
 * Class used to find PrimeNumbers. This Class utilizes Memoization.
 * @author hdaiv_000
 * @since V1.12
 */
public class Primes 
{
	/**Memoization*/
	private Map<Integer, Integer> Memoization;
	
	/**Constructor*/
	public Primes() {
		this.initialize();
	}
	
	/**
	 * Constructor
	 * @param anzahl wieviele Primzahlen sollen berechnet werden
	 */
	public Primes(int anzahl) {
		this.initialize();
		this.getList(0, anzahl);
	}
	
	/**internal Method used to initialize the Hashmap*/
	private void initialize() {
		this.Memoization = new HashMap<Integer, Integer>();
		this.Memoization.put(1, 2);
		this.Memoization.put(2, 3);
	}
	
	/**
	 * Method used to get the nth Prime Number
	 * @param number n
	 * @return the found Prime
	 */
	public int getNumber(int number) {
		if(number <= 0) return 0;
		
		Entry<Integer, Integer> entry;
		
		while(!this.Memoization.containsKey(number)) {
			entry = 
				this.Memoization.entrySet().stream()
						.max((e1, e2) -> 
							e1.getValue() - e2.getValue())
						.get();
			
			this.Memoization.put(
					entry.getKey()+1, 
					this.getNextPrime(entry.getValue()));
		}
		
		return this.Memoization.get(number);	
	}
	
	/**
	 * Method used to get the Next Prime Number given a Startingpoint
	 * @param start where you want your search to start
	 * @return the found primenumber
	 */
	private int getNextPrime(int start) {
		return IntStream.iterate(start +1, i -> i + 1)
					.filter(this::isPrime)
					.findFirst()
					.getAsInt();
	}
	
	/**
	 * Method used to check if a number is prime
	 * @param number he number you want to check
	 * @return true for prime false if not
	 */
	public boolean isPrime(int number) {
		if(number == 1) return false;
		if(number == 2) return true;
		return ! IntStream.rangeClosed(
								2,
								(int) Math.ceil(Math.sqrt(number)))
						.filter(i -> number % i == 0)
						.findFirst()
						.isPresent();
	}
	
	/**
	 * Method used to generate a List containing the ath to the bth prime number
	 * @param from startingpoint
	 * @param to endpoint
	 * @return a List(Integer) containing the found prime numbers
	 */
	public List<Integer> getList(int from, int to) {
		return IntStream.rangeClosed(from, to)
				.mapToObj(this::getNumber)
				.collect(toList());
	}
	
	/**
	 * splits a number into its primes
	 * @param	input	the number to split
	 * @return 			a LinkedList filled with the primes (Integer)
	 */	
	public static List<Integer> primFactorisation(Number input){
		List<Integer> Primfactoren = new ArrayList<>();
		int test = 2;
		double num = input.doubleValue();
		while (num >= test)
		{
			//wenn input durch test teilbar ist füge test der faktorlist hhinzu und teile input durch test
			
			while (num % test == 0)
			{
				Primfactoren.add(test);
				num /= test;
			}
			
			//wenn test == 2 ist erhöhe um 1 danach um 2 da man auf gerade zahlen nicht mehr testen muss
			test = test == 2 ? test +1: test +2;			
		}		
		return Primfactoren;
	}
}
