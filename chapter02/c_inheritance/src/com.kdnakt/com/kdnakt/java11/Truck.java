package com.kdnakt.java11;

public class Truck extends Vehicle {
    private int payload;

    public Truck(int payloadPounds, int weightPounds, int horsePower) {
        super(weightPounds, horsePower);
        this.payload = payloadPounds;
    }

    public int getPayload() {
        return this.payload;
    }

    public double getSpeedMph(double timeSec) {
        int weight = this.weightPounds + this.payload;
        double v = 2.0 * this.horsePower * 746 * timeSec * 32.17 / weight;
        return Math.round(Math.sqrt(v) * 0.68);
    }
}