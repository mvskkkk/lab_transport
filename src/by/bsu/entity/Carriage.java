package by.bsu.entity;

import by.bsu.util.CarriagePriority;

import java.io.Serializable;
import java.util.Objects;

public abstract class Carriage implements Serializable {

    private static final long serialVersionUID = 1L;

    protected int numberOfCarriage;
    protected int passengerCapacity;
    protected int currentPassengers = 0;
    protected double luggageWeight;
    protected double cargoCapacity;
    protected int comfortLevel;

    public Carriage(int number, int passengerCapacity, int currentPassengers,
                    double luggageWeight, double cargoCapacity, int comfortLevel) {
        if (number <= 0) {
            throw new IllegalArgumentException("Номер вагона должен быть > 0");
        }
        if (passengerCapacity < 0) {
            throw new IllegalArgumentException("Вместимость не может быть отрицательной");
        }
        if (currentPassengers < 0 || currentPassengers > passengerCapacity) {
            throw new IllegalArgumentException("Неверное число пассажиров: " + currentPassengers);
        }
        if (luggageWeight < 0) {
            throw new IllegalArgumentException("Вес багажа не может быть отрицательным");
        }
        if (cargoCapacity < 0) {
            throw new IllegalArgumentException("Грузоподъёмность не может быть отрицательной");
        }
        if (comfortLevel < 1 || comfortLevel > 10) {
            throw new IllegalArgumentException("Уровень комфорта: 1–10");
        }

        this.numberOfCarriage = number;
        this.passengerCapacity = passengerCapacity;
        this.currentPassengers = currentPassengers;
        this.luggageWeight = luggageWeight;
        this.cargoCapacity = cargoCapacity;
        this.comfortLevel = comfortLevel;
    }

    public int getNumber() { return numberOfCarriage; }
    public int getPassengerCapacity() { return passengerCapacity; }
    public int getCurrentPassengers() { return currentPassengers; }
    public double getLuggageWeight() { return luggageWeight; }
    public double getCargoCapacity() { return cargoCapacity; }

    public int getComfortLevel() { return comfortLevel; }

    public void setCurrentPassengers(int currentPassengers) {
        if (currentPassengers < 0 || currentPassengers > passengerCapacity) {
            throw new IllegalArgumentException("Неверное число пассажиров");
        }
        this.currentPassengers = currentPassengers;
    }

    public void setLuggageWeight(double luggageWeight) {
        if (luggageWeight < 0) {
            throw new IllegalArgumentException("Вес багажа не может быть отрицательным");
        }
        this.luggageWeight = luggageWeight;
    }


    public int getFreeSeats(){
        return passengerCapacity - currentPassengers;
    }

    public abstract CarriagePriority getPriority();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "№" + numberOfCarriage +
                ", пассажиры=" + currentPassengers + "/" + passengerCapacity +
                ", багаж=" + String.format("%.1f", luggageWeight) + "kg" +
                ", груз=" + String.format("%.1f", cargoCapacity) + "т" +
                ", комфорт=" + comfortLevel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carriage)) return false;
        Carriage that = (Carriage) o;
        return numberOfCarriage == that.numberOfCarriage &&
                passengerCapacity == that.passengerCapacity &&
                currentPassengers == that.currentPassengers &&
                Double.compare(luggageWeight, that.luggageWeight) == 0 &&
                Double.compare(cargoCapacity, that.cargoCapacity) == 0 &&
                comfortLevel == that.comfortLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfCarriage, passengerCapacity, currentPassengers,
                luggageWeight, cargoCapacity, comfortLevel);
    }
}