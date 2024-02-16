/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Tests for the alcohol class
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

import static org.junit.Assert.*;

public class AlcoholTestStudent {
    private Alcohol a1, a2, a3, a4;

    @Before
    public void setUp() throws Exception {
        a1 = new Alcohol("Whiskey", Size.LARGE, true);
        a2 = new Alcohol("Rum", Size.SMALL, false);
        a3 = new Alcohol("Wine", Size.MEDIUM, true);
        a4 = new Alcohol("Whiskey", Size.LARGE, true);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calcPrice() {
        assertEquals(4.6, a1.calcPrice(), 0.1);
        assertEquals(2, a2.calcPrice(), .1);
        assertEquals(3.6, a3.calcPrice(), .1);
        assertEquals(4.6, a4.calcPrice(), 0.1);
    }

    @Test
    public void testEquals() {
      assertTrue(a1.equals(a4));
      assertFalse(a2.equals(a3));

    }

    @Test
    public void testToString() {
        assertEquals("Whiskey,LARGE,true,4.6", a1.toString());
        assertEquals("Rum,SMALL,false,2.0",a2.toString());
        assertEquals("Wine,MEDIUM,true,3.6",a3.toString());
        assertEquals("Whiskey,LARGE,true,4.6",a4.toString());
    }

    @Test
    public void isWeekend() {
        assertTrue(a1.isWeekend());
        assertFalse(a2.isWeekend());
        assertTrue(a3.isWeekend());
        assertTrue(a4.isWeekend());
    }
}