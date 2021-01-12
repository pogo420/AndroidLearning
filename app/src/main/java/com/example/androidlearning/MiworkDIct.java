package com.example.androidlearning;

import java.util.ArrayList;

public interface MiworkDIct {

    static ArrayList<Word> getNumbers(){
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "lutti", R.drawable.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight));
        words.add(new Word("nine", "wo’e", R.drawable.number_nine));
        words.add(new Word("ten", "na’aacha", R.drawable.number_ten));
        return words;
    }

    static ArrayList<Word> getColours(){
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red));
        words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow));
        words.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow));
        words.add(new Word("green", "chokokki", R.drawable.color_green));
        words.add(new Word("brown", "ṭakaakki", R.drawable.color_brown));
        words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray));
        words.add(new Word("black", "kululli", R.drawable.color_black));
        words.add(new Word("white", "kelelli", R.drawable.color_white));
        return words;
    }

    static ArrayList<Word> getFamily(){
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "әpә", R.drawable.family_father));
        words.add(new Word("mother", "әṭa", R.drawable.family_mother));
        words.add(new Word("son", "angsi", R.drawable.family_son));
        words.add(new Word("daughter", "tune", R.drawable.family_daughter));
        words.add(new Word("older brother", "taachi", R.drawable.family_older_brother));
        words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother));
        words.add(new Word("older sister", "teṭe", R.drawable.family_older_sister));
        words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister));
        words.add(new Word("grandmother ", "ama", R.drawable.family_grandmother));
        words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather));
        return words;
    }

    static ArrayList<Word> getPhrases(){
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "minto wuksus", R.mipmap.ic_launcher_round));
        words.add(new Word("What is your name?", "tinnә oyaase'nә", R.mipmap.ic_launcher_round));
        words.add(new Word("My name is...", "oyaaset...", R.mipmap.ic_launcher_round));
        words.add(new Word("How are you feeling?", "michәksәs?", R.mipmap.ic_launcher_round));
        words.add(new Word("I’m feeling good.", "kuchi achit", R.mipmap.ic_launcher_round));
        words.add(new Word("Are you coming?", "әәnәs'aa?", R.mipmap.ic_launcher_round));
        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.mipmap.ic_launcher_round));
        words.add(new Word("I’m coming.", "әәnәm", R.mipmap.ic_launcher_round));
        words.add(new Word("Let’s go.", "yoowutis", R.mipmap.ic_launcher_round));
        words.add(new Word("Come here.", "әnni'nem", R.mipmap.ic_launcher_round));
        return words;
    }

}
