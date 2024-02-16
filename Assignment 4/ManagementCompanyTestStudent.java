import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagementCompanyTestStudent {
    Property prop, prop2;
    ManagementCompany co, co2;

    @BeforeEach
    void setUp() {
        co = new ManagementCompany("Scooby Doo", "23454435", 12);
        co2 = new ManagementCompany("asdasdasd", "0010101", 102);
    }

    @AfterEach
    void tearDown() {
        co = null;
    }

    @Test
    void testAddProperty() {
        prop = new Property("Yummerts", "Cheese Vil", 2103, "Shaggy", 1, 1, 2, 4);
        assertEquals(co.addProperty(prop), 0, 0);
        prop = new Property("Prummer", "Crystal Cove", 1089, "Velma", 5, 5, 1, 1);
        assertEquals(co.addProperty(prop), 1, 0);
        prop = new Property("UhOH", "Adams Town", 200, "Velma", 5, 5, 2, 4);
        assertEquals(co.addProperty(prop), -4, 0);
    }

    @Test
    void testRemoveLastProperty() {
        prop = new Property("Yummerts", "Cheese Vil", 2103, "Shaggy", 1, 1, 2, 4);
        co.addProperty(prop);
        prop = new Property("Prummer", "Crystal Cove", 1089, "Velma", 5, 5, 1, 1);
        co.addProperty(prop);
        //Above is same properties as addProperty test, just using it again
        assertEquals(2, co.getPropertiesCount());
        co.removeLastProperty();
        assertEquals(1, co.getPropertiesCount());
    }

    @Test
    void testIsPropertiesFull() {
        prop = new Property("Yummerts", "Cheese Vil", 2103, "Shaggy", 1, 1, 1, 1);
        co.addProperty(prop);
        assertFalse(co.isPropertiesFull());
        prop = new Property("Prummer", "Crystal Cove", 1089, "Velma", 3, 3, 1, 1);
        co.addProperty(prop);
        prop = new Property("Prummer", "Crystal Cove", 1089, "Velma", 5, 5, 1, 1);
        co.addProperty(prop);
        prop = new Property("Prummer", "Crystal Cove", 1089, "Velma", 1, 5, 1, 1);
        co.addProperty(prop);
        prop = new Property("Prummer", "Crystal Cove", 1089, "Velma", 5, 1, 1, 1);
        co.addProperty(prop);
        assertTrue(co.isPropertiesFull());
    }

    @Test
    void testGetPropertiesCount() {
        prop = new Property("Prummer", "Crystal Cove", 1089, "Velma", 1, 5, 1, 1);
        co.addProperty(prop);
        prop = new Property("Prummer", "Crystal Cove", 1089, "Velma", 5, 1, 1, 1);
        co.addProperty(prop);
        assertEquals(2, co.getPropertiesCount());
        prop = new Property("Prummer", "Crystal Cove", 1089, "Velma", 3, 3, 1, 1);
        co.addProperty(prop);
        prop = new Property("Prummer", "Crystal Cove", 1089, "Velma", 5, 5, 1, 1);
        co.addProperty(prop);
        prop = new Property("Prummer", "Crystal Cove", 1089, "Velma", 1, 5, 1, 1);
        co.addProperty(prop);
        prop = new Property("Prummer", "Crystal Cove", 1089, "Velma", 5, 1, 1, 1);
        co.addProperty(prop);
        assertEquals(4, co.getPropertiesCount());
    }

    @Test
    void testGetTotalRent() {
        prop = new Property("Prummer", "Crystal Cove", 1089, "Velma", 1, 5, 1, 1);
        co.addProperty(prop);
        prop = new Property("Prummer", "Crystal Cove", 1000, "Velma", 5, 1, 1, 1);
        co.addProperty(prop);
        assertEquals(2089, co.getTotalRent());
        prop = new Property("Prummer", "Crystal Cove", 1327, "Velma", 3, 3, 1, 1);
        co.addProperty(prop);
        prop = new Property("Prummer", "Crystal Cove", 2031, "Velma", 5, 5, 1, 1);
        co.addProperty(prop);
        assertEquals(5447, co.getTotalRent());
    }

    @Test
    void testGetHighestRentPropperty() {
        prop = new Property("Prummer", "Crystal Cove", 1327, "Velma", 3, 3, 1, 1);
        co.addProperty(prop);
        prop = new Property("Prummer", "Crystal Cove", 2031, "Velma", 5, 5, 1, 1);
        co.addProperty(prop);
        assertEquals(2031, co.getHighestRentPropperty().getRentAmount());
    }

    @Test
    void testIsManagementFeeValid() {
        assertTrue(co.isManagementFeeValid());
        assertFalse(co2.isManagementFeeValid());
    }

    @Test
    void testGetName() {
        assertEquals("Scooby Doo", co.getName());
        assertEquals("asdasdasd", co2.getName());
    }

    @Test
    void testGetTaxID() {
        assertEquals("23454435", co.getTaxID());
        assertEquals("0010101", co2.getTaxID());
    }

    @Test
    void testGetMgmFeePer() {
        assertEquals(12, co.getMgmFeePer());
        assertEquals(102, co2.getMgmFeePer());
    }
}