package by.bsu.entity;

import by.bsu.entity.typesOfCarriages.*;
import by.bsu.entity.TypeOfFuel;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PassengerTrainTest {

    @Test
    public void testAddCarriageAndGetCarriages() {
        PassengerTrain train = new PassengerTrain("Сапсан", 250, TypeOfFuel.ELECTRIC);
        SeatCarriage sc = new SeatCarriage(1, 80, 75, 1000.0, 0, 20, "мягкое", true);

        train.addCarriage(sc);

        assertEquals(train.getCarriages().size(), 1);
        assertEquals(train.getCarriages().get(0), sc);
    }

    @Test
    public void testGetTotalPassengers() {
        PassengerTrain train = new PassengerTrain("Прик", 190.0, TypeOfFuel.DIESEL);
        train.addCarriage(new SeatCarriage(1, 80, 70, 0, 0, 20, "мягкое", true));
        train.addCarriage(new SeatCarriage(2, 60, 50, 0, 0, 15, "жёсткое", false));

        assertEquals(train.getTotalPassengers(), 120); // 70 + 50
    }

    @Test
    public void testGetTotalCapacity() {
        PassengerTrain train = new PassengerTrain("Первый", 200.0, TypeOfFuel.ELECTRIC);
        train.addCarriage(new SeatCarriage(1, 80, 0, 0, 0, 20, "мягкое", true));
        train.addCarriage(new LuxuryCarriage(2, 16, 0, 0, 0, true, true, true));

        assertEquals(train.getTotalCapacity(), 96); // 80 + 16
    }

    @Test
    public void testGetTotalFreeSeats() {
        PassengerTrain train = new PassengerTrain("Тест", 100.0, TypeOfFuel.DIESEL);
        train.addCarriage(new SeatCarriage(1, 80, 70, 0, 0, 20, "мягкое", true));
        train.addCarriage(new CompartmentCarriage(2, 36, 30, 0, 0, 9, true));

        assertEquals(train.getTotalFreeSeats(), 16); // (80-70) + (36-30)
    }

    @Test
    public void testGetTotalLuggageWeight() {
        PassengerTrain train = new PassengerTrain("Тест", 100.0, TypeOfFuel.ELECTRIC);
        train.addCarriage(new SeatCarriage(1, 80, 0, 1000.0, 0, 20, "мягкое", true));
        train.addCarriage(new LuxuryCarriage(2, 16, 0, 500.0, 0, true, true, true));

        assertEquals(train.getTotalLuggageWeight(), 1500.0, 0.01);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddCarriageNull() {
        PassengerTrain train = new PassengerTrain("Тест", 300.0, TypeOfFuel.ELECTRIC);
        train.addCarriage(null);
    }

    @Test
    public void testToString() {
        PassengerTrain train = new PassengerTrain("Сапсан", 250.0, TypeOfFuel.ELECTRIC);
        train.addCarriage(new SeatCarriage(1, 80, 75, 1000.0, 0, 20, "мягкое", true));

        String result = train.toString();
        assertTrue(result.contains("Сапсан"));
        assertTrue(result.contains("вагонов=1"));
        assertTrue(result.contains("пассажиров=75/80"));
        assertFalse(result.contains("багаж=1000.0kg"));
    }
}