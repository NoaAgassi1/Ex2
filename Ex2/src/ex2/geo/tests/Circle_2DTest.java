package ex2.geo.tests;

import ex2.geo.Circle_2D;
import ex2.geo.GeoShape;
import ex2.geo.Point_2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Circle_2DTest {

    @Test
    void contains() {
        Point_2D center = new Point_2D(0,0);
        Point_2D ot = new Point_2D(1,1);
        double red = 5;
        Circle_2D p = new Circle_2D(center,red) ;
        assertTrue(p.contains(ot));
    }
    @Test
    void area(){
        double r = 5;
        Point_2D c = new Point_2D(0,0);
        Circle_2D n = new Circle_2D(c,r);
        double ans = Math.PI*r*r;
        assertEquals(ans,n.area());
    }

    @Test
    void perimeter() {
        double r = 5;
        Point_2D c = new Point_2D(0,0);
        Circle_2D n = new Circle_2D(c,r);
        double ans = Math.PI*r*2;
        assertEquals(ans,n.perimeter());
    }

    @Test
    void translate() {
        Point_2D vec = new Point_2D(5,3);
        Circle_2D c = new Circle_2D(Point_2D.ORIGIN,5);
        c.translate(vec);
        assertEquals(c.getCenter(),vec);

    }

    @Test
    void copy() {
        Circle_2D c = new Circle_2D(Point_2D.ORIGIN,3);
        GeoShape a = c.copy();
        assertEquals(c.getCenter(),((Circle_2D)a).getCenter());
        assertEquals(c.getRadius(),((Circle_2D) a).getRadius());
    }

    @Test
    void scale() {
        Circle_2D c = new Circle_2D(Point_2D.ORIGIN,3);
        c.scale(Point_2D.ORIGIN,2);
        Circle_2D n = new Circle_2D(Point_2D.ORIGIN,6);
        assertEquals(n.getRadius(),c.getRadius());
        assertEquals(n.getCenter(),c.getCenter());
    }

}