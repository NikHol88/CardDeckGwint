package org.example.consts;

public enum Carttype {
    MELEE(0),
    BOW(1),
    SIEGE(2),
    SPECIAL(3);
    private final int value;

    Carttype(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
