package org.example.consts;

public enum Skill {

    STRONGCON(0),/*Прочная связь*/
    SPY(1),
    SURSTREN(2),/*Прилив сил*/
    MEDIC(3),
    DOUBLE(4),
    KILL(5),
    NOSKILL(6),
    TWOTYPE(7),
    GORN(8);
    private final int value;


    Skill(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
