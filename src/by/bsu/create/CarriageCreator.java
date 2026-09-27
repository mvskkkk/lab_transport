package by.bsu.create;

import by.bsu.entity.typesOfCarriages.*;
import by.bsu.exception.InvalidDataException;
import by.bsu.parse.CarParser;
import by.bsu.util.TransportTags;

public class CarriageCreator {

    private final CarParser parser;

    public CarriageCreator(CarParser parser) {
        this.parser = parser;
    }

    public SeatCarriage createSeat() throws InvalidDataException {
        return new SeatCarriage(
                parser.takeNumber(),
                parser.takeCapacity(),
                takeCurrentPassengers(),
                parser.takeLuggage(),
                parser.takeCargo(),
                parser.takeRows(),
                parser.takeSeatType(),
                parser.takeHasTable()
        );
    }

    public BerthCarriage createBerth() throws InvalidDataException {
        return new BerthCarriage(
                parser.takeNumber(),
                parser.takeCapacity(),
                takeCurrentPassengers(),
                parser.takeLuggage(),
                parser.takeCargo(),
                parser.takeBerths(),
                parser.takeSide(),
                parser.takeUpper()
        );
    }

    public CompartmentCarriage createCompartment() throws InvalidDataException {
        return new CompartmentCarriage(
                parser.takeNumber(),
                parser.takeCapacity(),
                takeCurrentPassengers(),
                parser.takeLuggage(),
                parser.takeCargo(),
                parser.takeCompartments(),
                parser.takeAC()
        );
    }

    public LuxuryCarriage createLuxury() throws InvalidDataException {
        return new LuxuryCarriage(
                parser.takeNumber(),
                parser.takeCapacity(),
                takeCurrentPassengers(),
                parser.takeLuggage(),
                parser.takeCargo(),
                parser.takeShower(),
                parser.takeMinibar(),
                parser.takeTV()
        );
    }

    public RestaurantCarriage createRestaurant() throws InvalidDataException {
        return new RestaurantCarriage(
                parser.takeNumber(),
                parser.takeCapacity(),
                takeCurrentPassengers(),
                parser.takeLuggage(),
                parser.takeCargo(),
                parser.takeTables(),
                parser.takeKitchen()
        );
    }

    private int takeCurrentPassengers() {
        try {
            String currentStr = parser.extractAfter(TransportTags.CURRENT);
            return currentStr != null ? Integer.parseInt(currentStr.trim()) : 0;
        } catch (Exception e) {
            return 0;
        }
    }
}