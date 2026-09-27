package by.bsu.entity.typesOfCarriages;

import by.bsu.entity.Carriage;
import by.bsu.util.CarriagePriority;

import java.util.Objects;

public class LuxuryCarriage extends Carriage {
    private boolean hasShower;
    private boolean hasMiniBar;
    private boolean hasTV;

    public LuxuryCarriage(int number, int passengerCapacity, int currentPassengers,
                          double luggageWeight, double cargoCapacity,
                          boolean hasShower, boolean hasMiniBar, boolean hasTV) {
        super(number, passengerCapacity, currentPassengers, luggageWeight, cargoCapacity, 10);
        this.hasShower = hasShower;
        this.hasMiniBar = hasMiniBar;
        this.hasTV = hasTV;
    }

    public boolean hasShower() { return hasShower; }
    public boolean hasMiniBar() { return hasMiniBar; }
    public boolean hasTV() { return hasTV; }

    public void setHasShower(boolean hasShower) { this.hasShower = hasShower; }
    public void setHasMiniBar(boolean hasMiniBar) { this.hasMiniBar = hasMiniBar; }
    public void setHasTV(boolean hasTV) { this.hasTV = hasTV; }

    @Override
    public CarriagePriority getPriority() {
        return CarriagePriority.LUXURY;

    }

    @Override
    public String toString() {
        return "LuxuryCarriage{" +
                "№" + getNumber() +
                ", пассажиры=" + getCurrentPassengers() + "/" + getPassengerCapacity() +
                " (свободно: " + getFreeSeats() + ")" +
                ", багаж=" + String.format("%.1f", getLuggageWeight()) + "kg" +
                ", душ=" + (hasShower ? "да" : "нет") +
                ", мини-бар=" + (hasMiniBar ? "да" : "нет") +
                ", TV=" + (hasTV ? "да" : "нет") +
                ", комфорт=" + getComfortLevel() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LuxuryCarriage)) return false;
        if (!super.equals(o)) return false;
        LuxuryCarriage that = (LuxuryCarriage) o;
        return hasShower == that.hasShower &&
                hasMiniBar == that.hasMiniBar &&
                hasTV == that.hasTV;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hasShower, hasMiniBar, hasTV);
    }
}