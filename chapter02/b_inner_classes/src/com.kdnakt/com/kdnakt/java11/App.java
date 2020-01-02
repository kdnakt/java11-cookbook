package com.kdnakt.java11;

public class App {
    public static void main(String... arg) {
        double timeSec = 10.0;
        int horsePower = 246;
        int vehicleWeight = 4000;
        Vehicle vehicle = new Vehicle(vehicleWeight, horsePower) {
            public double getSpeedMph(double timeSec) {
                double v = 2.0 * horsePower * 746 * timeSec * 32.17 / vehicleWeight;
                return Math.round(Math.sqrt(v) * 0.68);
            }
        };
        System.out.println("Vehicle speed (" + timeSec + " sec)=" + vehicle.getSpeedMph(timeSec) + " mph");
    }
}