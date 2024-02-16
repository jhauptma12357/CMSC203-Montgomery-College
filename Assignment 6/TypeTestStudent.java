/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Tests the enum of the type of drinks
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

public class TypeTestStudent {
    private Type[] testTypes;
    @Before
    public void setUp() throws Exception {
        testTypes = new Type[]{Type.COFFEE, Type.SMOOTHIE, Type.ALCOHOL};
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void values() {
       assertArrayEquals(testTypes, Type.values());

    }

    @Test
    public void valueOf() {
        assertEquals("COFFEE", Type.COFFEE.name());
        assertEquals("SMOOTHIE", Type.SMOOTHIE.name());
        assertEquals("ALCOHOL", Type.ALCOHOL.name());
    }
}