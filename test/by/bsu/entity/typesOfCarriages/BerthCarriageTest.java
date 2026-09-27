package by.bsu.entity.typesOfCarriages;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class BerthCarriageTest {

    @Test
    public void testGetNumberOfBerths() {
        BerthCarriage bc = new BerthCarriage(1, 54, 0, 0, 0, 54, true, true);
        assertEquals(bc.getNumberOfBerths(), 54);
    }

    @Test
    public void testHasSideBerths() {
        BerthCarriage bc1 = new BerthCarriage(1, 54, 0, 0, 0, 54, true, false);
        BerthCarriage bc2 = new BerthCarriage(2, 54, 0, 0, 0, 54, false, true);

        assertTrue(bc1.hasSideBerths());
        assertFalse(bc2.hasSideBerths());
    }

    @Test
    public void testHasUpperBerths() {
        BerthCarriage bc1 = new BerthCarriage(1, 54, 0, 0, 0, 54, false, true);
        BerthCarriage bc2 = new BerthCarriage(2, 54, 0, 0, 0, 54, true, false);

        assertTrue(bc1.hasUpperBerths());
        assertFalse(bc2.hasUpperBerths());
    }

    @Test
    public void testSetNumberOfBerths() {
        BerthCarriage bc = new BerthCarriage(1, 54, 0, 0, 0, 36, true, true);
        bc.setNumberOfBerths(48);
        assertEquals(bc.getNumberOfBerths(), 48);
    }

    @Test
    public void testSetHasSideBerths() {
        BerthCarriage bc = new BerthCarriage(1, 54, 0, 0, 0, 54, false, true);
        bc.setHasSideBerths(true);
        assertTrue(bc.hasSideBerths());

        bc.setHasSideBerths(false);
        assertFalse(bc.hasSideBerths());
    }

    @Test
    public void testSetHasUpperBerths() {
        BerthCarriage bc = new BerthCarriage(1, 54, 0, 0, 0, 54, true, false);
        bc.setHasUpperBerths(true);
        assertTrue(bc.hasUpperBerths());

        bc.setHasUpperBerths(false);
        assertFalse(bc.hasUpperBerths());
    }
}