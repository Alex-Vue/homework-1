/* 
 * CompSci 351-401
 * CompSci 351-802
 * Name: Alexander Vue
*/
package edu.uwm.cs351;

/**
 * A point in two-dimensional Euclidean space.
 * This class is immutable.
 */
public class Point implements Cloneable{

	private final double x, y;

	/**
	 * Constructor for a Point object
	 * 
	 * @param x (first field)
	 * @param y (second field)
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @return first field
	 */
	public double x() {
		return x;
	}
	
	/**
	 * @return second field
	 */
	public double y() {
		return y;
	}
	
	/**
	 * @return the first field rounded to the nearest integer.
	 */
	public int intX() {
		return (int)Math.round(x);
	}
	
	/**
	 * @return the second field rounded to the nearest integer.
	 */
	public int intY() {
		return (int)Math.round(y);
	}
	
	/**
	 * Returns the distance to the other point from here. This is
	 * done by computing the magnitude of the vector between them.
	 * 
	 * @param point
	 * @return the distance to the other point from here.
	 */
//	public double distance(Point point) {
		
//	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Point) {
			Point p = (Point) other;
			return this.x == p.x && this.y == p.y && this.hashCode() == p.hashCode();
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return (int)(7*x + 23*y);
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
		
	}
	
}
