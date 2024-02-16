/*
 * Class: CMSC203 21575
 * Instructor: Grigoriy Grinberg
 * Description: Test TwoDImRaggedArrayUtility
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

public class TwoDimRaggedArrayUtilityTestStudent {
    private double[][] dataSet1 = {{1,2,3},{11,5},{6,7,8,9}};

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAverage() {
        assertEquals(5.777777777777778,TwoDimRaggedArrayUtility.getAverage(dataSet1),.01);
    }

    @Test
    public void getColumnTotal() {
        assertEquals(18,TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,0), 0);
        assertEquals(14, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,1), 0);
        assertEquals(11, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,2),0);
        assertEquals(9, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,3),0);
    }

    @Test
    public void getHighestInArray() {
        assertEquals(11, TwoDimRaggedArrayUtility.getHighestInArray(dataSet1),0);
    }

    @Test
    public void getHighestInColumn() {
        assertEquals(11.0,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1,0),0);
        assertEquals(7.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1,1),0);
        assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1,2),0);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1,3),0);
    }

    @Test
    public void getHighestInColumnIndex() {
        assertEquals(1,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1,0));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1,1));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1,2));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1,3));
    }

    @Test
    public void getHighestInRow() {
        assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1,0),0);
        assertEquals(11, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1,1),0);
        assertEquals(9, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1,2),0);
    }

    @Test
    public void getHighestInRowIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1,0));
        assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1,1));
        assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1,2));
    }

    @Test
    public void getLowestInArray() {
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInArray(dataSet1),0);
    }

    @Test
    public void getLowestInColumn() {
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1,0),0);
        assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1,1),0);
        assertEquals(3, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 2),0);
        assertEquals(9, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 3),0);
    }

    @Test
    public void getLowestInColumnIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1,0),0);
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1,1),0);
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 2),0);
        assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 3),0);

    }

    @Test
    public void getLowestInRow() {
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1,0),0);
        assertEquals(5, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1,1),0);
        assertEquals(6, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1,2),0);

    }

    @Test
    public void getLowestInRowIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1,0));
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1,1));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1,2));

    }

    @Test
    public void getRowTotal() {
        assertEquals(6, TwoDimRaggedArrayUtility.getRowTotal(dataSet1,0),0);
        assertEquals(16, TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1),0);
        assertEquals(30, TwoDimRaggedArrayUtility.getRowTotal(dataSet1,2),0);
    }

    @Test
    public void getTotal() {
        assertEquals(52,TwoDimRaggedArrayUtility.getTotal(dataSet1),0);
    }

}