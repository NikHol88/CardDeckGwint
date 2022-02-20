package org.example.consts;

public enum Frakt {
    NORD_KIND(0),
    NILF(1),
    MONST(2),
    SKOY(3),
    SKELIG(4),
    OTHER(5);
    private final int value;

    Frakt(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
