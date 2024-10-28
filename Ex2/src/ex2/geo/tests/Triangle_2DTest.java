package ex2.geo.tests;

import ex2.geo.Point_2D;
import ex2.geo.Triangle_2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Triangle_2DTest {

    @Test
    void getAllPoints() {
        Point_2D p1 = new Point_2D(0,0);
        Point_2D p2 = new Point_2D(4,4);
        Point_2D p3 = new Point_2D(4,4);
        Triangle_2D t = new Triangle_2D(p1,p2,p3);
        assertEquals(t.getAllPoints()[0],p1);
        assertEquals(t.getAllPoints()[1],p2);
        assertEquals(t.getAllPoints()[2],p3);
    }

    @Test
    void contains() {
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(4, 0);
        Point_2D p3 = new Point_2D(2, 4);
        Triangle_2D triangle = new Triangle_2D(p1, p2, p3);

        // Create a point known to be inside the triangle
        Point_2D insidePoint = new Point_2D(2, 2);
        Point_2D notinside = new Point_2D(6,6);

        // Check if the triangle contains the inside point
        assertTrue(triangle.contains(insidePoint));
        assertFalse(triangle.contains(notinside));
    }

    @Test
    void area() {
        Point_2D p1 = new Point_2D(0,0);
        Point_2D p2 = new Point_2D(4,0);
        Point_2D p3 = new Point_2D(4,4);
        Triangle_2D t = new Triangle_2D(p1,p2,p3);
        assertEquals(t.area(),8,0.001);
    }

    @Test
    void perimeter() {
        Point_2D p1 = new Point_2D(0,0);
        Point_2D p2 = new Point_2D(0,3);
        Point_2D p3 = new Point_2D(4,0);
        Triangle_2D t = new Triangle_2D(p1,p2,p3);
        assertEquals(t.perimeter(),12);
    }

    @Test
    void translate() {
        Point_2D p1 = new Point_2D(0,0);
        Point_2D p2 = new Point_2D(4,4);
        Point_2D p3 = new Point_2D(4,4);
        Triangle_2D t = new Triangle_2D(p1,p2,p3);
        Point_2D vec = new Point_2D(2,2);
        t.translate(vec);
        Point_2D [] tran = t.getAllPoints();
        Point_2D p1translate = new Point_2D(2,2);
        Point_2D p2translate = new Point_2D(6,6);
        Point_2D p3translate = new Point_2D(6,6);

        assertEquals(tran[0],p1translate);
        assertEquals(tran[1],p2translate);
        assertEquals(tran[2],p3translate);
    }

    @Test
    void copy() {
        Point_2D p1 = new Point_2D(0,0);
        Point_2D p2 = new Point_2D(4,4);
        Point_2D p3 = new Point_2D(4,4);
        Triangle_2D t = new Triangle_2D(p1,p2,p3);
        Triangle_2D a =(Triangle_2D) t.copy();
        assertEquals(a.getAllPoints()[0],t.getAllPoints()[0]);
        assertEquals(a.getAllPoints()[1],t.getAllPoints()[1]);
        assertEquals(a.getAllPoints()[2],t.getAllPoints()[2]);
    }

    @Test
    void scale() {
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(0, 3);
        Point_2D p3 = new Point_2D(4, 0);
        Triangle_2D triangle = new Triangle_2D(p1, p2, p3);
        Point_2D center = new Point_2D(1, 1);
        double ratio = 2.0;
        triangle.scale(center, ratio);
        // Create the expected scaled points
        Point_2D expectedP1 = new Point_2D(-1, -1);
        Point_2D expectedP2 = new Point_2D(-1, 5);
        Point_2D expectedP3 = new Point_2D(7, -1);
        assertEquals(expectedP1, triangle.getAllPoints()[0]);
        assertEquals(expectedP2, triangle.getAllPoints()[1]);
        assertEquals(expectedP3, triangle.getAllPoints()[2]);
    }

    @Test
    void rotate() {
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(0, 2);
        Point_2D p3 = new Point_2D(2, 0);
        Triangle_2D triangle = new Triangle_2D(p1, p2, p3);
        Point_2D center = new Point_2D(0, 0);
        double angleDegrees = 90.0;
        triangle.rotate(center,angleDegrees);
        Point_2D expectedP1 = new Point_2D(0, 0);
        Point_2D expectedP2 = new Point_2D(-2, 0);
        Point_2D expectedP3 = new Point_2D(0, 2);
        assertEquals(expectedP1, triangle.getAllPoints()[0]);

    }
}