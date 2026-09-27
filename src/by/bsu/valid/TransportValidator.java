package by.bsu.valid;

import by.bsu.util.CarriageType;
import by.bsu.util.TransportTags;

public class TransportValidator {

    public static boolean isValidTransport(String line) {
        String upper = line.toUpperCase();
        return upper.contains(TransportTags.TYPE) &&
                upper.contains(TransportTags.NUMBER) &&
                upper.contains(TransportTags.CAPACITY) &&
                upper.contains(TransportTags.LUGGAGE) &&
                upper.contains(TransportTags.CARGO);
    }

    public static boolean isValidSeat(String line) {
        String upper = line.toUpperCase();
        return isValidTransport(line) &&
                upper.contains(TransportTags.ROWS) &&
                upper.contains(TransportTags.SEAT_TYPE) &&
                upper.contains(TransportTags.TABLE);
    }

    public static boolean isValidBerth(String line) {
        String upper = line.toUpperCase();
        return isValidTransport(line) &&
                upper.contains(TransportTags.BERTHS) &&
                upper.contains(TransportTags.SIDE) &&
                upper.contains(TransportTags.UPPER);
    }

    public static boolean isValidCompartment(String line) {
        String upper = line.toUpperCase();
        return isValidTransport(line) &&
                upper.contains(TransportTags.COMPARTMENTS) &&
                upper.contains(TransportTags.AC);
    }

    public static boolean isValidLuxury(String line) {
        String upper = line.toUpperCase();
        return isValidTransport(line) &&
                upper.contains(TransportTags.SHOWER) &&
                upper.contains(TransportTags.MINIBAR) &&
                upper.contains(TransportTags.TV);
    }

    public static boolean isValidRestaurant(String line) {
        String upper = line.toUpperCase();
        return isValidTransport(line) &&
                upper.contains(TransportTags.TABLES) &&
                upper.contains(TransportTags.KITCHEN);
    }

    public static boolean isValidCarriageType(String typeStr) {
        CarriageType[] types = CarriageType.values();
        for (CarriageType type : types) {
            if (type.toString().equalsIgnoreCase(typeStr)) {
                return true;
            }
        }
        return false;
    }
}