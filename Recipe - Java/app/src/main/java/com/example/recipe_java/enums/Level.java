package com.example.recipe_java.enums;

public enum Level {
    EASY,
    MEDIUM,
    HARD;

    // Example: more code
    // Example: return value
    public String getDescription(Level level) {
        switch (level) {
            case EASY:
                return "Recept je veoma jednostavan, trebalo bi da probaš";
            case HARD:
                return "Veoma teško, budi pažljiv";
            case MEDIUM:
                return "Ovo je komplikovanije, obrati pažnju!";
            default:
                return "";
        }
    }
}
