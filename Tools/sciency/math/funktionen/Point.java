package math.funktionen;

import boxes.Pair;

/**
 * Class used to model Points on a two dimensional plane 
 * @author Dave
 *
 */
public class Point implements Comparable<Point>
{
	/**Coords*/
	 Pair<Double, Double> Coords;	
	 
	
	/**
	 * Constructor
	 * @param x xCoordinate of new Point
	 * @param y yCoordinate of new Point
	 */
	public Point(double x, double y)
	{
		this.Coords = new Pair<Double, Double>(x, y);
	}
	
	/**
	 * used to Access the xCoordinate
	 * @return the xvalue
	 */
	public double getX(){return this.Coords.getKey();}
	
	/**
	 * used to Access the YCoordinate
	 * @return the yvalue
	 */
	public double getY(){return this.Coords.getValue();}
	
	/**
	 * used to access the coords
	 * @return the Pair of doubles representing the coords
	 */
	public Pair<Double,Double> getCoords(){return this.Coords;}
	
	/**
	 * used to calculate the difference between 2 points
	 * @param o the other point
	 * @return the distance as a double
	 */
	public double getDistance(Point o)
	{
		double dX = this.getX() - o.getX();
		double dY = this.getY() - o.getY();
		
		return Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2));
	}
	

	@Override
	public int compareTo(Point o) {
		if(this.getX() > o.getX())
			return 1;
		if(this.getX() < o.getX())
			return -1;
		//x == x
		if(this.getY() > o.getY())
			return 1;
		if(this.getY() < o.getY())
			return -1;
		
		// x == x und y == y
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(!(obj instanceof Point)) return false;
		
		Point other = (Point) obj;
		return this.getX() == other.getX()
			&&  this.getY() == other.getY();
	}
	
	@Override
	public int hashCode() {
		double ret = this.getX() * this.getY();
		while(ret > -1 && ret < 1) 
			ret *= 1000;
		return (int)ret;
	}
	
	@Override
	public String toString() {
		return String.format("(%s|%s)", this.getX(), this.getY());
	}
}
