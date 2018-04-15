package math.shape;

/**
 * Base Interface to be implemented in all 2 d shapes.
 * 
 * @author hdaiv_000
 * @since  0.14
 */
public interface I_Shape2D 
{
	/**
	 * Method used to calculate the circumference of a shape
	 * @return A Double of the circumference.
	 */
	public double circumference();

	/**
	 * Method used to calculate the circumference of a shape
	 * @return a Double of the Area
	 */
	public double area();
}
