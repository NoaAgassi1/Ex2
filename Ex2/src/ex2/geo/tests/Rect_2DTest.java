package ex2.geo.tests;

import ex2.geo.GeoShape;
import ex2.geo.Point_2D;
import ex2.geo.Rect_2D;
import ex2.geo.Triangle_2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Rect_2DTest {

    @Test
    void contains() {
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(0, 2);
        Point_2D p3 = new Point_2D(2, 2);
        Point_2D p4 = new Point_2D(2, 0);
        Rect_2D rectangle = new Rect_2D(p1, p3);
        Point_2D ot = new Point_2D(1, 1);
        Triangle_2D t1 = new Triangle_2D(p1,p2,ot);
        Triangle_2D t2 = new Triangle_2D(p2,p3,ot);
        Triangle_2D t3 = new Triangle_2D(p3,p4,ot);
        Triangle_2D t4 = new Triangle_2D(p4,p1,ot);
        double sum = t1.area()+t2.area()+t3.area()+t4.area();
        boolean res = rectangle.contains(ot);
        assertEquals(sum,rectangle.area(),0.0001);
    }

    @Test
    void area() {
        Point_2D p1 = new Point_2D(0,0);
        Point_2D p2 = new Point_2D(4,4);
        Rect_2D r = new Rect_2D(p1,p2);
        assertEquals(16,r.area());
    }

    @Test
    void perimeter() {
        Point_2D p1 = new Point_2D(0,0);
        Point_2D p2 = new Point_2D(4,4);
        Rect_2D r = new Rect_2D(p1,p2);
        assertEquals(16,r.perimeter());
    }

    @Test
    void translate() {
        Point_2D p1 = new Point_2D(0,0);
        Point_2D p2 = new Point_2D(4,4);
        Point_2D vec = new Point_2D(2,2);
        Rect_2D r = new Rect_2D(p1,p2);
        r.translate(vec);
        Point_2D expectedP1 = new Point_2D(2, 2);
        Point_2D expectedP2 = new Point_2D(6, 6);
        assertEquals(expectedP1,r.get_p1());
        assertEquals(expectedP2,r.get_p2());
    }

    @Test
    void copy() {
        Point_2D p1 = new Point_2D(0,0);
        Point_2D p2 = new Point_2D(4,4);
        Rect_2D r = new Rect_2D(p1,p2);
        GeoShape copy = r.copy();
        assertTrue(copy instanceof Rect_2D);
    }

    @Test
    void scale() {
        Point_2D p1 = new Point_2D(0,0);
        Point_2D p2 = new Point_2D(4,4);
        Point_2D cen = new Point_2D(6,6);
        double ratio = 2;
        Rect_2D r = new Rect_2D(p1,p2);
        r.scale(cen,ratio);

    }

    @Test
    void rotate() {
        Point_2D p1 = new Point_2D(0,0);
        Point_2D p2 = new Point_2D(4,4);
        Point_2D p3 = new Point_2D(0,4);
        Point_2D p4 = new Point_2D(4,0);
        Point_2D cen = new Point_2D(2,2);
        Rect_2D r = new Rect_2D(p1,p2);
        r.rotate(cen,2);

    }
}