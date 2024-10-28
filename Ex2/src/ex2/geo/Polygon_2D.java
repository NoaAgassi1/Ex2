package ex2.geo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Polygon_2D implements GeoShape {
	private ArrayList<Point_2D> polygon;// מערך של כלל הנקודות בפוליגון

	public Polygon_2D() {
		polygon = new ArrayList<>();
	}

	/**
	 * Constructs a new Polygon_2D object by copying the points from an existing Polygon_2D object.
	 * @param po The Polygon_2D object to be copied.
	 * The points from this object will be copied to the new Polygon_2D object.
	 */
	public Polygon_2D(Polygon_2D po) {
		polygon = new ArrayList<>();
		for (int i = 0; i < po.polygon.size(); i++) {
			this.add(po.getAllPoints()[i]);
		}
	}

	/**
	 * This function creates an array of the length of all points of the polygon.
	 * The function goes through the entire array and receives the value in
	 * the i place of each point.
	 * @return array of Point_2D objects representing all the points in the polygon.
	 */
	public Point_2D[] getAllPoints() {
		Point_2D[] ans = new Point_2D[polygon.size()];//מערך נקודות בגודל של ה arraylist
		for (int i = 0; i < polygon.size(); i++) {
			ans[i] = polygon.get(i); // להוסיף למערך את הנקודה שנמצאת ב arraylist
		}
		//System.out.println(Arrays.toString(ans));
		return ans;
	}

	/**
	 * This function adds a point p to the polygon's array of points
	 * @param p
	 */
	public void add(Point_2D p) {
		polygon.add(new Point_2D(p));
	}

	/**
	 * Returns a string representation of the Polygon_2D object.
	 * The string includes the coordinates of all the points in the polygon.
	 * @return a string representation of the Polygon_2D object.
	 */
	@Override
	public String toString() {
		String ans = "";
		for (int i = 0; i < polygon.size(); i++) {
			ans = ans + polygon.get(i).toString() + ",";
		}
		return ans;
	}

	/**
	 * Checks if a point is on or to the left of a line segment.
	 * The line segment is defined by two endpoints.
	 * @param ot The point to be checked against the line segment.
	 * @param s  The line segment represented by two endpoints.
	 * @return True if the point is on or to the left of the line segment, false otherwise.
	 */
	public boolean lineOt(Point_2D ot, Segment_2D s) {
		double x1 = s.get_p1().x(), x2 = s.get_p2().x(), y1 = s.get_p1().y(), y2 = s.get_p2().y();
		if (x1 == x2) {
			return ot.x() >= x1 && ot.y() <= Math.max(y1, y2) && ot.y() >= Math.min(y1, y2);//תחזיר אמת אם
		}
		double m = (y2 - y1) / (x2 - x1);
		double x = (ot.y() - y1) / m + x1;
		return x <= ot.x() && x >= Math.min(x1, x2) && x <= Math.max(x1, x2);

	}

	/**
	 * Checks if a point is inside a polygon.
	 * The polygon is defined by an array of points forming its vertices.
	 * @param ot The point to be checked if it lies inside the polygon.
	 * @return True if the point is inside the polygon, false otherwise.
	 */
	@Override
	public boolean contains(Point_2D ot) {
		Point_2D[] points = this.getAllPoints();//מעביר למערך רגיל
		Segment_2D[] line = new Segment_2D[points.length];
		for (int i = 0; i < line.length - 1; i++) {// יוצר מערך של צלעות
			line[i] = new Segment_2D(points[i], points[i + 1]);
		}
		line[line.length - 1] = new Segment_2D(points[points.length - 1], points[0]);
		int count = 0;
		for (Segment_2D segment2D : line) {
			if (lineOt(ot, segment2D)) {
				count++;
			}
		}
		return count % 2 != 0;
	}

	/**
	 * Calculates the area of the polygon using the shoelace formula.
	 * The method assumes that the points of the polygon are ordered in either clockwise or counterclockwise direction.
	 * @return The area of the polygon.
	 */
	@Override
	public double area() {
		double a1 = polygon.get(polygon.size() - 1).x() * polygon.get(0).y();
		double a2 = polygon.get(0).x() * polygon.get(polygon.size() - 1).y();
		int size = polygon.size();

		for (int i = 0; i < size - 1; i++) {
			a1 += polygon.get(i).x() * polygon.get(i + 1).y();
			a2 += polygon.get(i + 1).x() * polygon.get(i).y();
		}
		return (Math.abs(a1 - a2)) / 2;
	}

	/**
	 * Calculates the perimeter of the polygon.
	 * @return The perimeter of the polygon.
	 */
	@Override
	public double perimeter() {
		double perimeter = 0;
		for (int i = 0; i < polygon.size() - 1; i++) {
			perimeter += polygon.get(i).distance(polygon.get(i + 1));
		}
		perimeter += polygon.get(0).distance(polygon.get(polygon.size() - 1));
		return perimeter;
	}

	/**
	 * Translates the polygon by a given vector.
	 * @param vec The vector representing the translation.
	 */
	@Override
	public void translate(Point_2D vec) {
		for (int i = 0; i < polygon.size(); i++) {
			polygon.get(i).move(vec);
		}
	}

	/**
	 * Creates a copy of the polygon.
	 * @return A new Polygon_2D object that is an exact copy of the original polygon.
	 */
	@Override
	public GeoShape copy() {
		Polygon_2D p = new Polygon_2D();
		for (int i = 0; i < polygon.size(); i++) {
			p.add(new Point_2D(polygon.get(i).x(), polygon.get(i).y()));
		}
		return p;
	}

	/**
	 * Scales the polygon relative to a specified center point by the given ratio.
	 * @param center The center point relative to which the polygon is scaled.
	 * @param ratio  The scaling ratio.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		for (Point_2D point2D : polygon) {
			point2D.scale(center, ratio);
		}
	}

	/**
	 * Rotates the polygon around a specified center point by the given angle in degrees.
	 * The rotate method is used to rotate the polygon around a specified center point.
	 * @param center The center point around which the polygon is rotated.
	 * @param angleDegrees The angle of rotation in degrees.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		for (int i = 0; i < polygon.size(); i++) {
			polygon.get(i).rotate(center, angleDegrees);
		}
	}

	/**
	 * @param o object of polygon.
	 * @return if the 2 polygon have the same points.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Polygon_2D polygon2D = (Polygon_2D) o;
		Point_2D[] thisPoint = new Point_2D[polygon.size()];
		int counter = 0;
		for (int i = 0; i < polygon2D.getAllPoints().length; i++) {
			for (int j = 0; j < thisPoint.length; j++) {
				if (polygon2D.getAllPoints()[i].equals(thisPoint[j])) {
					counter++;
				}
			}
		}
		if (counter == thisPoint.length) {
			return area() == polygon2D.area();
		}
		return false;
	}
}


