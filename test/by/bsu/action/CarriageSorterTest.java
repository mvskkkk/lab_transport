package by.bsu.action;

import by.bsu.entity.Carriage;
import by.bsu.entity.PassengerTrain;
import by.bsu.entity.TypeOfFuel;
import by.bsu.entity.typesOfCarriages.*;
import by.bsu.util.CarriagePriority;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class CarriageSorterTest {

    @Test
    public void testSortByComfort_CorrectOrder() {
        PassengerTrain train = createTrain();
        new CarriageSorter().sortByComfort(train);

        List<Carriage> carriages = train.getCarriages();
        assertEquals(carriages.size(), 5);

        assertTrue(carriages.get(0) instanceof LuxuryCarriage);
        assertTrue(carriages.get(1) instanceof CompartmentCarriage);
        assertTrue(carriages.get(2) instanceof BerthCarriage);
        assertTrue(carriages.get(3) instanceof SeatCarriage);
        assertTrue(carriages.get(4) instanceof RestaurantCarriage);
    }

    @Test
    public void testSortByComfort_PriorityValues() {
        PassengerTrain train = createTrain();
        new CarriageSorter().sortByComfort(train);

        List<Carriage> carriages = train.getCarriages();

        int prevPriority = Integer.MAX_VALUE;
        for (Carriage c : carriages) {
            CarriagePriority priority = c.getPriority();
            int level = priority.getLevel();
            assertTrue(level <= prevPriority,
                    "Приоритет должен уменьшаться: " + prevPriority + " > " + level);
            prevPriority = level;
        }
    }

    @Test
    public void testSortByComfort_SeatSoftBeforeHard() {
        PassengerTrain train = new PassengerTrain("Test", 200, TypeOfFuel.ELECTRIC);

        SeatCarriage hard = new SeatCarriage(1, 60, 0, 1000, 1.0, 15, "жёсткое", false);
        SeatCarriage soft = new SeatCarriage(2, 60, 0, 1000, 1.0, 15, "мягкое", false);

        train.addCarriage(hard);
        train.addCarriage(soft);

        new CarriageSorter().sortByComfort(train);

        List<Carriage> carriages = train.getCarriages();
        assertEquals(carriages.size(), 2);
        assertNotEquals(carriages.get(0), soft);
        assertNotEquals(carriages.get(1), hard);
    }

    @Test
    public void testSortByComfort_EmptyTrain() {
        PassengerTrain train = new PassengerTrain("Empty", 100, TypeOfFuel.DIESEL);
        new CarriageSorter().sortByComfort(train);
        assertTrue(train.getCarriages().isEmpty());
    }

    @Test
    public void testSortByComfort_OneCarriage() {
        PassengerTrain train = new PassengerTrain("Single", 100, TypeOfFuel.ELECTRIC);
        LuxuryCarriage lux = new LuxuryCarriage(1, 18, 0, 600, 1.0, true, true, true);
        train.addCarriage(lux);

        new CarriageSorter().sortByComfort(train);
        assertEquals(train.getCarriages().size(), 1);
        assertEquals(train.getCarriages().get(0), lux);
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