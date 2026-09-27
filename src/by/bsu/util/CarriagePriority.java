package by.bsu.util;

public enum CarriagePriority {
    LUXURY(5),
    COMPARTMENT(4),
    BERTH(3),
    SEAT(2),
    RESTAURANT(1);

    private final int level;

    CarriagePriority(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
    }