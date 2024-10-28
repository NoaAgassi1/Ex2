package ex2.gui;

import ex2.geo.Circle_2D;
import ex2.geo.GeoShape;
import ex2.geo.Point_2D;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class GUIShapeTest {

    @Test
    void isFilled() {
        Point_2D cen = new Point_2D(0,0);
        GeoShape circle = new Circle_2D(cen,5);
        GUI_Shape g = new GUIShape(circle,true, Color.RED,1);
        boolean filled = g.isFilled();
        assertTrue(filled);
    }

    @Test
    void copy() {
        Point_2D c= new Point_2D(0,0);
        GUIShape gn = new GUIShape (new Circle_2D(c,5),true, Color.black,2);
        GUIShape g2 = (GUIShape) gn.copy();
        assertEquals(gn,g2);

    }

    @Test
    void isSelected() {
        Point_2D c= new Point_2D(0,0);
        GUIShape gn = new GUIShape (new Circle_2D(c,5),true, Color.black,2);
        gn.setSelected(true);
        boolean selected = gn.isSelected();
        assertTrue(selected);
    }
}