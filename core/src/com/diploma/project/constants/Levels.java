package com.diploma.project.constants;

/**
 * Уровни
 */
public enum Levels {
    One(1),
    Two(2),
    Three(3),
    Four(4),
    Five(5);

    int value;

    private Levels(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
