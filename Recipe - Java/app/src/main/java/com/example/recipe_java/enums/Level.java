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
                return "This recipe is very easy, you should try";
            case HARD:
                return "Very hard, be careful";
            case MEDIUM:
                return "This is more complicated, pay attention!";
            default:
                return "";
        }
    }
}
