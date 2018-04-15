package math.shape;

/**
 * Basic Class to represent a circle. it Implments {@link I_Shape2D}.
 * @author hdaiv_000
 * @since V0.014
 */
public class Circle implements I_Shape2D{

	/**Radius of the Circle*/
	protected final double radius;
	
	/**
	 * Constructor
	 * @param radius greater than zero Radius of the circle
	 */
	public Circle(double radius) {
		if(radius <= 0) throw new IllegalArgumentException("Kreis Radius muss größer 0 sein");
		
		this.radius = radius;
	}
	
	/**
	 * getter for the radius.
	 * @return the radius.
	 */
	public double getRadius() {
		return radius;
	}


	@Override
	public double circumference() {
		return 2 * this.radius * Math.PI;
	}

	@Override
	public double area() {
		return this.radius * this.radius * Math.PI;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(!(obj instanceof Circle)) return false;
		
		Circle other = (Circle) obj;
		return this.radius == other.radius;
	}
	
	@Override
	public int hashCode() {
		return Double.hashCode(this.radius);
	}
	
	@Override
	public String toString() {
		return String.format("Circle: radius = %s", this.radius);
	}
}
