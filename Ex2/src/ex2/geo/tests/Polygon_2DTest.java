package ex2.geo.tests;

import ex2.geo.Point_2D;
import ex2.geo.Polygon_2D;
import ex2.geo.Segment_2D;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Polygon_2DTest {

    @Test
    void getAllPoints() {
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(1, 1));
        polygon.add(new Point_2D(2, 2));
        // Get all points
        Point_2D[] points = polygon.getAllPoints();
        // Verify the number of points
        assertEquals(3, points.length);
        // Verify each point's coordinates
        assertEquals(0, points[0].x());
        assertEquals(0, points[0].y());

        assertEquals(1, points[1].x());
        assertEquals(1, points[1].y());

        assertEquals(2, points[2].x());
        assertEquals(2, points[2].y());
    }

    @Test
    void add() {
        Polygon_2D p = new Polygon_2D();
        Point_2D p1 = new Point_2D(0,0);
        Point_2D p2 = new Point_2D(2,2);
        p.add(p1);
        p.add(p2);
        assertEquals(2,p.getAllPoints().length);
        assertEquals(p1,p.getAllPoints()[0]);
        assertEquals(p2,p.getAllPoints()[1]);
    }



    @Test
    void lineOt() {
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(0, 2));
        polygon.add(new Point_2D(2, 2));

        // Test a point lying on a line segment
        assertTrue(polygon.lineOt(new Point_2D(1, 1),
                new Segment_2D(new Point_2D(0, 0), new Point_2D(0, 2))));

    }

    @Test
    void contains() {
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(0, 4));
        polygon.add(new Point_2D(4, 4));
        polygon.add(new Point_2D(4, 0));

        // Test points inside the polygon
        assertTrue(polygon.contains(new Point_2D(2, 2))); // Inside the polygon
        assertTrue(polygon.contains(new Point_2D(1, 1))); // Inside the polygon
        assertTrue(polygon.contains(new Point_2D(3, 3))); // Inside the polygon
        assertTrue(polygon.contains(new Point_2D(0, 2))); // On the border of the polygon

        // Test points outside the polygon
        assertFalse(polygon.contains(new Point_2D(5, 5))); // Outside the polygon
        assertFalse(polygon.contains(new Point_2D(-1, -1))); // Outside the polygon
        assertFalse(polygon.contains(new Point_2D(2, 5))); // Outside the polygon
        assertFalse(polygon.contains(new Point_2D(5, 2))); // Outside the polygon

    }

    @Test
    void area() {
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(0, 4));
        polygon.add(new Point_2D(4, 4));
        polygon.add(new Point_2D(4, 0));

        double expectedArea = 16.0; // The expected area of a square with side length 4
        double actualArea = polygon.area();
        assertEquals(expectedArea, actualArea, 0.0001);
    }

    @Test
    void perimeter() {
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(0, 4));
        polygon.add(new Point_2D(4, 4));
        polygon.add(new Point_2D(4, 0));

        double expectedPerimeter = 16.0; // Perimeter of a square with side length 4
        double actualPerimeter = polygon.perimeter();
        assertEquals(expectedPerimeter, actualPerimeter, 0.0001);
    }

    @Test
    void translate() {
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(1, 1));
        polygon.add(new Point_2D(4, 1));
        polygon.add(new Point_2D(3, 4));

        Point_2D translationVector = new Point_2D(2, 3);
        polygon.translate(translationVector);
    }

    @Test
    void copy() {
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(0, 4));
        polygon.add(new Point_2D(4, 4));
        polygon.add(new Point_2D(4, 0));

        Polygon_2D copy = (Polygon_2D) polygon.copy();

        // Check if the copy is deep
        for (int i = 0; i < polygon.getAllPoints().length; i++) {
            assertTrue(polygon.getAllPoints()[i].equals(copy.getAllPoints()[i]));
        }
    }

    @Test
    void scale() {
            // Creating a polygon
            Polygon_2D polygon = new Polygon_2D();
            polygon.add(new Point_2D(0, 0));
            polygon.add(new Point_2D(0, 5));
            polygon.add(new Point_2D(5, 5));
            polygon.add(new Point_2D(5, 0));

            // Scaling the polygon
            polygon.scale(new Point_2D(2.5, 2.5), 2);

            // Testing scaled points
            Point_2D[] scaledPoints = polygon.getAllPoints();
            assertEquals(new Point_2D(7.5, 7.5), scaledPoints[2]);

    }

    @Test
    void rotate() {
        // Creating a polygon
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(0, 5));
        polygon.add(new Point_2D(5, 5));
        polygon.add(new Point_2D(5, 0));

        // Translating the polygon
        polygon.translate(new Point_2D(2, 3));

        // Testing translated points
        Point_2D[] translatedPoints = polygon.getAllPoints();
        assertEquals(new Point_2D(2, 3), translatedPoints[0]);
        assertEquals(new Point_2D(2, 8), translatedPoints[1]);
        assertEquals(new Point_2D(7, 8), translatedPoints[2]);

    }
}
