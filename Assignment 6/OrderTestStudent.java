/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Tests for the order class
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

public class OrderTestStudent {
    private Order o1, o2;
    private Customer c1, c2;

    @Before
    public void setUp() throws Exception {
        c1 = new Customer("Scoobs",20);
        c2 = new Customer("Shaggy", 24);
        o1 = new Order(10, Day.MONDAY, c1);
        o2 = new Order(17, Day.WEDNESDAY, c2);
        o1.addNewBeverage("Mango Smoothie", Size.MEDIUM, 4, false);
        o1.addNewBeverage("Mocha", Size.SMALL, true, true);
        o2.addNewBeverage("Whiskey", Size.LARGE);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getOrderTime() {
        assertEquals(10, o1.getOrderTime());
        assertEquals(17, o2.getOrderTime());
    }

    @Test
    public void getOrderDay() {
        assertEquals(Day.MONDAY, o1.getOrderDay());
        assertEquals(Day.WEDNESDAY, o2.getOrderDay());
    }

    @Test
    public void getCustomer() {
        assertEquals(c1, o1.getCustomer());
        assertEquals(c2, o2.getCustomer());
    }

    @Test
    public void getDay() {
        assertEquals(Day.MONDAY,o1.getDay());
        assertEquals(Day.WEDNESDAY, o2.getDay());
    }

    @Test
    public void isWeekend() {
        assertFalse(o1.isWeekend());
        assertFalse(o2.isWeekend());
    }

    @Test
    public void getTotalItems() {
        assertEquals(2, o1.getTotalItems());
        assertEquals(1, o2.getTotalItems());

    }


    @Test
    public void calcOrderTotal() {
        assertEquals(8.0, o1.calcOrderTotal(), .1);
        assertEquals(4.0, o2.calcOrderTotal(), .1);
    }

    @Test
    public void findNumOfBeveType() {
        assertEquals(1, o1.findNumOfBeveType(Type.COFFEE));
        assertEquals(1, o1.findNumOfBeveType(Type.SMOOTHIE));
        assertEquals(0, o1.findNumOfBeveType(Type.ALCOHOL));
        assertEquals(1, o2.findNumOfBeveType(Type.ALCOHOL));
    }

}