package com.example.androidlearning;

public class QuakeData {

    private final String city;
    private final String date;
    private final double magnitude;

    public QuakeData(String city, String date, double magnitude) {
        this.city = city;
        this.date = date;
        this.magnitude = magnitude;
    }

    public String getCity() {
        return city;
    }

    public String getDate() {
        return date;
    }

    public double getMagnitude() {
        return magnitude;
    }
}
