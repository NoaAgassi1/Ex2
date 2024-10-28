package ex2.geo;

import ex2.ex2.Ex2_Const;
import ex2.gui.Ex2;

import java.util.Objects;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle_2D implements GeoShape{
	private Point_2D _p1;
	private Point_2D _p2;
	private Point_2D _p3;

	/**
	 * Constructs a Triangle_2D object with three specified points.
	 * @param p1 The first point of the triangle.
	 * @param p2 The second point of the triangle.
	 * @param p3 The third point of the triangle.
	 */
	public Triangle_2D(Point_2D p1, Point_2D p2, Point_2D p3) {
		this._p1 = new Point_2D(p1);
		this._p2 = new Point_2D(p2);
		this._p3 = new Point_2D(p3);
	}

	/**
	 * Constructs a copy of the given triangle.
	 * @param t1 The triangle to copy.
	 */
	public Triangle_2D(Triangle_2D t1) {
		this._p1 = new Point_2D(t1._p1);
		this._p2 = new Point_2D(t1._p2);
		this._p3 = new Point_2D(t1._p3);
	}

	/**
	 * Gets all the points of the triangle.
	 * @return An array containing all the points of the triangle.
	 */
	public Point_2D[] getAllPoints() {
		Point_2D [] ans = {_p1,_p2,_p3};
		return ans;
	}

	/**
	 * Gets all the points of the triangle.
	 * @return An array containing all the points of the triangle.
	 */
	public String toString(){
		return _p1.toString()+","+_p2.toString()+","+_p3.toString();
	}

	/**
	 * Checks if the given point is contained within the triangle.
	 * Uses the method of triangulation and compares the combined area of the smaller triangles
	 * formed by the given point and two vertices of the original triangle, against the area of the original triangle.
	 * @param ot The point to check for containment.
	 * @return true if the point is contained within the triangle, otherwise false.
	 */
	@Override
	public boolean contains(Point_2D ot) {
		Triangle_2D t = new Triangle_2D(_p1,_p2,_p3);
		Triangle_2D t1 = new Triangle_2D(_p1,ot,_p2);
		Triangle_2D t2 = new Triangle_2D(_p2,ot,_p3);
		Triangle_2D t3 = new Triangle_2D(_p3,ot,_p1);
		double allArea = t1.area()+t2.area()+ t3.area();
		if (Math.abs(allArea-t.area()) <= Ex2_Const.EPS){
			return true;
		}
		return false;
	}
	/**
	 * This function calculates the distance between all sides and uses
	 * the formula of Heron's formula to calculate the area of a triangle.
	 * @return The area of the triangle.
	 */
	@Override
	public double area() {
		double a = this._p1.distance(_p2);
		double b = this._p2.distance(_p3);
		double c = this._p3.distance(_p1);
		double s = (a+b+c)/2;
		double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
		return area;
	}

	/**
	 * Calculates the perimeter of the triangle.
	 * @return The perimeter of the triangle.
	 */
	@Override
	public double perimeter() {
//		double d1 = this._p1.distance(this._p2);
//		double d2 = this._p2.distance(this._p3);
//		double d3 = this._p3.distance(this._p1);
//		return d1 + d2 + d3;
		double a = _p1.distance(_p2);
		double b = _p2.distance(_p3);
		double c = _p3.distance(_p1);
		return a+b+c ;
	}
	/**
	 * Translates the triangle by the specified vector.
	 * @param vec The vector by which to translate the triangle.
	 */
	@Override
	public void translate(Point_2D vec) {
		this._p1.move(vec);
		this._p2.move(vec);
		this._p3.move(vec);
	}

	/**
	 * Creates a deep copy of the triangle.
	 * @return A copy of the triangle.
	 */
	@Override
	public GeoShape copy() {
		return new Triangle_2D(this._p1,this._p2,this._p3);
	}


	/**
	 * Scales the triangle with respect to the specified center and ratio.
	 * @param center The center point for scaling.
	 * @param ratio The scaling ratio.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		this._p1.scale(center,ratio);
		this._p2.scale(center,ratio);
		this._p3.scale(center,ratio);
	}
	/**
	 * Rotates the triangle around the specified center point by the given angle in degrees.
	 * @param center The center point for rotation.
	 * @param angleDegrees The angle of rotation in degrees.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		this._p1.rotate(center,angleDegrees);
		this._p2.rotate(center,angleDegrees);
		this._p3.rotate(center,angleDegrees);
	}

	/**
	 *
	 * @param o
	 * @return true if the 2 triangle has the same points,dost meter the order.
	 */

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Triangle_2D that = (Triangle_2D) o;

		for (int i = 0; i < that.getAllPoints().length; i++) {
			boolean found = false;
			for (int j = 0; j < this.getAllPoints().length; j++) {
				if (that.getAllPoints()[i]==this.getAllPoints()[j]){
					found = true;
					break;
				}
			}
			if (!found) return false; // If any point doesn't match, triangles are not equal
		}
		return true;// All points match, triangles are equal
	}


}
