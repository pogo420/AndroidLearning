package com.example.androidlearning;

public class QuakeData {

    private final String city;
    private final String date;
    private final float magnitude;

    public QuakeData(String city, String date, float magnitude) {
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

    public float getMagnitude() {
        return magnitude;
    }
}
