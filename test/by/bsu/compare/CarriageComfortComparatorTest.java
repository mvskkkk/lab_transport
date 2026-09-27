package by.bsu.compare;

import by.bsu.entity.Carriage;
import by.bsu.entity.typesOfCarriages.*;
import org.testng.annotations.Test;

import java.util.Comparator;

import static org.testng.Assert.*;

public class CarriageComfortComparatorTest {

    private final Comparator<Carriage> comparator = new CarriageComfortComparator();

    @Test
    public void testCompare_EqualComfort() {
        SeatCarriage c1 = new SeatCarriage(1, 80, 70, 100.0, 0, 20, "мягкое", true);
        SeatCarriage c2 = new SeatCarriage(2, 60, 50, 200.0, 0, 15, "мягкое", true);

        // Предположим, getComfortLevel() = 3 для обоих
        assertEquals(comparator.compare(c1, c2), 0);
    }

    @Test
    public void testCompare_FirstHigher() {
        LuxuryCarriage luxury = new LuxuryCarriage(1, 16, 14, 500.0, 0, true, true, true);
        SeatCarriage seat = new SeatCarriage(2, 80, 70, 100.0, 0, 20, "мягкое", true);

        // Luxury > Seat → negative
        assertTrue(comparator.compare(luxury, seat) < 0);
        assertTrue(comparator.compare(seat, luxury) > 0);
    }

    @Test
    public void testCompare_DifferentTypes() {
        CompartmentCarriage comp = new CompartmentCarriage(1, 36, 32, 400.0, 0, 9, true);
        BerthCarriage berth = new BerthCarriage(2, 54, 50, 300.0, 0, 27, true, true);

        // Compartment > Berth → negative
        assertTrue(comparator.compare(comp, berth) < 0);
        assertTrue(comparator.compare(berth, comp) > 0);
    }

    @Test
    public void testCompare_RestaurantLowest() {
        RestaurantCarriage restaurant = new RestaurantCarriage(1, 0, 0, 0.0, 1000.0, 2, true);
        SeatCarriage seat = new SeatCarriage(2, 80, 70, 100.0, 0, 20, "жёсткое", false);

        // Restaurant < Seat → positive
        assertTrue(comparator.compare(restaurant, seat) > 0);
        assertTrue(comparator.compare(seat, restaurant) < 0);
    }

    @Test
    public void testCompare_SameObject() {
        SeatCarriage carriage = new SeatCarriage(1, 80, 70, 100.0, 0, 20, "мягкое", true);
        assertEquals(comparator.compare(carriage, carriage), 0);
    }
}