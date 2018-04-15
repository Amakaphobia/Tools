package math.shape;

/**
 * Basic shape to represent a Square. It extends {@link Rectangle}.
 * @author hdaiv_000
 * @since 0.014
 */
public class Square extends Rectangle{

	/**
	 * Constructor
	 * @param a Length
	 */
	public Square(double a) {
		super(a, a);
	}
	@Override
	public String toString() {
		return String.format("Square: a = %s", this.a);
	}
}
