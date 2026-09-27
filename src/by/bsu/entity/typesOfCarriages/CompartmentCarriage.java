package by.bsu.entity.typesOfCarriages;

import by.bsu.entity.Carriage;
import by.bsu.util.CarriagePriority;

import java.util.Objects;

public class CompartmentCarriage extends Carriage {
    private int compartmentsCount;
    private boolean hasAirConditioning;

    public CompartmentCarriage(int number, int passengerCapacity, int currentPassengers,
                               double luggageWeight, double cargoCapacity,
                               int compartmentsCount, boolean hasAirConditioning) {
        super(number, passengerCapacity, currentPassengers, luggageWeight, cargoCapacity, 4);
        this.compartmentsCount = compartmentsCount;
        this.hasAirConditioning = hasAirConditioning;
    }

    public int getCompartmentsCount() { return compartmentsCount; }
    public boolean hasAirConditioning() { return hasAirConditioning; }

    public void setCompartmentsCount(int compartmentsCount) { this.compartmentsCount = compartmentsCount; }
    public void setHasAirConditioning(boolean hasAirConditioning) { this.hasAirConditioning = hasAirConditioning; }

    @Override
    public CarriagePriority getPriority() {
        return CarriagePriority.COMPARTMENT;
    }

    @Override
    public String toString() {
        return "CompartmentCarriage{" +
                "№" + getNumber() +
                ", пассажиры=" + getCurrentPassengers() + "/" + getPassengerCapacity() +
                " (свободно: " + getFreeSeats() + ")" +
                ", багаж=" + String.format("%.1f", getLuggageWeight()) + "kg" +
                ", купе=" + compartmentsCount +
                ", кондиционер=" + (hasAirConditioning ? "да" : "нет") +
                ", комфорт=" + getComfortLevel() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompartmentCarriage)) return false;
        if (!super.equals(o)) return false;
        CompartmentCarriage that = (CompartmentCarriage) o;
        return compartmentsCount == that.compartmentsCount &&
                hasAirConditioning == that.hasAirConditioning;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), compartmentsCount, hasAirConditioning);
    }
}