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

    private List<String> getNumbers(){
        return Arrays.asList("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten");
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
        ArrayAdapter<String> numberList = new ArrayAdapter<>(this,R.layout.list_text_layout, getNumbers());

        // Creating list view
        ListView view = findViewById(R.id.number_list);
        view.setAdapter(numberList);

    }
}