package com.example.androidlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {

    private ArrayList<Word> getNumbers(){

        // Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "lutti"));
        words.add(new Word("two", "otiiko"));
        words.add(new Word("three", "tolookosu"));
        words.add(new Word("four", "oyyisa"));
        words.add(new Word("five", "massokka"));
        words.add(new Word("six", "temmokka"));
        words.add(new Word("seven", "kenekaku"));
        words.add(new Word("eight", "kawinta"));
        words.add(new Word("nine", "wo’e"));
        words.add(new Word("ten", "na’aacha"));
        return words;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
//        // Referencing a linear layout
//        LinearLayout rootView = findViewById(R.id.numbers_layout);
//        // Adding views
//        for (String num : getNumbers()) {
//            TextView view = new TextView(this);
//            view.setText(num);
//            view.setPadding(16, 16, 16, 16);
//            rootView.addView(view);
//        }
        TextView viewText = new TextView(this);
        viewText.setPadding(16, 16, 16, 16);

        // Creating adapter which needs text and text view
        WordsAdapter numberList = new WordsAdapter(this, getNumbers());

        // Creating list view
        ListView view = findViewById(R.id.number_list);

        // setting the adapter
        view.setAdapter(numberList);

    }
}