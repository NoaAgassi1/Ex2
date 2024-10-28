package ex2.geo;

import ex2.ex2.Ex2_Const;

import java.util.Objects;

/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect_2D implements GeoShape {
	private Point_2D _p1;
	private Point_2D _p2;
	private Point_2D _p3;
	private Point_2D _p4;

	/**
	 * Creates a 2D rectangle with the specified points.
	 * The rectangle is defined by two opposite corners, p1 and p2.
	 * The constructor ensures that p1 represents the bottom-left corner and p2 represents the top-right corner.
	 * Two additional points, p3 and p4, are calculated to represent the remaining corners of the rectangle.
	 * @param p1 The first point defining the rectangle.
	 * @param p2 The second point defining the rectangle.
	 */
	public Rect_2D(Point_2D p1, Point_2D p2) {
		this._p1 = new Point_2D(Math.min(p1.x(),p2.x()), Math.min(p1.y(),p2.y()));
		this._p2 = new Point_2D(Math.max(p1.x(),p2.x()), Math.max(p1.y(),p2.y()));
		this._p3 = new Point_2D(this._p1.x(),this._p2.y());
		this._p4 = new Point_2D(this._p2.x(),this._p1.y());
	}

	/**
	 * Creates a new 2D rectangle as a copy of the provided rectangle.
	 * @param t1 The rectangle to be copied.
	 */
	public Rect_2D(Rect_2D t1) {
		this._p1 = new Point_2D(t1._p1);
		this._p2 = new Point_2D(t1._p2);
		this._p3 = new Point_2D(t1._p3);
		this._p4 = new Point_2D(t1._p4);
	}

	/**
	 * @return array with the points of the rectangle.
	 */
	public Point_2D[] getAllPoints() {
		return new Point_2D[]{_p1, _p3, _p2, _p4};
	}

	/**
	 * Returns a string representation of the Rect_2D object.
	 */
	public String toString(){
		return _p1.toString()+","+_p2.toString();
	}

	/**
	 * Checks if a given Point_2D object is contained within the current Rect_2D object.
	 * The contains method uses four Triangle_2D objects to divide the rectangle into
	 * smaller triangles and calculates the combined area of these triangles.
	 * @param ot The Point_2D object to check for containment.
	 * @return true if the point is contained within the rectangle, false otherwise.
	 */
	@Override
	public boolean contains(Point_2D ot) {
		Triangle_2D t1 = new Triangle_2D(_p1,ot,_p3);
		Triangle_2D t2 = new Triangle_2D(_p3,ot,_p2);
		Triangle_2D t3 = new Triangle_2D(_p2,ot,_p4);
		Triangle_2D t4 = new Triangle_2D(_p4,ot,_p1);
		double allArea = t1.area()+t2.area()+t3.area()+t4.area();
		if (Math.abs(allArea-this.area()) < Ex2_Const.EPS){
			return true;
		}
		return false;
	}
	/**
	 * Calculates the area using the function distance between 2 points.
	 * @return the area of the rect.
	 */
	@Override
	public double area() {
		double a = _p1.distance(_p3);
		double b = _p2.distance(_p3);
		return a*b;
	}
	/**
	 * Calculates the perimeter using the function distance between 2 points.
	 * @return the perimeter of the rect.
	 */
	@Override
	public double perimeter() {
		double a = _p1.distance(_p3);
		double b = _p2.distance(_p3);
		return (a*2)+(b*2);
	}
	/**
	 * translates the Rect_2D object by a given Point_2D vector.
	 * The translation method takes a Point_2D vector (vec) as a parameter.
	 * @param vec The Point_2D vector by which to translate the rectangle.
	 */
	@Override
	public void translate(Point_2D vec) {
		_p1.move(vec);
		_p2.move(vec);
		_p3.move(vec);
		_p4.move(vec);
	}

	/**
	 * creates a deep copy of the current Rect_2D object.
	 * @return A new GeoShape object that is a copy of the rectangle.
	 */
	@Override
	public GeoShape copy() {
		return new Rect_2D(_p1,_p2);
	}
	/**
	 * Scales the Rect_2D object around a given center point by a specified ratio.
	 * The scale method scales the Rect_2D object by a given ratio around a specified center point.
	 * @param center The center point around which the rectangle is scaled.
	 * @param ratio  The scaling ratio.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		_p1.scale(center,ratio);
		_p2.scale(center,ratio);
		_p3.scale(center,ratio);
		_p4.scale(center,ratio);
	}

	/**
	 * Rotates the Rect_2D object around a given center point by a specified angle in degrees.
	 * The rotate method rotates the Rect_2D object around a specified center point
	 * by a given angle in degrees.
	 * @param center The center point around which the rectangle is rotated.
	 * @param angleDegrees The rotation angle in degrees.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		_p1.rotate(center,angleDegrees);
		_p2.rotate(center,angleDegrees);
		_p3.rotate(center,angleDegrees);
		_p4.rotate(center,angleDegrees);
	}

	public Point_2D get_p1(){return this._p1;}
	public Point_2D get_p2(){return this._p2;}
	public Point_2D get_p3(){return this._p3;}
	public Point_2D get_p4(){return this._p4;}

	/**
	 *
	 * @param o
	 * @return true if the 2 rectangle has the same points.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Rect_2D rect2D = (Rect_2D) o;
		return Objects.equals(_p1, rect2D._p1) && Objects.equals(_p2, rect2D._p2) || Objects.equals(_p2, rect2D._p1) && Objects.equals(_p1, rect2D._p2);
	}


}
