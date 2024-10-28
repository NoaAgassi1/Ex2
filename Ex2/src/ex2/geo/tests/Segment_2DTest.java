package ex2.geo.tests;

import ex2.geo.Point_2D;
import ex2.geo.Segment_2D;
import ex2.geo.Triangle_2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Segment_2DTest {

    @Test
    void get_p1() {
        Point_2D p1 = new Point_2D(1,1);
        Point_2D p2 = new Point_2D(3,4);
        Segment_2D s = new Segment_2D(p1,p2);
        Point_2D ans = s.get_p1();
        assertEquals(ans,s.get_p1());
    }

    @Test
    void get_p2() {
        Point_2D p1 = new Point_2D(2,1);
        Point_2D p2 = new Point_2D(5,4);
        Segment_2D s = new Segment_2D(p1,p2);
        Point_2D ans = s.get_p2();
        assertEquals(ans,s.get_p2());
    }

    @Test
    void contains() {
        Point_2D p1 = new Point_2D(1,1);
        Point_2D p2 = new Point_2D(5,5);
        Segment_2D s = new Segment_2D(p1,p2);
        Point_2D ot = new Point_2D(1,1);
        boolean t = s.contains(ot);
        assertTrue(t);
    }

    @Test
    void perimeter() {
        Point_2D p1 = new Point_2D(1,1);
        Point_2D p2 = new Point_2D(5,5);
        Segment_2D s = new Segment_2D(p1,p2);
        double ans = s.perimeter();
        assertEquals(s.perimeter(),ans);
    }

    @Test
    void translate() {
        Point_2D a = new Point_2D(0,0);
        Point_2D b = new Point_2D(5,5);
        Segment_2D s = new Segment_2D(a,b);
        Point_2D p = new Point_2D(2,0);
        s.translate(p);
    }

    @Test
    void copy() {
        Point_2D a = new Point_2D(0,0);
        Point_2D b = new Point_2D(5,5);
        Segment_2D s = new Segment_2D(a,b);
        Segment_2D s2 = (Segment_2D) s.copy();
        assertEquals(s.get_p1(),s2.get_p1());
        assertEquals(s.get_p2(),s2.get_p2());

    }

    @Test
    void scale() {
        Point_2D p1 = new Point_2D(1, 1);
        Point_2D p2 = new Point_2D(3, 3);
        Segment_2D segment = new Segment_2D(p1, p2);

        Point_2D center = new Point_2D(2, 2);
        double ratio = 2.0;
        segment.scale(center, ratio);
        // Calculate the expected scaled endpoints
        Point_2D expectedP1 = new Point_2D(0, 0);
        Point_2D expectedP2 = new Point_2D(4, 4);
        Point_2D scaledP1 = segment.get_p1();
        Point_2D scaledP2 = segment.get_p2();
        assertEquals(expectedP1, scaledP1);
        assertEquals(expectedP2, scaledP2);
    }

    @Test
    void rotate() {
        Point_2D p1 = new Point_2D(1, 1);
        Point_2D p2 = new Point_2D(3, 3);
        Segment_2D segment = new Segment_2D(p1, p2);
        Point_2D center = new Point_2D(2, 2);
        double angleDegrees = 90.0;
        segment.rotate(center, angleDegrees);
        Point_2D expectedP1 = new Point_2D(3, 1);
        Point_2D expectedP2 = new Point_2D(1, 3);
        Point_2D rotatedP1 = segment.get_p1();
        Point_2D rotatedP2 = segment.get_p2();

        // Assert that the rotated endpoints match the expected values
        assertEquals(expectedP1, rotatedP1);
        assertEquals(expectedP2, rotatedP2);
    }


}