package com.example.androidlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        TextView viewText = new TextView(this);
        viewText.setPadding(16, 16, 16, 16);

        // Creating adapter which needs text and text view
        WordsAdapter numberList = new WordsAdapter(this, MiworkDIct.getFamily());

        // Creating list view
        ListView view = findViewById(R.id.list);

        // setting the adapter
        view.setAdapter(numberList);

    }
}