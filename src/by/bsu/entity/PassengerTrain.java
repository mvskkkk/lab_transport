package by.bsu.entity;

import java.util.ArrayList;
import java.util.List;

public class PassengerTrain extends RailwayTransport {
    private Carriage carriage;
    private final List<Carriage> carriages = new ArrayList<>();

    public PassengerTrain(String type, double speed, TypeOfFuel typeOfFuel) {
        super(type, speed, typeOfFuel);
    }

    public PassengerTrain(String type, double speed, TypeOfFuel typeOfFuel, int numberOfCarriages, Carriage carriage) {
        super(type, speed, typeOfFuel, numberOfCarriages);
        this.carriage = carriage;
    }

    public Carriage getCarriage() {
        return carriage;
    }

    public List<Carriage> getCarriages() {
        return new ArrayList<>(carriages);
    }

    public void setCarriages(List<Carriage> carriages) {
        if (carriages == null) {
            throw new IllegalArgumentException("Список вагонов не может быть null");
        }
        this.carriages.clear();
        this.carriages.addAll(carriages);
    }

    public int getNumberOfPassengers() {
        return carriage.getCurrentPassengers();
    }

    public int getMaxCapacity() {
        return carriage.getPassengerCapacity();
    }

    public void addCarriage(Carriage carriage) {
        if (carriage == null) {
            throw new IllegalArgumentException("Вагон не может быть null");
        }
        carriages.add(carriage);
    }


    public double getLuggageWeightAll() {
        return carriages.stream()
                .mapToDouble(Carriage::getLuggageWeight)
                .sum();
    }

    public int getTotalPassengers(){
        int total = 0;
        for(Carriage carriage : carriages){
            total+=carriage.getCurrentPassengers();
        }
        return total;
    }

    public int getTotalCapacity(){
        int total = 0;
        for(Carriage carriage : carriages){
            total+=carriage.getPassengerCapacity();
        }
        return total;
    }

    public int getTotalFreeSeats(){
        return getTotalCapacity()-getTotalPassengers();
    }

    public double getTotalLuggageWeight() {
        double total = 0.0;
        for (Carriage c : carriages) {
            total += c.getLuggageWeight();
        }
        return total;
    }


    @Override
    public String toString() {
        return "PassengerTrain{" +
                "тип='" + getTypeOfTransport() + '\'' +
                ", скорость=" + getSpeed() +
                ", топливо=" + getTypeOfFuel() +
                ", вагонов=" + carriages.size() +
                ", пассажиров=" + getTotalPassengers() + "/" + getTotalCapacity() +
                " (свободно: " + getTotalFreeSeats() + ")" +
                ", багаж=" + String.format("%.1f", getTotalLuggageWeight()) + "kg" +
                '}';
    }


}