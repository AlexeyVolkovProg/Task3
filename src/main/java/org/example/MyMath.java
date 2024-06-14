package org.example;

public class MyMath {
    public static double roundTwoSigns(double number) {
        return Math.round(number * 100.0) / 100.0;
    }

    public static double ceilTwoSigns(double number) {
        return Math.ceil(number * 100.0) / 100.0;
    }

    public static double roundTenSigns(double number) {
        return Math.round(number * 10000000000.0) / 10000000000.0;
    }
}
