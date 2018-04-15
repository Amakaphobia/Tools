package math;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Class used to Compute Fibonacci Numbers.
 * Fibonacci NUmbers are defined as follows:
 * <code>
 * 		Fibonacci(0) = 0;
 * 		Fibonacci(1) = 1;
 * 		Fibonacci(n) = Fibonacci(n-2) + Fibonacci(n-1);
 * </code>
 * 
 * @author hdaiv_000
 * @since V 1.12
 */
public class Fibonacci 
{
	/**used or Memoization*/
	private Map<Integer, Integer> Memoization;

	/**Constructor*/
	public Fibonacci() {
		this.initialize();
	}
	
	/**
	 * Constructor W/ precalculation of Fibonacci Numbers
	 * @param count defines the number of precalculated Fibo Numbers.
	 */
	public Fibonacci(final int count) {
		this.initialize();
		this.getList(0, count);
	}
	
	/**Used to Initialize the Memoization Object and fill it with basic escape values*/
	private void initialize() {
		this.Memoization = new HashMap<Integer, Integer>();
		this.Memoization.put(0, 0);
		this.Memoization.put(1, 1);
	}
	
	/**
	 * Used to get a Single Fibo-Number. This uses Memoization.
	 * @param count Defines the Fibo-Number you want to Calculate
	 * @return integer: The found FIbo Number
	 */
	public int getNumber(final int count) {
		return 
			this.Memoization.computeIfAbsent(
					count,
					i -> getNumber(i - 2) + getNumber(i - 1));
	}
	
	/**
	 * Method used to Access a range of Fibonacci Numbers. Uses Memoizationn.
	 * @param from where you want the range to start
	 * @param to where it should end inclusive)
	 * @return a List ontaining all Fibonaccinumbers that where found
	 */
	public List<Integer> getList(final int from, final int to){
		return IntStream.rangeClosed(from, to)
					.mapToObj(this::getNumber)
					.collect(toList());
	}
}
