package by.bsu.entity;

import by.bsu.entity.typesOfCarriages.*;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CarriageTest {

    @Test
    public void testValidCarriage() {
        SeatCarriage c = new SeatCarriage(1, 50, 30, 100.0, 500.0, 20, "мягкое", true);

        assertEquals(c.getNumber(), 1);
        assertEquals(c.getPassengerCapacity(), 50);
        assertEquals(c.getCurrentPassengers(), 30);
        assertEquals(c.getLuggageWeight(), 100.0, 0.01);
        assertEquals(c.getCargoCapacity(), 500.0, 0.01);
        assertNotEquals(c.getComfortLevel(), 3);
        assertEquals(c.getFreeSeats(), 20);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidNumber() {
        new SeatCarriage(0, 50, 0, 0, 0, 20, "мягкое", true); // number = 0
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidPassengerCapacity() {
        new SeatCarriage(1, -10, 0, 0, 0, 20, "мягкое", true);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidCurrentPassengers() {
        new SeatCarriage(1, 50, 60, 0, 0, 20, "мягкое", true); // больше capacity
    }
}