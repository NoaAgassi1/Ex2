package ex2.geo;

import ex2.ex2.Ex2_Const;

import java.util.Objects;

/**
 * This class represents a 2D segment on the plane, 
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class Segment_2D implements GeoShape{
	private Point_2D _p1;
	private Point_2D _p2;

	/**
	 * Constructs a Segment_2D object with two given points.
	 * @param a The first point of the segment.
	 * @param b The second point of the segment.
	 */
	public Segment_2D(Point_2D a, Point_2D b) {
		if(a.x()<b.x()){
			_p1 = new Point_2D(a);
			_p2 = new Point_2D(b);
		} else {
			_p1 = new Point_2D(b);
			_p2 = new Point_2D(a);
		}
	}

	/**
	 * Constructs a Segment_2D object by copying another Segment_2D object.
	 * @param t1 The Segment_2D object to copy.
	 */
	public Segment_2D(Segment_2D t1) {
		_p1 = new Point_2D(t1.get_p1());
		_p2 = new Point_2D(t1.get_p2());
	}

	/**
	 * @return The first point of the segment.
	 */
	public Point_2D get_p1() {return new Point_2D(_p1);}
	/**
	 * @return The second point of the segment.
	 */
	public Point_2D get_p2() {
		return new Point_2D(_p2);
	}

	/**
	 * Checks if a given point lies on the line segment defined by the current instance.
	 * If the line segment is vertical (no incline), it checks if the x-coordinate of the
	 * given point matches the x-coordinate of the line segment.
	 * If the line segment has an incline, it checks if the y-coordinate of the given point
	 * lies on the line defined by the two endpoints of the segment within the x-coordinate range of the segment.
	 * @param ot - a query 2D point
	 */
	@Override
	public boolean contains(Point_2D ot) {
		if(this._p1.x()==this._p2.x()){ // no incline
			if (ot.x()==this._p2.x()){
				return true;
			}
			else {
				return false;
			}
		}
		double m= (this._p1.y()-this._p2.y())/(this._p1.x()-this._p2.x());
		double b= (this._p1.y()-(m*this._p1.x()));
		if (ot.y()== (m*ot.x())+b && ot.x()<= get_p2().y() && ot.x()>= get_p1().y()){
			return true;
		}
		return false;
	}

	@Override
	public double area() {
		return 0;
	}

	/**
	 * Returns the perimeter of the segment.
	 * The perimeter method returns the perimeter of the segment.
	 * For a line segment, the perimeter is equal to the length of the segment multiplied by 2.
	 * @return The perimeter of the segment, which is equal to the length of the segment multiplied by 2.
	 */
	@Override
	public double perimeter() {
		return _p1.distance(_p2)*2;
	}
	/**
	 * Translates the segment by a given vector.
	 * The translation method translates the segment by a given vector vec.
	 * It moves both p1 and p2 by adding the vector components to their respective coordinates.
	 * @param vec The vector by which to translate the segment.
	 */
	@Override
	public void translate(Point_2D vec) {
		this._p1.move(vec);
		this._p2.move(vec);
	}
	/**
	 * Creates a deep copy of the segment.
	 */
	@Override
	public GeoShape copy() {
		return new Segment_2D(_p1,_p2);
	}
	/**
	 * Scales the segment with respect to a given center point and a scaling ratio.
	 * The scale method scales the segment with respect to a given center point center and a scaling ratio ratio.
	 * @param center The center point of scaling.
	 * @param ratio  The scaling ratio.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		_p1.scale(center,ratio);
		_p2.scale(center,ratio);
	}
	/**
	 * Rotates the segment around a given center point by a specified angle in degrees.
	 * @param center The center point around which the segment is rotated.
	 * @param angleDegrees The rotation angle in degrees.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		_p1.rotate(center,angleDegrees);
		_p2.rotate(center,angleDegrees);
	}
	/**
	 * @return a string representation of the segment in the format "Segment_2D, (p1), (p2)".
	 */
	public String toString(){
		return this._p1.toString() +"," +this._p2.toString();
	}

	/**
	 * @param o
	 * @return if two segment have the same points,doesn't meter the order.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Segment_2D segment2D = (Segment_2D) o;
		return Objects.equals(_p1, segment2D._p1) && Objects.equals(_p2, segment2D._p2) ||Objects.equals(_p2, segment2D._p1) && Objects.equals(_p1, segment2D._p2);
	}

}