package by.bsu.entity.typesOfCarriages;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CompartmentCarriageTest {

    @Test
    public void testGetCompartmentsCount() {
        CompartmentCarriage cc = new CompartmentCarriage(1, 36, 0, 0, 0, 9, true);
        assertEquals(cc.getCompartmentsCount(), 9);
    }

    @Test
    public void testHasAirConditioning() {
        CompartmentCarriage cc1 = new CompartmentCarriage(1, 36, 0, 0, 0, 9, true);
        CompartmentCarriage cc2 = new CompartmentCarriage(2, 36, 0, 0, 0, 9, false);

        assertTrue(cc1.hasAirConditioning());
        assertFalse(cc2.hasAirConditioning());
    }

    @Test
    public void testSetCompartmentsCount() {
        CompartmentCarriage cc = new CompartmentCarriage(1, 36, 0, 0, 0, 6, true);
        cc.setCompartmentsCount(12);
        assertEquals(cc.getCompartmentsCount(), 12);
    }

    @Test
    public void testSetHasAirConditioning() {
        CompartmentCarriage cc = new CompartmentCarriage(1, 36, 0, 0, 0, 9, false);
        cc.setHasAirConditioning(true);
        assertTrue(cc.hasAirConditioning());

        cc.setHasAirConditioning(false);
        assertFalse(cc.hasAirConditioning());
    }
}