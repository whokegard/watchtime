package com.example.watchtime.model.enums;

public enum Rating {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10");

    private final String ratings;

    Rating(String ratings) {
        this.ratings = ratings;
    }

    public String getRating() {
        return ratings;
    }
}
