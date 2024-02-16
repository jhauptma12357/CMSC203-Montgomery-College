/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Tests for the Days enum
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

public class DayTestStudent {
    private Day[] testDays;
    @Before
    public void setUp() throws Exception {
        testDays = new Day[]{Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY, Day.SATURDAY, Day.SUNDAY};
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void values(){
      assertArrayEquals(testDays, Day.values());
    }
    @Test
    public void valueOf() {
        assertEquals("MONDAY", Day.MONDAY.name());
        assertEquals("TUESDAY", Day.TUESDAY.name());
        assertEquals("WEDNESDAY", Day.WEDNESDAY.name());
        assertEquals("THURSDAY", Day.THURSDAY.name());
        assertEquals("FRIDAY", Day.FRIDAY.name());
        assertEquals("SATURDAY", Day.SATURDAY.name());
        assertEquals("SUNDAY", Day.SUNDAY.name());
    }
}