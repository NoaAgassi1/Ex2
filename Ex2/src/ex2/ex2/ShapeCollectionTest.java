package ex2.ex2;

import ex2.geo.*;
import ex2.gui.Ex2;
import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.*;

class ShapeCollectionTest {

    @Test
    void get() {
        ShapeCollection collection = new ShapeCollection();

        Point_2D p1 = new Point_2D(3,4);
        Point_2D p2 = new Point_2D(6,8);
        Circle_2D c1 = new Circle_2D(p1,2);
        Circle_2D c2 = new Circle_2D(p1,4);
        GUI_Shape g1 = new GUIShape(c1,true, Color.RED,1);
        GUI_Shape g2 = new GUIShape(c2,false, Color.pink,1);

        collection.add(g1);
        collection.add(g2);
        assertEquals(collection.get(0),g1);
    }

    @Test
    void size() {
        ShapeCollection shapeCollection = new ShapeCollection();
        // Add some GUIShape objects to the ShapeCollection
        shapeCollection.add(new GUIShape(new Circle_2D(new Point_2D(0, 0), 5), true, Color.RED, 1));
        shapeCollection.add(new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(5, 5)), true, Color.BLUE, 2));
        shapeCollection.add(new GUIShape(new Triangle_2D(new Point_2D(0, 0), new Point_2D(3, 0), new Point_2D(1.5, 3)), true, Color.GREEN, 3));

        // Check if the size() method returns the expected size
        assertEquals(3, shapeCollection.size());

    }

    @Test
    void removeElementAt() {
        ShapeCollection collection = new ShapeCollection();

        Point_2D p1 = new Point_2D(3,4);
        Point_2D p2 = new Point_2D(6,8);
        Circle_2D c1 = new Circle_2D(p1,2);
        Circle_2D c2 = new Circle_2D(p1,4);
        GUI_Shape g1 = new GUIShape(c1,true, Color.RED,1);
        GUI_Shape g2 = new GUIShape(c2,false, Color.pink,1);

        collection.add(g1);
        collection.add(g2);
        GUI_Shape removedShape = collection.removeElementAt(1);
        // Check if the removed shape is the expected one
        assertEquals(g2, removedShape);

    }

    @Test
    void addAt() {
        // Create a ShapeCollection object
        ShapeCollection shapeCollection = new ShapeCollection();

        // Create some GUIShape objects
        GUIShape guiShape1 = new GUIShape(new Circle_2D(new Point_2D(0, 0), 5), true, Color.RED, 1);
        GUIShape guiShape2 = new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(5, 5)), true, Color.BLUE, 2);
        GUIShape guiShape3 = new GUIShape(new Triangle_2D(new Point_2D(0, 0), new Point_2D(3, 0), new Point_2D(1.5, 3)), true, Color.GREEN, 3);

        // Add the shapes to the ShapeCollection at specific indices
        shapeCollection.addAt(guiShape1, 0);
        shapeCollection.addAt(guiShape2, 0);
        shapeCollection.addAt(guiShape3, 1);

        // Check if the size of the ShapeCollection is updated correctly
        assertEquals(3, shapeCollection.size());

        // Check if the shapes are in the correct order
        assertEquals(guiShape2, shapeCollection.get(0));
        assertEquals(guiShape3, shapeCollection.get(1));
        assertEquals(guiShape1, shapeCollection.get(2));
    }

    @Test
    void add() {
        ShapeCollection shapeCollection = new ShapeCollection();

        // Create some GUIShape objects
        GUIShape guiShape1 = new GUIShape(new Circle_2D(new Point_2D(0, 0), 5), true, Color.RED, 1);
        GUIShape guiShape2 = new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(5, 5)), true, Color.BLUE, 2);
        GUIShape guiShape3 = new GUIShape(new Triangle_2D(new Point_2D(0, 0), new Point_2D(3, 0), new Point_2D(1.5, 3)), true, Color.GREEN, 3);
        shapeCollection.add(guiShape1);
        shapeCollection.add(guiShape2);
        shapeCollection.add(guiShape3);
        assertEquals(guiShape1,shapeCollection.get(0));
        assertEquals(guiShape2,shapeCollection.get(1));
        assertEquals(guiShape3,shapeCollection.get(2));
    }


    @Test
    void sort() {
        ShapeCollection s = new ShapeCollection();
        Point_2D p1 = new Point_2D(3,4);
        Point_2D p2 = new Point_2D(6,8);
        Circle_2D c1 = new Circle_2D(p1,2);
        Circle_2D c2 = new Circle_2D(p2,3.4);
        GUI_Shape gs1 = new GUIShape(c1, true, Color.black, 1);
        GUI_Shape gs2 = new GUIShape(c2, true, Color.yellow, 2);
        s.add(gs1);
        s.add(gs2);
        s.sort(ShapeComp.CompByArea);
        assertEquals(gs2,s.get(1));
        s.sort(ShapeComp.CompByPerimeter);
        assertEquals(gs2,s.get(1));
        s.sort(ShapeComp.CompByTag);
        assertEquals(gs1,s.get(0));
        s.sort(ShapeComp.CompByTag.reversed());
        assertEquals(gs1,s.get(0));
    }

    @Test
    void removeAll() {
        ShapeCollection collection = new ShapeCollection();

        Point_2D p1 = new Point_2D(3,4);
        Point_2D p2 = new Point_2D(6,8);
        Circle_2D c1 = new Circle_2D(p1,2);
        Circle_2D c2 = new Circle_2D(p1,4);
        GUI_Shape g1 = new GUIShape(c1,true, Color.RED,1);
        GUI_Shape g2 = new GUIShape(c2,false, Color.pink,1);
        collection.removeAll();
        assertEquals(0,collection.size());
    }

    @Test
    void save() {
        // Create a ShapeCollection object
        ShapeCollection shapeCollection = new ShapeCollection();

        // Create some GUIShape objects
        GUIShape guiShape1 = new GUIShape(new Circle_2D(new Point_2D(0, 0), 5), true, Color.RED, 1);
        GUIShape guiShape2 = new GUIShape(new Rect_2D(new Point_2D(0, 0), new Point_2D(5, 5)), true, Color.BLUE, 2);
        GUIShape guiShape3 = new GUIShape(new Triangle_2D(new Point_2D(0, 0), new Point_2D(3, 0), new Point_2D(1.5, 3)), true, Color.GREEN, 3);

        // Add the shapes to the ShapeCollection
        shapeCollection.add(guiShape1);
        shapeCollection.add(guiShape2);
        shapeCollection.add(guiShape3);

        // Save the ShapeCollection to a file
        shapeCollection.save("shapes.txt");
        String s = "shapes.txt";
        File f = new File(s);
        assertTrue(f.exists());
    }

    @Test
    void load() {
        ShapeCollection shapeCollection = new ShapeCollection();

        // Load a ShapeCollection from a file
        shapeCollection.load("shapes.txt");

        // Check if the ShapeCollection was loaded correctly
        int expectedSize = 3; // Replace with the expected number of shapes in the file
        assertEquals(expectedSize, shapeCollection.size());

        for (int i = 0; i < shapeCollection.size(); i++) {
            GUI_Shape loadedShape = shapeCollection.get(i);

            // Verify properties of each loaded shape
            if (loadedShape instanceof GUIShape) {
                GUIShape guiShape = (GUIShape) loadedShape;

                // Set the expected values for the loaded shape
                Color expectedColor;
                boolean expectedFilled;

                // Set expected values based on shape type or any other criteria
                if (guiShape.getShape() instanceof Circle_2D) {
                    expectedColor = Color.RED;
                    expectedFilled = true;
                    // Set other properties specific to Circle_2D if needed
                } else if (guiShape.getShape() instanceof Rect_2D) {
                    expectedColor = Color.BLUE;
                    expectedFilled = true;
                    // Set other properties specific to Rect_2D if needed
                } else if (guiShape.getShape() instanceof Triangle_2D) {
                    expectedColor = Color.GREEN;
                    expectedFilled = true;
                    // Set other properties specific to Triangle_2D if needed
                } else {
                    // Handle other shape types if necessary
                    // You may throw an exception or set default values
                    expectedColor = Color.BLACK;
                    expectedFilled = false;
                }

                // Verify the properties of the loaded shape
                assertEquals(expectedColor, guiShape.getColor());
                assertEquals(expectedFilled, guiShape.isFilled());
                // assertEquals(expectedLayer, guiShape.getLayer()); // Uncomment and provide expected layer value
            }
        }
    }
}