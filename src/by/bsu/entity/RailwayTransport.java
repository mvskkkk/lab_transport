package by.bsu.entity;
import java.util.Objects;

public abstract class RailwayTransport extends Transport {
    private TypeOfFuel typeOfFuel;
    private int numberOfCarriages;

    protected RailwayTransport(String type, double speed, TypeOfFuel typeOfFuel) {
        super(type, speed);
        this.typeOfFuel = Objects.requireNonNull(typeOfFuel, "Fuel type cannot be null");
        this.numberOfCarriages = 0;
    }

    protected RailwayTransport(String type, double speed, TypeOfFuel typeOfFuel, int numberOfCarriages) {
        this(type, speed, typeOfFuel);
        setNumberOfCarriages(numberOfCarriages);
    }

    public TypeOfFuel getTypeOfFuel() { return typeOfFuel; }
    public void setTypeOfFuel(TypeOfFuel typeOfFuel) {
        this.typeOfFuel = Objects.requireNonNull(typeOfFuel, "Fuel type cannot be null");
    }

    public int getNumberOfCarriages() { return numberOfCarriages; }
    public void setNumberOfCarriages(int numberOfCarriages) {
        if (numberOfCarriages < 0) {
            throw new IllegalArgumentException("Number of carriages cannot be negative");
        }
        this.numberOfCarriages = numberOfCarriages;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "type='" + getTypeOfTransport() + '\'' +
                ", speed=" + getSpeed() +
                ", year=" + getYearOfRelease() +
                ", VIN='" + getVIN() + '\'' +
                ", producer=" + getProducer() +
                ", fuel=" + typeOfFuel +
                ", carriages=" + numberOfCarriages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RailwayTransport) || !super.equals(o)) return false;
        RailwayTransport that = (RailwayTransport) o;
        return numberOfCarriages == that.numberOfCarriages &&
                typeOfFuel == that.typeOfFuel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfFuel, numberOfCarriages);
    }
}