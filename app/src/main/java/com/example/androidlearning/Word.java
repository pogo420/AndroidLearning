package com.example.androidlearning;

public class Word {
    private final int NO_IMAGE_PROVIDED = -1;
    private final String english;
    private final String meWok;
    private final int audioResourceId;
    private int imageResourceId = NO_IMAGE_PROVIDED;

    public Word(String english, String meWok, int audioResourceId) {
        this.english = english;
        this.meWok = meWok;
        this.audioResourceId = audioResourceId;
    }

    public Word(String english, String meWok, int imageResourceId, int audioResourceId) {
        this.english = english;
        this.meWok = meWok;
        this.imageResourceId = imageResourceId;
        this.audioResourceId = audioResourceId;
    }

    public String getEnglish() {
        return english;
    }

    public int getAudioResourceId() {
        return audioResourceId;
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
