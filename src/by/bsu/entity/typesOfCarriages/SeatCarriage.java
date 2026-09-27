package by.bsu.entity.typesOfCarriages;

import by.bsu.entity.Carriage;
import by.bsu.util.CarriagePriority;

import java.util.Objects;

public class SeatCarriage extends Carriage {
    private int numberOfRowsOfSeats;
    private String seatType;
    private boolean hasTable;

    public SeatCarriage(int number, int passengerCapacity, int currentPassengers,
                        double luggageWeight, double cargoCapacity,
                        int numberOfRowsOfSeats, String seatType, boolean hasTable) {
        super(number, passengerCapacity, currentPassengers, luggageWeight, cargoCapacity,
                "мягкое".equalsIgnoreCase(seatType) ? 2 : 1);
        this.numberOfRowsOfSeats = numberOfRowsOfSeats;
        this.seatType = seatType;
        this.hasTable = hasTable;
    }

    public int getNumberOfRowsOfSeats() { return numberOfRowsOfSeats; }
    public String getSeatType() { return seatType; }
    public boolean hasTable() { return hasTable; }

    public void setNumberOfRowsOfSeats(int numberOfRowsOfSeats) { this.numberOfRowsOfSeats = numberOfRowsOfSeats; }
    public void setSeatType(String seatType) { this.seatType = seatType; }
    public void setHasTable(boolean hasTable) { this.hasTable = hasTable; }

    @Override
    public CarriagePriority getPriority() {
        return CarriagePriority.SEAT;
    }

    @Override
    public String toString() {
        return "SeatCarriage{" +
                "№" + getNumber() +
                ", пассажиры=" + getCurrentPassengers() + "/" + getPassengerCapacity() +
                " (свободно: " + getFreeSeats() + ")" +
                ", багаж=" + String.format("%.1f", getLuggageWeight()) + "kg" +
                ", рядов=" + numberOfRowsOfSeats +
                ", тип=" + seatType +
                ", стол=" + (hasTable ? "да" : "нет") +
                ", комфорт=" + getComfortLevel() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeatCarriage)) return false;
        if (!super.equals(o)) return false;
        SeatCarriage that = (SeatCarriage) o;
        return numberOfRowsOfSeats == that.numberOfRowsOfSeats &&
                hasTable == that.hasTable &&
                Objects.equals(seatType, that.seatType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfRowsOfSeats, seatType, hasTable);
    }
}