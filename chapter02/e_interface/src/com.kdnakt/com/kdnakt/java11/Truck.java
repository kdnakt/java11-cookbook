package com.kdnakt.java11;

public interface Truck extends Vehicle {
    int getPayloadPounds();

    default int getPayloadKg() {
        return (int) Math.round(0.454 * getPayloadPounds());
    }

    static int convertKgToPounds(int kgs) {
        return (int) Math.round(2.205 * kgs);
    }
}