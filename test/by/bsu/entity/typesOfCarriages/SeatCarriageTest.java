package by.bsu.entity.typesOfCarriages;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class SeatCarriageTest {

    @Test
    public void testGetNumberOfRowsOfSeats() {
        SeatCarriage sc = new SeatCarriage(1, 80, 0, 0, 0, 20, "мягкое", true);
        assertEquals(sc.getNumberOfRowsOfSeats(), 20);
    }

    @Test
    public void testGetSeatType() {
        SeatCarriage sc = new SeatCarriage(1, 80, 0, 0, 0, 20, "жёсткое", false);
        assertEquals(sc.getSeatType(), "жёсткое");
    }

    @Test
    public void testHasTable() {
        SeatCarriage sc = new SeatCarriage(1, 80, 0, 0, 0, 20, "мягкое", true);
        assertTrue(sc.hasTable());

        SeatCarriage sc2 = new SeatCarriage(2, 60, 0, 0, 0, 15, "мягкое", false);
        assertFalse(sc2.hasTable());
    }

    @Test
    public void testSetNumberOfRowsOfSeats() {
        SeatCarriage sc = new SeatCarriage(1, 80, 0, 0, 0, 10, "мягкое", true);
        sc.setNumberOfRowsOfSeats(25);
        assertEquals(sc.getNumberOfRowsOfSeats(), 25);
    }

    @Test
    public void testSetSeatType() {
        SeatCarriage sc = new SeatCarriage(1, 80, 0, 0, 0, 20, "мягкое", true);
        sc.setSeatType("жёсткое");
        assertEquals(sc.getSeatType(), "жёсткое");
    }

    @Test
    public void testSetHasTable() {
        SeatCarriage sc = new SeatCarriage(1, 80, 0, 0, 0, 20, "мягкое", false);
        sc.setHasTable(true);
        assertTrue(sc.hasTable());

        sc.setHasTable(false);
        assertFalse(sc.hasTable());
    }
}