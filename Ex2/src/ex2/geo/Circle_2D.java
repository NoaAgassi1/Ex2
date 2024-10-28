package ex2.geo;

import java.util.Objects;

/**
 * This class represents a 2D circle in the plane. 
 * Please make sure you update it according to the GeoShape interface.
 * Ex2: you should update this class!
 * @author boaz.benmoshe
 *
 */
public class Circle_2D implements GeoShape{
	private Point_2D _center;
	private double _radius;

	/**
	 * Constructs a Circle_2D object with the given center point and radius.
	 * @param cen The center point of the circle.
	 * @param rad The radius of the circle.
	 */
	public Circle_2D(Point_2D cen, double rad) {
		this._center = new Point_2D(cen);
		this._radius = rad;
	}

	/**
	 *creates a new circle object by copying the corner points
	 * @param c the new circle.
	 */
	public Circle_2D(Circle_2D c) {
		this(c.getCenter(), c.getRadius());
	}

	/**
	 * @return the radius of the circle
	 */
	public double getRadius() {return this._radius;}

	/** @return The center of the circle.*/
	public Point_2D getCenter(){ return _center;}

	/**
	 * Prints the value of the radius and center point of the circle
	 */
	@Override
	public String toString() {
		return _center.toString()+","+_radius;
	}

	/**
	 * Determines if the Circle_2D object contains a given point.
	 * Checks if the provided point is not null and falls within the circle by comparing
	 * its distance to the center point with the radius of the circle.
	 * @param ot The point to check if it is contained within the circle.
	 * @return True if the point is contained within the circle, false otherwise.
	 * @param ot - a query 2D point
	 */
	@Override
	public boolean contains(Point_2D ot) {
		if (ot.distance(this._center) <= this._radius){
			return true;
		}
		return false;

	}

	/**
	 * Calculates the area of the Circle_2D object.
	 * The area is calculated using the formula: radius * radius * π.
	 * @return The area of the Circle_2D object.
	 */

	@Override
	public double area() {
		double p = Math.PI;
		return p*this._radius*this._radius;
	}

	/**
	 * Calculates the perimeter of the Circle_2D object.
	 * The perimeter (also known as the circumference) is calculated using
	 * the formula: 2 * π * radius.
	 * @return The perimeter of the Circle_2D object.
	 */
	@Override
	public double perimeter() {
		double p = Math.PI;
		return 2*p*this._radius;
	}

	/**
	 * Moves the circle according to the point vec that we got.
	 * @param vec - a vector from the 0,0
	 */
	@Override
	public void translate(Point_2D vec) {
		this._center.move(vec);
	}

	/**
	 * Creates a copy of the Circle_2D object.
	 * @return a new Circle_2D object that is an identical copy of the original circle.
	 */
	@Override
	public GeoShape copy() {
		return new Circle_2D(this._center,this._radius);
	}
	/**
	 * Scales the Circle_2D object by a given ratio, relative to a specified center point.
	 * The circle is scaled by multiplying its radius by the given ratio.
	 * Additionally, the center point is scaled by calling the scale method.
	 * @param center - center point from which the rescaling is being done.
	 * @param ratio - the ratio of rescaling.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		_center.scale(center,ratio);
		this._radius = this._radius*ratio;
	}
	/**
	 * Rotates the Circle_2D object by a given angle around a specified center point.
	 * The circle is rotated by calling the rotate method on the provided center point object,
	 * passing in the center point itself and the angle in degrees
	 * @param center - center point from which the rotation is being done.
	 * @param angleDegrees - the angle (in Degrees) the shape should be rotated by.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		_center.rotate(center,angleDegrees);
	}

	/**
	 *
	 * @param o object of circle
	 * @return if two circles is equals-
	 * if they have the same center point and a same radius.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Circle_2D circle2D = (Circle_2D) o;
		return Double.compare(circle2D._radius, _radius) == 0 && Objects.equals(_center, circle2D._center);
	}

}
