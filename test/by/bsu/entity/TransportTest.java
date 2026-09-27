package by.bsu.entity;

import by.bsu.entity.typesOfCarriages.*;
import by.bsu.entity.TypeOfFuel;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TransportTest {

    @Test
    public void testAddCarriage() {
        PassengerTrain train = new PassengerTrain("Сапсан", 250.0, TypeOfFuel.ELECTRIC);
        SeatCarriage carriage = new SeatCarriage(1, 80, 70, 1000.0, 0, 20, "мягкое", true);

        train.addCarriage(carriage);

        assertEquals(train.getCarriages().size(), 1);
        assertEquals(train.getCarriages().get(0), carriage);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddCarriage_Null() {
        PassengerTrain train = new PassengerTrain("Ласточка", 200.0, TypeOfFuel.DIESEL);
        train.addCarriage(null); // ДОЛЖНО БРОСИТЬ!
    }

    @Test
    public void testGetTotalPassengers() {
        PassengerTrain train = new PassengerTrain("Тест", 100.0, TypeOfFuel.ELECTRIC);
        train.addCarriage(new SeatCarriage(1, 80, 70, 0, 0, 20, "мягкое", true));
        train.addCarriage(new SeatCarriage(2, 60, 50, 0, 0, 15, "жёсткое", false));

        assertEquals(train.getTotalPassengers(), 120); // 70 + 50
    }

    @Test
    public void testGetTotalCapacity() {
        PassengerTrain train = new PassengerTrain("Тест", 100.0, TypeOfFuel.DIESEL);
        train.addCarriage(new SeatCarriage(1, 80, 0, 0, 0, 20, "мягкое", true));
        train.addCarriage(new LuxuryCarriage(2, 16, 0, 0, 0, true, true, true));

        assertEquals(train.getTotalCapacity(), 96); // 80 + 16
    }

    @Test
    public void testGetTotalFreeSeats() {
        PassengerTrain train = new PassengerTrain("Тест", 100.0, TypeOfFuel.ELECTRIC);
        train.addCarriage(new SeatCarriage(1, 80, 70, 0, 0, 20, "мягкое", true));
        train.addCarriage(new CompartmentCarriage(2, 36, 30, 0, 0, 9, true));

        assertEquals(train.getTotalFreeSeats(), 16); // (80-70) + (36-30)
    }

    @Test
    public void testGetTotalLuggageWeight() {
        PassengerTrain train = new PassengerTrain("Тест", 100.0, TypeOfFuel.DIESEL);
        train.addCarriage(new SeatCarriage(1, 80, 0, 1000.0, 0, 20, "мягкое", true));
        train.addCarriage(new LuxuryCarriage(2, 16, 0, 500.0, 0, true, true, true));

        assertEquals(train.getTotalLuggageWeight(), 1500.0, 0.01);
    }

}