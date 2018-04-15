package math.shape;

/**
 * Basic Shape used to represent a rectangle.
 * @author hdaiv_000
 * @since 0.014
 */
public class Rectangle implements I_Shape2D 
{
	/**Length of the first side*/
	protected final double a;
	/**Length of the second side*/
	protected final double b;
	
	/**
	 * Constructor
	 * @param a first side greater than zero
	 * @param b second side greater than zero
	 */
	public Rectangle(double a, double b) {
		if(a <= 0 || b <= 0 ) throw new IllegalArgumentException("Rechtecke können nicht ohne Länge oder mit Negativer Länge kreiert werden.");
		this.a = a;
		this.b = b;
	}

	@Override
	public double circumference() {
		return 2 * this.a + 2 * this.b;
	}

	@Override
	public double area() {
		return this.a * this.b;
	}
	
	/**
	 * getter for the first side
	 * @return a.
	 */
	public double getA() { return a; }

	/**
	 * getter for the second side
	 * @return b.
	 */
	public double getB() { return b; }

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(!(obj instanceof Rectangle)) return false;
		
		Rectangle other = (Rectangle) obj;
		return (this.a == other.a && this.b == other.b) ||
			   (this.b == other.a && this.a == other.b);
	}
	
	@Override
	public int hashCode() {
		return Double.hashCode(this.a) + Double.hashCode(this.b);
	}
	
	@Override
	public String toString() {
		return String.format("Rectangle: a = %s, b = %s", this.a, this.b);
	}
}
