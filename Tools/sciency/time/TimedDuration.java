package time;

import static java.time.Duration.of;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import utils.XStringBuilder;

/**
 * TimedDuration represents a slice of time with start and end point.
 * @author Dave
 * @since V0.14
 */
public class TimedDuration 
{
	/**DUration Between the 2 DateTimes*/
	private final Duration Time;
	/**The Starting Point*/
	private final LocalDateTime Start;
	/**The finishing Point*/
	private final LocalDateTime End;
	
	/**
	 * Constructor (Private) use static methods <code>TimedDuration.from(),TimedDuration.until(),TimedDuration.between()</code>
	 * instead
	 * @param Start	StartPoint
	 * @param End	EndPoint
	 * @param Time	Duration in between
	 */
	private TimedDuration(LocalDateTime Start, LocalDateTime End, Duration Time) {
		this.Time = Time;
		this.Start = Start;
		this.End = End;
	}
	
	/**
	 * Method used to create a TimedDuration with a StartingPoint, a number of Time and a TimeUnit
	 * @param Start	LocalDateTime StartingPoint
	 * @param Time	long containing how long the Duration is
	 * @param Unit	TemporalUnit defining the time parameter of this method
	 * @return the new TimedDuration Object
	 */
	public static TimedDuration from(LocalDateTime Start, long Time, TemporalUnit Unit) {
		Duration Duration = of(Time, Unit);		
		return from(Start, Duration);
	}
	
	/**
	 * Method used to create a TimedDuration with a EndingPoint, a number of Time and a TimeUnit
	 * @param End	LocalDateTime EndingPoint
	 * @param Time	long containing how long the Duration is
	 * @return the new TimedDuration Object
	 */
	public static TimedDuration until(LocalDateTime End, long Time) {
		Duration Duration = of(Time, ChronoUnit.MILLIS);
		return until(End, Duration);
	}
	
	/**
	 * Method used to create a TimedDuration with a StartingPoint and a Duration
	 * @param Start	StartingPoint
	 * @param Time	Duration
	 * @return the new TimedDuration Object
	 */
	public static TimedDuration from(LocalDateTime Start, Duration Time) {
		LocalDateTime End = Start.plus(Time);
		return new TimedDuration(Start, End, Time);
	}
	
	/**
	 * Method used to create a TimedDuration with a EndingPoint, a Duration
	 * @param End	LocalDateTime EndingPoint
	 * @param Time	Duration
	 * @return the new TimedDuration Object
	 */
	public static TimedDuration until(LocalDateTime End, Duration Time) {
		LocalDateTime Start = End.minus(Time);
		return new TimedDuration(Start, End, Time);
	}
	
	/**
	 * Method used to create a TimedDuration between to Points in Time
	 * @param Start	StartingPoint
	 * @param End	EndingPoint
	 * @return the new TimedDuration Object
	 */
	public static TimedDuration between(LocalDateTime Start, LocalDateTime End) {
		Duration Time = of(Start.until(End, ChronoUnit.MILLIS), ChronoUnit.MILLIS);
		return new TimedDuration(Start, End, Time);
	}
	
	/**
	 * Method used to check if anonther TimeDuration Overlapps with this one
	 * @param other the other TimeDuration 
	 * @return true if it overlapps
	 */
	public boolean overlaps(TimedDuration other) {
		return
			(this.Start.isBefore(other.getStart()) 
			&& this.End.isAfter(other.getStart()))
			||
			(this.Start.isBefore(other.getEnd())
			&& this.End.isAfter(other.getEnd())
			||
			(this.Start.isEqual(other.getStart())
			|| this.End.isEqual(other.getEnd())));
	}

	/**
	 * Used to access the Duration of this TimedDuration
	 * @return the Duration object
	 */
	public Duration getDuration() { return this.Time; }
	
	/**
	 * Method used to access the passed time in a given Temporal Unit
	 * @param Unit TemporalUnit for the Duration
	 * @return long containing the Time
	 */
	public long getTime(TemporalUnit Unit) {
		return this.Time.get(Unit);
	}
	
	/**
	 * Used to access the StatingPoint
	 * @return the StartingPoint
	 */
	public LocalDateTime getStart() { return this.Start; }
	
	/**
	 * Used to access the EndingPoint
	 * @return the EndingPoint
	 */
	public LocalDateTime getEnd() { return this.End; }	
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(!(obj instanceof TimedDuration)) return false;
		
		TimedDuration other = (TimedDuration) obj;
		
		return this.Start.equals(other.Start)
			&&	this.End.equals(other.End)
			&&	this.Time.equals(other.Time);		
	}
	
	@Override
	public String toString() {
		XStringBuilder strb = new XStringBuilder("From: ");
		strb.append(this.Start.toString())
			.linesep()
			.append("Until: ")
			.append(this.End.toString())
			.linesep()
			.append("Duration: ")
			.append(this.Time.toString());
		return strb.toString();
	}
	
	@Override
	public int hashCode() {
		return this.Start.hashCode() + this.End.hashCode() + this.Time.hashCode();
	}
}