package math.funktionen;

import java.util.Objects;
import java.util.function.Function;


/**
 * Class used to represent a Mathemical Functions that will give a single consistent output for every input.
 * This class implements the {@link Function} Interface and uses it calculate all points of the function. 
 * @author hdaiv_000
 * @since V0.14
 */
public class Funktion implements Function<Double, Double>
{
	/**FUnction used*/
	protected Function<Double, Double> funktion;
	
	/**
	 * Reduced Visibility for the constructor to Force extensions of this class to be used.
	 * @param funktion the Function you want to emulate
	 */
	protected Funktion(Function<Double, Double> funktion) {
		Objects.requireNonNull(funktion);
		this.funktion = funktion;
	}
	
	/**
	 * Tests if a given {@link Point} is part of the funktion
	 * @param p1 the point you want to test
	 * @return true if the point is part of the Functionen false if not
	 */
	public boolean testPoint(Point p1) {
		return this.funktion.apply(p1.getX()) == p1.getY();
	}
	
	/**
	 * Given a X-Value for a point the function will return the point
	 * @param x  x-Value
	 * @return Point of the funktion on that part
	 */
	public Point getPointOf(double x) {
		return new Point(x, this.apply(x));
	}
	
	/**
	 * Method used to add 2 funktions <code>f(x) = g(x) + h(x)</code>
	 * @param other the function to be added to this one
	 * @return the new function
	 */
	public Funktion add(Funktion other) {
		Objects.requireNonNull(other);
		return new Funktion (x -> 
			this.funktion.apply(x) + other.funktion.apply(x));
	}
	
	/**
	 * Method used to substract 2 funktions <code>f(x) = g(x) - h(x)</code>
	 * @param other the function to be substracted to this one
	 * @return the new function
	 */
	public Funktion substract(Funktion other) {
		Objects.requireNonNull(other);
		return new Funktion (x -> 
			this.funktion.apply(x) - other.funktion.apply(x));
	}
	
	/**
	 * Method used to multiply 2 funktions <code>f(x) = g(x) + h(x)</code>
	 * @param other the function to be multiplied to this one
	 * @return the new function
	 */
	public Funktion multiply(Funktion other) {
		Objects.requireNonNull(other);
		return new Funktion (x -> 
			this.funktion.apply(x) * other.funktion.apply(x));
	}
	
	/**
	 * Method used to devide 2 funktions <code>f(x) = g(x) / h(x)</code>
	 * @param other the function to be devided to this one
	 * @return the new function
	 */
	public Funktion devide(Funktion other) {
		Objects.requireNonNull(other);
		return new Funktion (x -> 
			this.funktion.apply(x) / other.funktion.apply(x));
	}
	
	@Override
	public Double apply(Double x) {
		return this.funktion.apply(x);
	}
	
	/**
	 * Getter function to access the {@link Function} directly
	 * @return the Function used by this class
	 */
	public Function<Double, Double> getFunktion(){ return this.funktion; }

	

}
