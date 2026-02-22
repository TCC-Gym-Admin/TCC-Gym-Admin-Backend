package com.example.TCC_Gym_Admin.entities.Enums;

public enum Position {

    PERSONAL_TRAINER (1);

    private int code;

    Position(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Position valueOf(int code) {
        for (Position p : Position.values()) {
            if (p.code == code) {
                return p;
            }
        }
        throw new IllegalArgumentException("Invalid position code: " + code);
    }
}
