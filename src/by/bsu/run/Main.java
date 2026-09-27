package by.bsu.run;

//8. Транспорт. Определить иерархию подвижного состава железнодорожного транспорта. Создать пассажирский поезд.
//Подсчитать общую численность пассажиров и багажа. Провести сортировку вагонов поезда на основе уровня комфортности.
//Найти в поезде вагоны, соответствующие заданному диапазону параметров числа пассажиров.

import by.bsu.action.CarriageFinder;
import by.bsu.action.CarriageSorter;
import by.bsu.entity.Carriage;
import by.bsu.entity.PassengerTrain;
import by.bsu.exception.InvalidDataException;
import by.bsu.init.TrainStorageInitializer;
import by.bsu.read.CarReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.info("СТАРТ");
        LinkedList<String> lines = CarReader.readLines("carriages.txt");
        LOG.info("Прочитано строк: {}", lines.size());

        PassengerTrain train;
        try {
            train = new TrainStorageInitializer().init(lines);
            LOG.info("Поезд создан. Вагонов: {}", train.getCarriages().size());
        } catch (InvalidDataException e) {
            LOG.error("Ошибка: {}", e.getMessage());
            return;
        }

        new CarriageSorter().sortByComfort(train);

        LOG.info("СОСТАВ");
        for (Carriage c : train.getCarriages()) {
            LOG.info("[{}] {}", c.getPriority().getLevel(), c);
        }
        LOG.info("Мест: {}", train.getTotalCapacity());
        LOG.info("Свободно: {}", train.getTotalFreeSeats());
        LOG.info("Багаж: " + train.getTotalLuggageWeight() + " кг");
        LOG.info("ВАГОНЫ С ПАССАЖИРАМИ ОТ 30 ДО 70");
        List<Carriage> found = CarriageFinder.findByPassengerRange(train, 30, 70);
        if (found.isEmpty()) {
            LOG.info("  Нет вагонов.");
        } else {
            for (Carriage c : found) {
                LOG.info("  • {} (пассажиров: {}/{})",
                        c.getClass().getSimpleName(),
                        c.getCurrentPassengers(),
                        c.getPassengerCapacity());
            }
        }
        LOG.info("  Всего: {} вагон(ов)\n", found.size());

        LOG.info("КОНЕЦ");
    }
}