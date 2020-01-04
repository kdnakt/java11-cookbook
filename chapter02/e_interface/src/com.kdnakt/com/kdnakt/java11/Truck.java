package com.kdnakt.java11;

public interface Truck extends Vehicle {
    int getPayloadPounds();

    default int getPayloadKg(int pounds) {
        return convertPoundsToKg(pounds);
    }

    static int convertKgToPounds(int kgs) {
        return (int) Math.round(2.205 * kgs);
    }

    default int getWeightKg(int pounds) {
        return convertPoundsToKg(pounds);
    }

    private int convertPoundsToKg(int pounds) {
        return (int) Math.round(0.454 * pounds);
    }
}