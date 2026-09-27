package by.bsu.entity.typesOfCarriages;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LuxuryCarriageTest {

    @Test
    public void testHasShower() {
        LuxuryCarriage lc = new LuxuryCarriage(1, 16, 0, 0, 0, true, false, false);
        assertTrue(lc.hasShower());

        LuxuryCarriage lc2 = new LuxuryCarriage(2, 16, 0, 0, 0, false, true, true);
        assertFalse(lc2.hasShower());
    }

    @Test
    public void testHasMiniBar() {
        LuxuryCarriage lc = new LuxuryCarriage(1, 16, 0, 0, 0, false, true, false);
        assertTrue(lc.hasMiniBar());

        LuxuryCarriage lc2 = new LuxuryCarriage(2, 16, 0, 0, 0, true, false, true);
        assertFalse(lc2.hasMiniBar());
    }

    @Test
    public void testHasTV() {
        LuxuryCarriage lc = new LuxuryCarriage(1, 16, 0, 0, 0, false, false, true);
        assertTrue(lc.hasTV());

        LuxuryCarriage lc2 = new LuxuryCarriage(2, 16, 0, 0, 0, true, true, false);
        assertFalse(lc2.hasTV());
    }

    @Test
    public void testSetHasShower() {
        LuxuryCarriage lc = new LuxuryCarriage(1, 16, 0, 0, 0, false, false, false);
        lc.setHasShower(true);
        assertTrue(lc.hasShower());

        lc.setHasShower(false);
        assertFalse(lc.hasShower());
    }

    @Test
    public void testSetHasMiniBar() {
        LuxuryCarriage lc = new LuxuryCarriage(1, 16, 0, 0, 0, false, false, false);
        lc.setHasMiniBar(true);
        assertTrue(lc.hasMiniBar());

        lc.setHasMiniBar(false);
        assertFalse(lc.hasMiniBar());
    }

    @Test
    public void testSetHasTV() {
        LuxuryCarriage lc = new LuxuryCarriage(1, 16, 0, 0, 0, false, false, false);
        lc.setHasTV(true);
        assertTrue(lc.hasTV());

        lc.setHasTV(false);
        assertFalse(lc.hasTV());
    }
}