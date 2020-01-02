package com.kdnakt.java11;

public class Vehicle {
    private int weightPounds;
    private int horsePower;

    public Vehicle(int weightPounds, int horsePower) {
        this.weightPounds = weightPounds;
        this.horsePower = horsePower;
    }

    private int getWeightPounds() {
        return weightPounds;
    }

    public double getSpeedMph(double timeSec) {
        class Engine {
            private int horsePower;

            private Engine(int horsePower) {
                this.horsePower = horsePower;
            }

            private double getSpeedMph(double timeSec) {
                double v = 2.0 * this.horsePower * 746 * timeSec * 32.17 / getWeightPounds();
                return Math.round(Math.sqrt(v) * 0.68);
            }
        }
        Engine engine = new Engine(this.horsePower);
        return engine.getSpeedMph(timeSec);
    }
}