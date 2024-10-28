package ex2.gui;
/**
 * This class implements the GUI_shape.
 * Ex2: you should implement this class!
 * @author I2CS
 */
import ex2.geo.*;
import java.awt.*;
import java.util.Objects;

public class GUIShape implements GUI_Shape{
	private GeoShape _g = null;
	private boolean _fill;
	private Color _color;
	private int _tag;
	private boolean _isSelected;
	
	public GUIShape(GeoShape g, boolean f, Color c, int t) {
		_g = null;
		if (g!=null) {_g = g.copy();}
		_fill= f;
		_color = c;
		_tag = t;
		_isSelected = false;
	}
	public GUIShape(GUIShape ot) {
		this(ot._g, ot._fill, ot._color, ot._tag);
	}

	public GUIShape(String s) {
		String[] parts = s.split(",");// Split the ToString
		String shapeType = parts[4];// parts[4] is the type of the shape
		double x, y;
		_fill = Boolean.parseBoolean(parts[2]);// parts[2] is "true" or "false" representing if it filled or not
		_tag = Integer.parseInt(parts[3]);// parts[3] is the tag
		int numberofcolor = Integer.parseInt(parts[1]); // parts [1] is the number of color
		_color = new Color(numberofcolor);// Create the Color object
		if (shapeType.equals("Circle_2D")) {
			x = Double.parseDouble(parts[5]);
			y = Double.parseDouble(parts[6]);
			double radius = Double.parseDouble(parts[7]);
			Point_2D p = new Point_2D(x, y);
			_g = new Circle_2D(p, radius);
		} else {
			Point_2D[] points = new Point_2D[(parts.length - 4) / 2];
			int j = 5;
			for (int i = 0; i < points.length; i++) {
				x = Double.parseDouble(parts[j]);
				y = Double.parseDouble(parts[j + 1]);
				points[i] = new Point_2D(x, y);
				j = j + 2;
			}
			if (shapeType.equals("Segment_2D")) {
				_g = new Segment_2D(points[0], points[1]);
			}
			if (shapeType.equals("Triangle_2D")) {
				_g = new Triangle_2D(points[0], points[1], points[2]);
			}
			if (shapeType.equals("Rect_2D")) {
				_g = new Rect_2D(points[0], points[2]);
			}
			if (shapeType.equals("Polygon_2D")) {
				Polygon_2D polygon = new Polygon_2D();
				for (int i = 0; i < points.length; i++) {
					polygon.add(points[i]);
				}
				_g = polygon;

			}
		}
	}
	@Override
	public GeoShape getShape() {
		return _g;
	}

	@Override
	public void setShape(GeoShape g) {
		_g = g;
	}

	@Override
	public boolean isFilled() {
		return _fill;
	}

	@Override
	public void setFilled(boolean filled) {
		_fill = filled;
	}

	@Override
	public Color getColor() {
		return _color;
	}

	@Override
	public void setColor(Color cl) {
		_color = cl;
	}

	@Override
	public int getTag() {
		return _tag;
	}

	@Override
	public void setTag(int tag) {
		_tag = tag;
		
	}

	@Override
	public GUI_Shape copy() {
		GUI_Shape cp = new GUIShape(this);
		return cp;
	}
	@Override
	public String toString() {
		int r = _color.getRed();
		int b = _color.getBlue();
		int g = _color.getGreen();

		int ce = r*256*256 + g*256 + b;
		String ans = this.getClass().getSimpleName()+","+
				ce+","+_fill+","+_tag+","+this._g.getClass().getSimpleName()+","+_g.toString();
		return ans;
	}
	@Override
	public boolean isSelected() {
		return this._isSelected;
	}
	@Override
	public void setSelected(boolean s) {
		this._isSelected = s;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GUIShape guiShape = (GUIShape) o;
		return _fill == guiShape._fill && _tag == guiShape._tag && _isSelected == guiShape._isSelected && Objects.equals(_g, guiShape._g) && Objects.equals(_color, guiShape._color);
	}

}
