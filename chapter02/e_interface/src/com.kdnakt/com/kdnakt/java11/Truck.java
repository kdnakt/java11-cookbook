package com.kdnakt.java11;

public interface Truck extends Vehicle {
    int getPayloadPounds();

    default int getPayloadKg() {
        return (int) Math.round(0.454 * getPayloadPounds());
    }
}