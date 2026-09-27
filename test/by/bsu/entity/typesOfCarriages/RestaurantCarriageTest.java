package by.bsu.entity.typesOfCarriages;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class RestaurantCarriageTest {

    @Test
    public void testGetNumberOfTables() {
        RestaurantCarriage rc = new RestaurantCarriage(1, 40, 0, 0, 0, 12, true);
        assertEquals(rc.getNumberOfTables(), 12);
    }

    @Test
    public void testHasKitchen() {
        RestaurantCarriage rc1 = new RestaurantCarriage(1, 40, 0, 0, 0, 10, true);
        RestaurantCarriage rc2 = new RestaurantCarriage(2, 30, 0, 0, 0, 8, false);

        assertTrue(rc1.hasKitchen());
        assertFalse(rc2.hasKitchen());
    }

    @Test
    public void testSetNumberOfTables() {
        RestaurantCarriage rc = new RestaurantCarriage(1, 40, 0, 0, 0, 5, true);
        rc.setNumberOfTables(15);
        assertEquals(rc.getNumberOfTables(), 15);
    }

    @Test
    public void testSetHasKitchen() {
        RestaurantCarriage rc = new RestaurantCarriage(1, 40, 0, 0, 0, 10, false);
        rc.setHasKitchen(true);
        assertTrue(rc.hasKitchen());

        rc.setHasKitchen(false);
        assertFalse(rc.hasKitchen());
    }
}