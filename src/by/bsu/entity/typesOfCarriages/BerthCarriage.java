package by.bsu.entity.typesOfCarriages;

import by.bsu.entity.Carriage;
import by.bsu.util.CarriagePriority;

import java.util.Objects;

public class BerthCarriage extends Carriage {
    private int numberOfBerths;
    private boolean hasSideBerths;
    private boolean hasUpperBerths;

    public BerthCarriage(int number, int passengerCapacity, int currentPassengers,
                         double luggageWeight, double cargoCapacity,
                         int numberOfBerths, boolean hasSideBerths, boolean hasUpperBerths) {
        super(number, passengerCapacity, currentPassengers, luggageWeight, cargoCapacity, 3);
        this.numberOfBerths = numberOfBerths;
        this.hasSideBerths = hasSideBerths;
        this.hasUpperBerths = hasUpperBerths;
    }

    public int getNumberOfBerths() { return numberOfBerths; }
    public boolean hasSideBerths() { return hasSideBerths; }
    public boolean hasUpperBerths() { return hasUpperBerths; }

    public void setNumberOfBerths(int numberOfBerths) { this.numberOfBerths = numberOfBerths; }
    public void setHasSideBerths(boolean hasSideBerths) { this.hasSideBerths = hasSideBerths; }
    public void setHasUpperBerths(boolean hasUpperBerths) { this.hasUpperBerths = hasUpperBerths; }

    @Override
    public CarriagePriority getPriority() {
        return CarriagePriority.BERTH;
    }

    @Override
    public String toString() {
        return "BerthCarriage{" +
                "№" + getNumber() +
                ", пассажиры=" + getCurrentPassengers() + "/" + getPassengerCapacity() +
                " (свободно: " + getFreeSeats() + ")" +
                ", багаж=" + String.format("%.1f", getLuggageWeight()) + "kg" +
                ", полок=" + numberOfBerths +
                ", боковые=" + (hasSideBerths ? "да" : "нет") +
                ", верхние=" + (hasUpperBerths ? "да" : "нет") +
                ", комфорт=" + getComfortLevel() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BerthCarriage)) return false;
        if (!super.equals(o)) return false;
        BerthCarriage that = (BerthCarriage) o;
        return numberOfBerths == that.numberOfBerths &&
                hasSideBerths == that.hasSideBerths &&
                hasUpperBerths == that.hasUpperBerths;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfBerths, hasSideBerths, hasUpperBerths);
    }
}