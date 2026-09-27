package by.bsu.action;

import by.bsu.entity.Carriage;
import by.bsu.entity.PassengerTrain;
import by.bsu.compare.CarriageComfortComparator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.LinkedList;

public class CarriageSorter {
    private static final Logger LOGGER = LogManager.getLogger(CarriageSorter.class);

    public void sortByComfort(PassengerTrain train) {
        LinkedList<Carriage> carriages = new LinkedList<>(train.getCarriages());
        Collections.sort(carriages, new CarriageComfortComparator());

        try {
            train.setCarriages(carriages);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, "Problem with set carriages to train", e);
        }
    }
}