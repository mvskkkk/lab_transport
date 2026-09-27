package by.bsu.parse;

import by.bsu.exception.InvalidDataException;
import by.bsu.util.CarriageType;
import by.bsu.util.TransportTags;
import by.bsu.valid.TransportValidator;

public class CarParser {
    private final String source;

    public CarParser(String line) throws InvalidDataException {
        this.source = line.toUpperCase();
        if (!TransportValidator.isValidTransport(source)) {
            throw new InvalidDataException("Not valid transport");
        }
    }

    public String extractAfter(String tag) throws InvalidDataException {
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(tag + "([^\\s|]+)");
        java.util.regex.Matcher matcher = pattern.matcher(source);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        throw new InvalidDataException("Tag not found: " + tag);
    }

    public CarriageType takeType() throws InvalidDataException {
        String typeStr = extractAfter(TransportTags.TYPE);
        if (TransportValidator.isValidCarriageType(typeStr)) {
            return CarriageType.valueOf(typeStr);
        }
        throw new InvalidDataException("Not valid type");
    }

    public int takeNumber() throws InvalidDataException {
        return Integer.parseInt(extractAfter(TransportTags.NUMBER));
    }

    public int takeCapacity() throws InvalidDataException {
        return Integer.parseInt(extractAfter(TransportTags.CAPACITY));
    }

    public double takeLuggage() throws InvalidDataException {
        return Double.parseDouble(extractAfter(TransportTags.LUGGAGE));
    }

    public double takeCargo() throws InvalidDataException {
        return Double.parseDouble(extractAfter(TransportTags.CARGO));
    }

    public int takeRows() throws InvalidDataException {
        if (!TransportValidator.isValidSeat(source)) {
            throw new InvalidDataException("Not valid seat");
        }
        return Integer.parseInt(extractAfter(TransportTags.ROWS));
    }

    public String takeSeatType() throws InvalidDataException {
        if (!TransportValidator.isValidSeat(source)) {
            throw new InvalidDataException("Not valid seat");
        }
        return extractAfter(TransportTags.SEAT_TYPE);
    }

    public boolean takeHasTable() throws InvalidDataException {
        if (!TransportValidator.isValidSeat(source)) {
            throw new InvalidDataException("Not valid seat");
        }
        return Boolean.parseBoolean(extractAfter(TransportTags.TABLE));
    }

    public int takeBerths() throws InvalidDataException {
        if (!TransportValidator.isValidBerth(source)) {
            throw new InvalidDataException("Not valid berth");
        }
        return Integer.parseInt(extractAfter(TransportTags.BERTHS));
    }

    public boolean takeSide() throws InvalidDataException {
        if (!TransportValidator.isValidBerth(source)) {
            throw new InvalidDataException("Not valid berth");
        }
        return Boolean.parseBoolean(extractAfter(TransportTags.SIDE));
    }

    public boolean takeUpper() throws InvalidDataException {
        if (!TransportValidator.isValidBerth(source)) {
            throw new InvalidDataException("Not valid berth");
        }
        return Boolean.parseBoolean(extractAfter(TransportTags.UPPER));
    }

    public int takeCompartments() throws InvalidDataException {
        if (!TransportValidator.isValidCompartment(source)) {
            throw new InvalidDataException("Not valid compartment");
        }
        return Integer.parseInt(extractAfter(TransportTags.COMPARTMENTS));
    }

    public boolean takeAC() throws InvalidDataException {
        if (!TransportValidator.isValidCompartment(source)) {
            throw new InvalidDataException("Not valid compartment");
        }
        return Boolean.parseBoolean(extractAfter(TransportTags.AC));
    }

    public boolean takeShower() throws InvalidDataException {
        if (!TransportValidator.isValidLuxury(source)) {
            throw new InvalidDataException("Not valid luxury");
        }
        return Boolean.parseBoolean(extractAfter(TransportTags.SHOWER));
    }

    public boolean takeMinibar() throws InvalidDataException {
        if (!TransportValidator.isValidLuxury(source)) {
            throw new InvalidDataException("Not valid luxury");
        }
        return Boolean.parseBoolean(extractAfter(TransportTags.MINIBAR));
    }

    public boolean takeTV() throws InvalidDataException {
        if (!TransportValidator.isValidLuxury(source)) {
            throw new InvalidDataException("Not valid luxury");
        }
        return Boolean.parseBoolean(extractAfter(TransportTags.TV));
    }

    public int takeTables() throws InvalidDataException {
        if (!TransportValidator.isValidRestaurant(source)) {
            throw new InvalidDataException("Not valid restaurant");
        }
        return Integer.parseInt(extractAfter(TransportTags.TABLES));
    }

    public boolean takeKitchen() throws InvalidDataException {
        if (!TransportValidator.isValidRestaurant(source)) {
            throw new InvalidDataException("Not valid restaurant");
        }
        return Boolean.parseBoolean(extractAfter(TransportTags.KITCHEN));
    }
}