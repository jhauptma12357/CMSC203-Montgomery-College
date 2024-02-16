
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
    Gradebook gradeBook1, gradeBook2;

    @BeforeEach
    void setUp() throws Exception {
        gradeBook1 = new Gradebook(5);
        gradeBook2 = new Gradebook(3);
        gradeBook1.addScore(100);
        gradeBook1.addScore(65);
        gradeBook1.addScore(92);
        gradeBook1.addScore(50);
        gradeBook1.addScore(86);
        gradeBook2.addScore(100);
        gradeBook2.addScore(94);
        gradeBook2.addScore(90);
    }

    @AfterEach
    void tearDown() throws Exception {
        gradeBook1 = gradeBook2 = null;
    }

    @Test
    void testAddScore() {
        assertTrue(gradeBook1.toString().equals("100.0 65.0 92.0 50.0 86.0 "));
        assertTrue(gradeBook2.toString().equals("100.0 94.0 90.0 "));
    }

    @Test
    void testSum() {
        assertEquals(393, gradeBook1.sum());
        assertEquals(284, gradeBook2.sum());
    }

    @Test
    void testMinimum() {
        assertEquals(50, gradeBook1.minimum());
        assertEquals(90, gradeBook2.minimum());
    }

    @Test
    void testFinalScore() {
        assertEquals(343, gradeBook1.finalScore());
        assertEquals(194, gradeBook2.finalScore());
    }

    @Test
    void testGetScoreSize() {
        assertEquals(5, gradeBook1.getScoreSize());
        assertEquals(3, gradeBook2.getScoreSize());
    }
}
