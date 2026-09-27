package by.bsu.action;

import by.bsu.entity.Carriage;
import by.bsu.entity.PassengerTrain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CarriageFinder {

    private static final Logger logger = LogManager.getLogger(CarriageFinder.class);
    public static List<Carriage> findByPassengerRange(PassengerTrain train, int min, int max) {
        if (train == null) {
            throw new IllegalArgumentException("Поезд не может быть null");
        }
        if (min > max) {
            throw new IllegalArgumentException("Минимальное значение не может быть больше максимального: " + min + " > " + max);
        }

        List<Carriage> result = new ArrayList<>();
        List<Carriage> carriages = train.getCarriages();

        logger.info("Поиск вагонов с пассажирами от {} до {} (всего вагонов: {})", min, max, carriages.size());

        for (Carriage carriage : carriages) {
            int currentPassengers = carriage.getCurrentPassengers();
            if (currentPassengers >= min && currentPassengers <= max) {
                result.add(carriage);
                logger.debug("Найден подходящий вагон: {} (пассажиров: {})", carriage.getClass().getSimpleName(), currentPassengers);
            }
        }
        logger.info("Найдено {} вагонов в диапазоне [{}, {}]", result.size(), min, max);
        return result;
    }

}