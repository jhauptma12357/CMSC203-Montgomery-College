import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlotTestStudent {
    private Plot plot1, plot2, plot3,plot4;
    @BeforeEach
    void setUp() {
        plot1 = new Plot(1, 1, 1, 1);
        plot2 = new Plot(3, 4, 4, 3);
        plot3 = new Plot(2,2,2,2);
        plot4 = new Plot(1, 1, 4,4);
    }

    @AfterEach
    void tearDown() {
        plot1 = plot2 = null;
    }

    @Test
    void testGetDepth() {
        assertEquals(1, plot1.getDepth());
        assertEquals(3,plot2.getDepth());
    }

    @Test
    void testGetWidth() {
        assertEquals(1, plot1.getWidth());
        assertEquals(4, plot2.getWidth());
    }

    @Test
    void testGetX() {
        assertEquals(1, plot1.getX());
        assertEquals(3,plot2.getX());
    }

    @Test
    void testGetY() {
        assertEquals(1, plot1.getY());
        assertEquals(4,plot2.getY());
    }

    @Test
    void testOverlaps() {
        assertFalse(plot1.overlaps(plot2));
        assertTrue(plot2.overlaps(plot3));
    }

    @Test
    void testEncompasses() {
        assertFalse(plot1.encompasses(plot2));
        assertTrue(plot4.encompasses(plot3));
    }
}