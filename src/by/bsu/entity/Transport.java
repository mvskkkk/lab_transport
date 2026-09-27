package by.bsu.entity;

import by.bsu.exception.InvalidVINException;
import by.bsu.exception.InvalidYearOfReleaseException;

public abstract class Transport {
    private String typeOfTransport;
    private double speed;
    private int yearOfRelease;
    private String VIN;
    private Producer producer;

    protected Transport(String typeOfTransport, double speed) {
        this.typeOfTransport = typeOfTransport;
        this.speed = speed;
    }

    public String getTypeOfTransport() { return typeOfTransport; }
    public void setTypeOfTransport(String typeOfTransport) {
        this.typeOfTransport = typeOfTransport;
    }

    public double getSpeed() { return speed; }
    public void setSpeed(double speed) { this.speed = speed; }

    public int getYearOfRelease() { return yearOfRelease; }
    public void setYearOfRelease(int yearOfRelease) throws InvalidYearOfReleaseException {
        int currentYear = java.time.Year.now().getValue();
        if (yearOfRelease > currentYear || yearOfRelease < 1800) {
            throw new InvalidYearOfReleaseException("Invalid year: " + yearOfRelease);
        }
        this.yearOfRelease = yearOfRelease;
    }

    public String getVIN() { return VIN; }
    public void setVIN(String VIN) throws InvalidVINException {
        if (VIN == null || !VIN.matches("[A-HJ-NPR-Z0-9]{17}")) {
            throw new InvalidVINException("Invalid VIN format");
        }
        this.VIN = VIN;
    }

    public Producer getProducer() { return producer; }
    public void setProducer(Producer producer) { this.producer = producer; }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "type='" + typeOfTransport + '\'' +
                ", speed=" + speed +
                ", year=" + yearOfRelease +
                ", VIN='" + VIN + '\'' +
                ", producer=" + producer +
                '}';
    }

}