package utils;
import static java.time.LocalDateTime.now;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import time.TimedDuration;

/**
 * Class used to Time operations.
 * @author Dave
 * @since 1.13
 */
public class Timer 
{
	/**To Runable that will be timed*/
	private Runnable exec;
	
	/**
	 * Constructor
	 * @param exec THe Runnable you want to time
	 */
	public Timer(Runnable exec) {
		this.exec = exec;
	}
	
	/**
	 * using System.currentTimeMillies()
	 * Public method used to invoke the runnable exec. This method will get timestamps before and after the Runnable is invoked.
	 * it will subtract StartTime from EndTime and return a long containing the Time it took to run it in milliseconds.
	 * @return long containing Milliseconds
	 */
	public long runIt() {
		long start = System.currentTimeMillis();
		
		
		this.exec.run();
		
		long end = System.currentTimeMillis();
				
		return (end - start);
		
	}
	
	/** Using LocalDateTime und TimedDuration
	 * Public method used to invoke the runnable exec. This method will get timestamps before and after the Runnable is invoked.
	 * it will subtract StartTime from EndTime and return a long containing the Time it took to run it in the specified unit.
	 * @param Unit the Time unit you want to meassures
	 * @return long containing Milliseconds
	 * @since 0.14
	 */
	public long runIt(ChronoUnit Unit) {
		LocalDateTime End;
		LocalDateTime Start = now();
		
		this.exec.run();
		
		End = now();
		TimedDuration td = TimedDuration.between(Start, End);
		return td.getTime(Unit);
	}
}
