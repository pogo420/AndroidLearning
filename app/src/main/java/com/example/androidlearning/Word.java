package com.example.androidlearning;

public class Word {
    private final String english;
    private final String meWok;

    public Word(String english, String meWok) {
        this.english = english;
        this.meWok = meWok;
    }

    public String getEnglish() {
        return english;
    }

    public String getMeWok() {
        return meWok;
    }
}
