package by.bsu.action;

import by.bsu.entity.Carriage;
import by.bsu.entity.PassengerTrain;
import by.bsu.entity.TypeOfFuel;
import by.bsu.entity.typesOfCarriages.*;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class CarriageFinderTest {

    @Test
    public void testFindByPassengerRange_EmptyRange() {
        PassengerTrain train = createTrain();
        List<Carriage> result = CarriageFinder.findByPassengerRange(train, 90, 100);
        assertTrue(result.isEmpty(), "Нет вагонов с 90+ пассажирами");
    }

    @Test
    public void testFindByPassengerRange_OneMatch() {
        PassengerTrain train = createTrain();
        List<Carriage> result = CarriageFinder.findByPassengerRange(train, 70, 80);
        assertEquals(result.size(), 1);
        Carriage c = result.get(0);
        assertEquals(c.getCurrentPassengers(), 75);
        assertTrue(c instanceof SeatCarriage);
    }

    @Test
    public void testFindByPassengerRange_MultipleMatches() {
        PassengerTrain train = createTrain();
        List<Carriage> result = CarriageFinder.findByPassengerRange(train, 30, 60);
        assertEquals(result.size(), 2);
        assertTrue(result.stream().anyMatch(c -> c.getCurrentPassengers() == 36));
        assertTrue(result.stream().anyMatch(c -> c.getCurrentPassengers() == 50));
    }

    @Test
    public void testFindByPassengerRange_AllMatches() {
        PassengerTrain train = createTrain();
        List<Carriage> result = CarriageFinder.findByPassengerRange(train, 0, 100);
        assertNotEquals(result.size(), 4); // все, кроме ресторана
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFindByPassengerRange_NullTrain() {
        CarriageFinder.findByPassengerRange(null, 10, 20);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFindByPassengerRange_MinGreaterThanMax() {
        PassengerTrain train = createTrain();
        CarriageFinder.findByPassengerRange(train, 50, 30);
    }

    private PassengerTrain createTrain() {
        PassengerTrain train = new PassengerTrain("Тестовый", 200, TypeOfFuel.ELECTRIC);

        SeatCarriage seat = new SeatCarriage(1, 81, 0, 1400.0, 2.0, 20, "мягкое", true);
        seat.setCurrentPassengers(75);

        CompartmentCarriage comp = new CompartmentCarriage(2, 36, 0, 850.0, 1.5, 9, true);
        comp.setCurrentPassengers(36);

        BerthCarriage berth = new BerthCarriage(3, 54, 0, 1100.0, 1.8, 54, true, true);
        berth.setCurrentPassengers(50);

        LuxuryCarriage luxury = new LuxuryCarriage(4, 18, 0, 600.0, 1.0, true, true, true);
        luxury.setCurrentPassengers(16);

        RestaurantCarriage restaurant = new RestaurantCarriage(5, 0, 0, 0.0, 3.0, 12, true);

        train.addCarriage(seat);
        train.addCarriage(comp);
        train.addCarriage(berth);
        train.addCarriage(luxury);
        train.addCarriage(restaurant);

        return train;
    }
}