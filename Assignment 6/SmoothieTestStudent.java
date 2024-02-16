/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Tests the smoothie class
 * Due: 12/03/2023
 * Platform/compiler: Intellij IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jacob Hauptman
*/import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SmoothieTestStudent {
    Smoothie s1, s2, s3, s4;

    @Before
    public void setUp() throws Exception {
        s1 = new Smoothie("Mango Smoothie", Size.SMALL, 1, true);
        s2 = new Smoothie("Strawberry Smoothie", Size.LARGE, 2, false);
        s3 = new Smoothie("Guava Smoothie", Size.MEDIUM, 5, true);
        s4 = new Smoothie("Mango Smoothie", Size.SMALL, 1, true);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getNumOfFruits() {
        assertEquals(1, s1.getNumOfFruits());
        assertEquals(2, s2.getNumOfFruits());
        assertEquals(5, s3.getNumOfFruits());
        assertEquals(1, s4.getNumOfFruits());
    }

    @Test
    public void getAddProtein() {
        assertTrue(s1.getAddProtein());
        assertFalse(s2.getAddProtein());
        assertTrue(s3.getAddProtein());
        assertTrue(s4.getAddProtein());
    }

    @Test
    public void testToString() {
        assertEquals("Mango Smoothie,SMALL,true,1,4.0", s1.toString());
        assertEquals("Strawberry Smoothie,LARGE,false,2,5.0",s2.toString());
        assertEquals("Guava Smoothie,MEDIUM,true,5,7.0",s3.toString());
        assertEquals("Mango Smoothie,SMALL,true,1,4.0", s4.toString());

    }

    @Test
    public void calcPrice() {
        assertEquals(4.0, s1.calcPrice(),.1);
        assertEquals(5.0, s2.calcPrice(),.1);
        assertEquals(7.0, s3.calcPrice(),.1);
        assertEquals(4.0, s4.calcPrice(),.1);
    }

    @Test
    public void testEquals() {
        assertTrue(s1.equals(s4));
        assertFalse(s1.equals(s3));
        assertFalse(s2.equals(s3));
    }
}