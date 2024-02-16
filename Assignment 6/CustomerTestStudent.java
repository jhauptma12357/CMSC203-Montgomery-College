/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Tests for the customer class
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

public class CustomerTestStudent {
    private Customer c1, c2, c3;

    @Before
    public void setUp() throws Exception {
        c1 = new Customer("Jacob Hauptman", 18);
        c2 = new Customer("Lilis Wihardi", 54);
        c3 = new Customer("Marc Hauptman", 57);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAge() {
        assertEquals(18, c1.getAge());
        assertEquals(54, c2.getAge());
        assertEquals(57, c3.getAge());
    }

    @Test
    public void setAge() {
        c1.setAge(200);
        c2.setAge(999);
        c3.setAge(23);
        assertEquals(200, c1.getAge());
        assertEquals(999, c2.getAge());
        assertEquals(23,c3.getAge());
    }

    @Test
    public void getName() {
        assertEquals("Jacob Hauptman", c1.getName());
        assertEquals("Lilis Wihardi", c2.getName());
        assertEquals("Marc Hauptman", c3.getName());
    }

    @Test
    public void setName() {
        c1.setName("Scooby Doo");
        c2.setName("Shaggy Rogers");
        c3.setName("Velma Dinkley");
        assertEquals("Scooby Doo", c1.getName());
        assertEquals("Shaggy Rogers", c2.getName());
        assertEquals("Velma Dinkley", c3.getName());
    }

    @Test
    public void testToString() {
        assertEquals("Jacob Hauptman 18", c1.toString());
        assertEquals("Lilis Wihardi 54", c2.toString());
        assertEquals("Marc Hauptman 57", c3.toString());
    }
}