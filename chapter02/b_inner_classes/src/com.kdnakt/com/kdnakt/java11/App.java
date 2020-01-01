package com.kdnakt.java11;

public class App {
    public static void main(String... arg) {
        double timeSec = 10.0;
        int horsePower = 246;
        int vehicleWeight = 4000;
        Vehicle vehicle = new Vehicle(vehicleWeight, horsePower);
        System.out.println("Vehicle speed (" + timeSec + " sec)=" + vehicle.getSpeedMph(timeSec) + " mph");
    }
}