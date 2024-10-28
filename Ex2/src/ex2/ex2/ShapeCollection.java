package ex2.ex2;

import ex2.geo.*;
import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class represents a collection of GUI_Shape.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class ShapeCollection implements GUI_Shape_Collection {
	private ArrayList<GUI_Shape> _shapes;

	public ShapeCollection() {
		_shapes = new ArrayList<GUI_Shape>();
	}

	@Override
	public GUI_Shape get(int i) {
		return _shapes.get(i);
	}

	@Override
	public int size() {
		return _shapes.size();
	}

	@Override
	public GUI_Shape removeElementAt(int i) {
		GUI_Shape ans = _shapes.get(i);
		_shapes.remove(i);
		System.out.println(ans);
		return ans;
	}

	@Override
	public void addAt(GUI_Shape s, int i) {
		_shapes.add(i,s);
	}

	@Override
	public void add(GUI_Shape s) {
		if(s!=null && s.getShape()!=null) {
			_shapes.add(s);
		}
	}

	@Override
	public GUI_Shape_Collection copy() {
		ShapeCollection s = new ShapeCollection();
		for (int i = 0; i < s.size(); i++) {
			s.add(_shapes.get(i));
		}
		return s;
	}

	@Override
	public void sort(Comparator<GUI_Shape> comp) {
		_shapes.sort(comp);
	}

	@Override
	public void removeAll() {
		_shapes.clear();
	}

	@Override
	public void save(String file) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			for (GUI_Shape shape : _shapes) {
				writer.write(shape.toString());
				writer.newLine();
			}
			System.out.println("save" + file);
		} catch (IOException e) {
			System.err.println(" error" + e.getMessage());

		}
	}

	@Override
	public void load(String file) {
		_shapes.clear();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))){
			String line ;
			while ((line = reader.readLine()) != null){
				GUIShape shape = new GUIShape(line);
				_shapes.add(shape);
			}
		} catch (IOException e){
			System.out.println("Err"+ e.getMessage());
		}

	}

//	private GUI_Shape toGui(String line) {
//		String[] s = line.split("-");
//		boolean fill = Boolean.parseBoolean(s[2]);//אם הצורה צבועה או לא
//		int tag = Integer.parseInt(s[3]);
//		String t = s[4];
//		double x,y;
//
//		// parts[1] is a string representation of the color, e.g., "java.awt.Color[r=0,g=0,b=0]" -- CGPT
//		String colorString = s[1].substring(s[1].indexOf('[') + 1, s[1].indexOf(']'));
//		String[] colorValues = colorString.split(",");
//		int red = Integer.parseInt(colorValues[0].substring(2));
//		int green = Integer.parseInt(colorValues[1].substring(2));
//		int blue = Integer.parseInt(colorValues[2].substring(2));
//		Color color = new Color(red, green, blue);// Create the Color object
//
//		if (t.equals("Circle_2D")){
//			x = Double.parseDouble(s[5]);
//			y = Double.parseDouble(s[6]);
//			double rad = Double.parseDouble(s[7]);
//			Point_2D cen = new Point_2D(x,y);
//			Circle_2D c = new Circle_2D(cen,rad);
//			GUIShape p = new GUIShape(c,fill,color,tag);
//			return p;
//		}
//		int size = (s.length-4)/2;
//		Point_2D [] points = new Point_2D[size];
//		int start = 5;
//		for (int i = 0; i < points.length; i++) {
//			x = Double.parseDouble(s[start]);
//			y = Double.parseDouble(s[start+1]);
//			Point_2D p = new Point_2D(x,y);
//			points[i] = p;
//			start = start+2;
//		}
//		if (t.equals("Segment_2D")){
//			Segment_2D seg = new Segment_2D(points[0],points[1]);
//			GUIShape p = new GUIShape(seg,fill,color,tag);
//			return p;
//		}
//		if (t.equals("Rec_2D")){
//			Rect_2D rec = new Rect_2D(points[0],points[1]);
//			GUIShape p = new GUIShape(rec,fill,color,tag);
//			return p;
//		}
//		if (t.equals("Triangle_2D")){
//			Triangle_2D tri = new Triangle_2D(points[0],points[1],points[2]);
//			GUIShape p = new GUIShape(tri,fill,color,tag);
//			return p;
//		}
//		if (t.equals("Polygon_2D")){
//			Polygon_2D pol = new Polygon_2D();
//			for (int i = 0; i < points.length; i++) {
//				pol.add(points[i]);
//			}
//			GUIShape p = new GUIShape(pol,fill,color,tag);
//			return p;
//		}
//		return null;
//	}

	@Override
	public String toString() {
		String ans = "";
		for(int i=0;i<size();i=i+1) {
			ans += this.get(i);
		}
		return ans;
	}


}
