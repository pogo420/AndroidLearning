package com.example.androidlearning;

public class Word {
    private final int NO_IMAGE_PROVIDED = -1;
    private final String english;
    private final String meWok;
    private int imageResourceId = NO_IMAGE_PROVIDED;

    public Word(String english, String meWok) {
        this.english = english;
        this.meWok = meWok;
    }

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

    public boolean hasImage(){
        return imageResourceId != NO_IMAGE_PROVIDED;
    }
}
