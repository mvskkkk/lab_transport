package by.bsu.init;

import by.bsu.create.CarriageCreator;
import by.bsu.entity.PassengerTrain;
import by.bsu.entity.TypeOfFuel;
import by.bsu.exception.InvalidDataException;
import by.bsu.parse.CarParser;
import by.bsu.util.CarriageType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;

public class TrainStorageInitializer {
    private static final Logger LOGGER = LogManager.getLogger(TrainStorageInitializer.class);
    public PassengerTrain init(LinkedList<String> strings) throws InvalidDataException {
        PassengerTrain train = new PassengerTrain("Второй", 200, TypeOfFuel.BATTERY);
        CarParser carParser;
        CarriageCreator carCreator;

        while (!strings.isEmpty()) {
            String line = strings.removeFirst();
            carParser = new CarParser(line);
            carCreator = new CarriageCreator(carParser);

            try {
                CarriageType type = carParser.takeType();

                switch (type) {
                    case SEAT -> train.addCarriage(carCreator.createSeat());
                    case BERTH -> train.addCarriage(carCreator.createBerth());
                    case COMPARTMENT -> train.addCarriage(carCreator.createCompartment());
                    case LUXURY -> train.addCarriage(carCreator.createLuxury());
                    case RESTAURANT -> train.addCarriage(carCreator.createRestaurant());
                    default -> {
                        String msg = "Неизвестный тип вагона: " + type + " в строке: " + line;
                        LOGGER.log(Level.ERROR, msg);
                        throw new InvalidDataException(msg);
                    }
                }

                LOGGER.log(Level.INFO, "Успешно добавлен вагон: {}", type);

            } catch (InvalidDataException e) {
                LOGGER.log(Level.ERROR, "Ошибка парсинга строки: {}", line, e);
                throw e;
            }
        }
        LOGGER.log(Level.INFO, "Поезд успешно сформирован! Всего вагонов: {}", train.getCarriages().size());
        return train;
    }
}