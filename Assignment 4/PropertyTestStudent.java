import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTestStudent {
    Property property, property2;

    @BeforeEach
    void setUp() {
        property = new Property("YMCA", "Towson", 2150.00, "Jacob");
        property2 = new Property("Cheesey", "Timonium", 2999.00, "David");
    }

    @AfterEach
    void tearDown() {
        property = property2 = null;
    }

    @Test
    void testGetPropertyName() {
        assertEquals("YMCA", property.getPropertyName());
        assertEquals("Cheesey", property2.getPropertyName());
    }

    @Test
    void testGetCity() {
        assertEquals("Towson", property.getCity());
        assertEquals("Timonium", property2.getCity());
    }

    @Test
    void testGetRentAmount() {
        assertEquals(2150.00, property.getRentAmount());
        assertEquals(2999.00, property2.getRentAmount());
    }

    @Test
    void testGetOwner() {
        assertEquals("Jacob", property.getOwner());
        assertEquals("David", property2.getOwner());
    }
}