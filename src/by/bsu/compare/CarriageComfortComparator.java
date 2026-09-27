package by.bsu.compare;

import by.bsu.entity.Carriage;
import by.bsu.util.CarriagePriority;
import java.util.Comparator;

public class CarriageComfortComparator implements Comparator<Carriage> {

    @Override
    public int compare(Carriage c1, Carriage c2) {
        CarriagePriority p1 = c1.getPriority();
        CarriagePriority p2 = c2.getPriority();

        return Integer.compare(p2.getLevel(), p1.getLevel());
    }
}