/*
 * Class: CMSC203 21575
 * Instructor: Grigoriy Grinberg
 * Description: Test HolidayBonus
 * Due: 11/13/2023
 * Platform/compiler: IntelliJ IDEA
 * I pledge that I have completed the programming assignment independently.
 *  I have not copied the code from a student or any source.
 *  I have not given my code to any student.
 *  Print your Name here: Jacob Hauptman
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HolidayBonusTestSudent {
    private double[][] dataSet1 = { { 6, 22, 3 , 9, 10}, { 4, 5 }, { 1, 2, 9, 3, 5 } };
    private double[][] dataSet2 = { {100,23,40,2}, {23,1,2,3,9,8,10}, {101}, {2, 0}};
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calculateHolidayBonus() {
        try {
            double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
            assertEquals(25000, result[0], .001);
            assertEquals(4000, result[1], .001);
            assertEquals(5000, result[2], .001);
            double[] result2 = HolidayBonus.calculateHolidayBonus(dataSet2);
            assertEquals(8000, result2[0], .001);
            assertEquals(14000, result2[1], .001);
            assertEquals(5000, result2[2], .001);
            assertEquals(2000, result2[3], .001);
        } catch (Exception e) {
            fail("This should not have caused an Exception");
        }
    }

    @Test
    public void calculateTotalHolidayBonus() {
        assertEquals(34000, HolidayBonus.calculateTotalHolidayBonus(dataSet1), .001);
        assertEquals(29000, HolidayBonus.calculateTotalHolidayBonus(dataSet2), .001);
    }
}