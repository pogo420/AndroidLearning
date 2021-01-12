package com.example.androidlearning;

public class Word {
    private final String english;
    private final String meWok;
    private final int imageResourceId;

    public Word(String english, String meWok, int imageResourceId) {
        this.english = english;
        this.meWok = meWok;
        this.imageResourceId = imageResourceId;
    }

    public String getEnglish() {
        return english;
    }

    public String getMeWok() {
        return meWok;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
