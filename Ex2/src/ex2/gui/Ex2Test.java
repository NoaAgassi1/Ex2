package ex2.gui;

import ex2.ex2.GUI_Shape_Collection;
import ex2.ex2.ShapeCollection;
import ex2.geo.Circle_2D;
import ex2.geo.GeoShape;
import ex2.geo.Point_2D;
import ex2.geo.Triangle_2D;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;


class Ex2Test {


    @Test
    void init() {
        Ex2 ex2 = Ex2.getInstance();
        GUI_Shape_Collection shaps2 = ex2.getShape_Collection();
        Point_2D p1 = new Point_2D(0,0);
        Point_2D p2 = new Point_2D(3,3);
        Point_2D p3 = new Point_2D(3,3);
        Triangle_2D t= new Triangle_2D(p1,p2,p3);
        GUI_Shape s = new GUIShape(t,false, Color.red,1);
        shaps2.add(s);
        Ex2 ex3 = Ex2.getInstance();
        ex3.init(shaps2);
        assertEquals(ex2.getShape_Collection(),ex3.getShape_Collection());
    }


    @Test
    void getInfo() {
        Point_2D p1 = new Point_2D(0,0);
        Point_2D p2 = new Point_2D(3,3);
        Point_2D p3 = new Point_2D(3,3);
        GeoShape Triangle_2D = new Triangle_2D(p1,p2,p3);
        GUI_Shape s = new GUIShape(Triangle_2D,false, Color.RED,1);
        Ex2 ex2 = Ex2.getInstance();
        GUI_Shape_Collection shaps1 = ex2.getShape_Collection();
        shaps1.add(s);
        String ans = ex2.getInfo();
        System.out.println(ans);
        assertTrue(ans.contains("GUIShape,16711680,false,1,Triangle_2D,0.0,0.0,3.0,3.0,3.0,3.0"));
    }

    @Test
    void show() {
        Ex2 ex2 = Ex2.getInstance();
        GUI_Shape_Collection shape = ex2.getShape_Collection();
        Point_2D p1 = new Point_2D(3,4);
        Point_2D p2 = new Point_2D(6,8);
        Circle_2D c1 = new Circle_2D(p1,2);
        Circle_2D c2 = new Circle_2D(p2,3.4);
        GUI_Shape gs1 = new GUIShape(c1,true,Color.red,1);
        GUI_Shape gs2 = new GUIShape(c2,true,Color.yellow,2);
        shape.add(gs1);
        shape.add(gs2);
        assertDoesNotThrow(() -> {
            StdDraw_Ex2.setScale(0, 10);
            ex2.show(10);
        });
    }
}