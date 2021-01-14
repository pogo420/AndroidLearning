package com.example.androidlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

//    private ArrayList<Word> getNumbers(){
//
//        // Create a list of words
//        ArrayList<Word> words = new ArrayList<Word>();
//        words.add(new Word("one", "lutti"));
//        words.add(new Word("two", "otiiko"));
//        words.add(new Word("three", "tolookosu"));
//        words.add(new Word("four", "oyyisa"));
//        words.add(new Word("five", "massokka"));
//        words.add(new Word("six", "temmokka"));
//        words.add(new Word("seven", "kenekaku"));
//        words.add(new Word("eight", "kawinta"));
//        words.add(new Word("nine", "wo’e"));
//        words.add(new Word("ten", "na’aacha"));
//        return words;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        TextView viewText = new TextView(this);
        viewText.setPadding(16, 16, 16, 16);

        // Creating adapter which needs text and text view
        WordsAdapter numberList = new WordsAdapter(this, MiworkDIct.getNumbers());

        // Creating list view
        ListView view = findViewById(R.id.list);


        // setting the adapter
        view.setAdapter(numberList);

        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = MiworkDIct.getNumbers().get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();
            }
        });

    }
}