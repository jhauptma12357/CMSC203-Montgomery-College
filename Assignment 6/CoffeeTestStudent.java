/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Tests the coffee class
 * Due: 12/03/2023
 * Platform/compiler: Intellij IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jacob Hauptman
*/
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ConcurrentLinkedQueue;

import static org.junit.Assert.*;

public class CoffeeTestStudent {
    private Coffee c1, c2, c3, c4, c5;

    @Before
    public void setUp() throws Exception {
        c1 = new Coffee("Mocha", Size.MEDIUM,true, true);
        c2 = new Coffee("Americano", Size.LARGE, false, false);
        c3 = new Coffee("Ice Coffee", Size.SMALL, true, false);
        c4 = new Coffee("Cappuccino", Size.LARGE, false, true);
        c5 = new Coffee("Mocha", Size.MEDIUM,true, true);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getExtraShot() {
        assertTrue(c1.getExtraShot());
        assertFalse(c2.getExtraShot());
        assertTrue(c3.getExtraShot());
        assertFalse(c4.getExtraShot());
        assertTrue(c5.getExtraShot());
    }

    @Test
    public void getExtraSyrup() {
        assertTrue(c1.getExtraSyrup());
        assertFalse(c2.getExtraSyrup());
        assertFalse(c3.getExtraSyrup());
        assertTrue(c4.getExtraSyrup());
        assertTrue(c5.getExtraSyrup());
    }

    @Test
    public void calcPrice() {
        assertEquals(4.0, c1.calcPrice(), .1);
        assertEquals(4.0, c2.calcPrice(), .1);
        assertEquals(2.5, c3.calcPrice(), .1);
        assertEquals(4.5, c4.calcPrice(), .1);
        assertEquals(4.0, c5.calcPrice(), .1);

    }

    @Test
    public void testToString() {
        assertEquals("Mocha,MEDIUM,true,true,4.0", c1.toString());
        assertEquals("Americano,LARGE,false,false,4.0", c2.toString());
        assertEquals("Ice Coffee,SMALL,true,false,2.5", c3.toString());
        assertEquals("Cappuccino,LARGE,false,true,4.5", c4.toString());
        assertEquals("Mocha,MEDIUM,true,true,4.0", c5.toString());
    }

    @Test
    public void testEquals() {
        assertTrue(c1.equals(c5));
        assertFalse(c1.equals(c2));
        assertFalse(c3.equals(c4));
    }
}