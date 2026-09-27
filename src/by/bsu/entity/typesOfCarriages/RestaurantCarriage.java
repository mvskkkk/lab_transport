package by.bsu.entity.typesOfCarriages;

import by.bsu.entity.Carriage;
import by.bsu.util.CarriagePriority;

import java.util.Objects;

public class RestaurantCarriage extends Carriage {
    private int numberOfTables;
    private boolean hasKitchen;

    public RestaurantCarriage(int number, int passengerCapacity, int currentPassengers,
                              double luggageWeight, double cargoCapacity,
                              int numberOfTables, boolean hasKitchen) {
        super(number, passengerCapacity, currentPassengers, luggageWeight, cargoCapacity, 5);
        this.numberOfTables = numberOfTables;
        this.hasKitchen = hasKitchen;
    }

    public int getNumberOfTables() { return numberOfTables; }
    public boolean hasKitchen() { return hasKitchen; }

    public void setNumberOfTables(int numberOfTables) { this.numberOfTables = numberOfTables; }
    public void setHasKitchen(boolean hasKitchen) { this.hasKitchen = hasKitchen; }

    @Override
    public CarriagePriority getPriority() {
        return CarriagePriority.RESTAURANT;
    }

    @Override
    public String toString() {
        return "RestaurantCarriage{" +
                "№" + getNumber() +
                ", пассажиры=" + getCurrentPassengers() + "/" + getPassengerCapacity() +
                " (свободно: " + getFreeSeats() + ")" +
                ", багаж=" + String.format("%.1f", getLuggageWeight()) + "kg" +
                ", столиков=" + numberOfTables +
                ", кухня=" + (hasKitchen ? "да" : "нет") +
                ", комфорт=" + getComfortLevel() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RestaurantCarriage)) return false;
        if (!super.equals(o)) return false;
        RestaurantCarriage that = (RestaurantCarriage) o;
        return numberOfTables == that.numberOfTables &&
                hasKitchen == that.hasKitchen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfTables, hasKitchen);
    }
}